package benchmarkdp.datagenerator.mutation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.examples.blackbox.UtilitiesLibrary;
import org.eclipse.m2m.qvt.oml.util.Log;
import org.eclipse.m2m.qvt.oml.util.WriterLog;

import benchmarkdp.datagenerator.model.PIM.PIMPackage;

public class Mutator {

	int n;
	int m;

	private List<MutationOperatorInterface> mutationsPIM;
	private List<MutationOperatorInterface> mutationsPIM2PSM;
	private List<MutationOperatorInterface> mutationsPSM;

	private List<TestModel> testModels;

	private List<OCLEvaluatorInterface> evaluators;

	private CodeGenerator codeGenerator;

	private String basePathPIMTransform = "file://Users/kresimir/Projects/TestDataGenerator/TestDataGenerator/MutationOperators/transforms/";

	public Mutator() {

		TransformationExecutor.BlackboxRegistry.INSTANCE.registerModule(UtilitiesLibrary.class,
				"m2m.qvt.oml.ExampleJavaLib", "m2m.qvt.oml");

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		PIMPackage mwp = PIMPackage.eINSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		mutationsPIM = new ArrayList<MutationOperatorInterface>();
		mutationsPIM2PSM = new ArrayList<MutationOperatorInterface>();
		mutationsPSM = new ArrayList<MutationOperatorInterface>();

		initializeMutationsPIM();
		initializeMutationsPIM2PSM();
		initializeMutationsPSM();

		testModels = new ArrayList<TestModel>();
		List<TestFeature> testFeatures = readFeatureDistributions();

		for (int i = 0; i < n; i++) {
			TestModel tm = new TestModel();
			if (i < testFeatures.size()) {
				TestFeature tf = testFeatures.get(i);
				tm.setTestFeature(tf);
			} else {
				tm.setTestFeature(new TestFeature());
			}
			tm.initialize("PIMs/Document.xmi");
			testModels.add(tm);
		}

		evaluators = new ArrayList<OCLEvaluatorInterface>();

		evaluators.add(new OCLEvaluatorPIM("pagecount", "self.pages->size()"));
		evaluators.add(new OCLEvaluatorPIM("tablecount", "self.pages.elements->selectByKind(Table)->size()"));
		evaluators.add(new OCLEvaluatorPIM("paragraphcount", "self.pages.elements->selectByKind(Paragraph)->size()"));
		evaluators.add(
				new OCLEvaluatorPIM("wordcount", "self.pages.elements->selectByKind(TextContainer).words->size()"));
		evaluators.add(new OCLEvaluatorPIM("words", "self.pages.elements->selectByKind(TextContainer).words.value"));
		evaluators.add(new OCLEvaluatorPIM("words-textbox", "self.pages.elements->selectByKind(TextBox).words.value"));

		codeGenerator = new CodeGenerator();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mutator mut = new Mutator();
		mut.mutate();
	}

	public void mutate() {

		System.out.println("Starting the transformation");
		int cnt = 0;

		// PIM mutations 
		for (int i = 0; i < testModels.size(); i++) {
			TestModel tm = testModels.get(i);
			for (int j = 0; j < mutationsPIM.size(); j++) {
				MutationOperatorInterface mo = mutationsPIM.get(j);
				if (tm.getModelType() == ModelType.PIM && mo.getSourceModel() == ModelType.PIM) {
					mutateModel(tm, mo);
				}
			}
		}
/*
		for (int f = 0; f < formats.length; f++) {

			for (int i = 0; i < n; i++) {
				DocumentMutator dm = new DocumentMutator(new DocumentHolder("Document" + cnt, "PIMs/Document.xmi"));
				cnt++;
				boolean control = false;
				for (int j = 0; j < m; j++) {
					dm.addMutation(mutations.get(j), featureDist[i][j]);
				}
				dm.addMutation(mutations.get(4), 1);
				docMut.add(dm);
			}

		}

		for (int i = 0; i < docMut.size(); i++) {
			DocumentMutator mutator = docMut.get(i);
			// PIM mutations
			mutator.mutate();
			// ground truth extraction
			for (int j = 0; j < evaluators.size(); j++) {
				evaluators.get(j).evaluateDocument(mutator.getDocumentHolder());
			}
			// PIM2PSM translation

			codeGenerator.generateCode(mutator.getDocumentHolder());
			mutator.getDocumentHolder().saveToFile(ModelType.PIM,
					"/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Models/");
			mutator.getDocumentHolder().exportGroundTruth(
					"/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/GroundTruth/");
			mutator.getDocumentHolder().saveGeneratedCode(ModelType.PSMDoc,
					"/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Macro/");

			System.out.println("Done");
		}
*/
		System.out.println("Transformation done");

	}

	private List<TestFeature> readFeatureDistributions() {
		File f = new File("resources/FeatureDistributions.tsv");
		List<TestFeature> tFeatures = new ArrayList<TestFeature>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String firstLine = br.readLine();
			String[] splFirst = firstLine.split("\t");

			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				String[] spl = line.split("\t");
				TestFeature tF = new TestFeature();
				for (int j = 0; j < spl.length; j++) {
					if (j == 0) {
						tF.setName(spl[j]);
					} else {
						tF.addFeature(splFirst[j], spl[j]);
					}
				}
				tFeatures.add(tF);
			}
			return tFeatures;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void initializeMutationsPIM() {
		mutationsPIM.add(new MutationOperator("AddPage", ModelType.PIM, ModelType.PIM,
				basePathPIMTransform + "AddPage.qvto", Arrays.asList("pagecount")));
		mutationsPIM.add(new MutationOperator("AddParagraph", ModelType.PIM, ModelType.PIM,
				basePathPIMTransform + "AddParagraph.qvto", Arrays.asList("paragraphcount")));
		mutationsPIM.add(new MutationOperator("AddTable", ModelType.PIM, ModelType.PIM,
				basePathPIMTransform + "AddTable.qvto", Arrays.asList("tablecount")));
		mutationsPIM.add(new MutationOperator("AddWord", ModelType.PIM, ModelType.PIM,
				basePathPIMTransform + "AddWord.qvto", Arrays.asList("wordcount")));
	}

	private void initializeMutationsPIM2PSM() {

	}

	private void initializeMutationsPSM() {

	}

	private void mutateModel(TestModel tm, MutationOperatorInterface mo) {

		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true);
		if (tm.getModelType() == mo.getSourceModel()) {

			// set the transformation parameters
			for (String feature : mo.getFeatures()) {
				Object value = null;
				if (tm.getTestFeature().isFeatureAvailable(feature)) {
					value = tm.getTestFeature().getFeature(feature);
				}
				context.setConfigProperty(feature, value);
			}

			TransformationExecutor executor = mo.getTransformationExecutor();
			ModelExtent input = tm.getModelExtent();
			ModelExtent output = new BasicModelExtent();
			ExecutionDiagnostic result = executor.execute(context, input, output);
			if (result.getSeverity() == Diagnostic.OK) {
				if (mo.getSourceModel() == mo.getDestinationModel()) {
					tm.setModelExtent(output);
				} else {
					TestModel nTM = new TestModel();
					nTM.initialize(tm);
					nTM.setModelExtent(output);
					nTM.setModelType(mo.getDestinationModel());
					testModels.add(nTM);
				}
			} else {
				// turn the result diagnostic into status and send it to error
				// log
				IStatus status = BasicDiagnostic.toIStatus(result);
				// Activator.getDefault().getLog().log(status);
				System.out.println(status.getMessage());
				for (IStatus st : status.getChildren()) {
					System.out.println(st.getMessage());
				}
			}

		}

	}
}
