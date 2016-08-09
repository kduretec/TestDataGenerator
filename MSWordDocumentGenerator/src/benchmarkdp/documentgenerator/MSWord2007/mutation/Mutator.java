package benchmarkdp.documentgenerator.MSWord2007.mutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.examples.blackbox.UtilitiesLibrary;

import benchmarkdp.documentgenerator.MSWord2007.MSWordPackage;

public class Mutator {

	private int[][] featureDist = new int[][] { { 1, 3, 2, 40 }, { 38, 7379, 30, 12923 }, { 3, 105, 7, 1016 },
			{ 25, 192, 0, 5846 }, { 10, 101, 0, 3143 }, { 79, 2011, 3, 17039 }, { 6, 99, 0, 2966 }, { 1, 10, 0, 175 },
			{ 123, 399, 0, 62056 }, { 10, 801, 7, 2401 }, { 1, 19, 0, 234 }, { 6, 41, 1, 2621 }, { 1, 10, 0, 260 },
			{ 10, 52, 0, 3149 }, { 12, 639, 0, 3225 }, { 2, 12, 0, 261 }, { 1, 29, 1, 381 }, { 11, 50, 0, 3139 },
			{ 2, 27, 0, 666 }, { 21, 140, 0, 4146 } };
	int n = 20;
	int m = 4;

	String[] formats = { "doc", "docx" };
	String[] formatCodes = { "0", "16" };
	private List<MutationOperatorInterface> mutations;

	private List<DocumentMutator> docMut;

	private List<OCLEvaluator> evaluators;

	private CodeGenerator codeGenerator;

	private String basePath = "file://Users/kresimir/Documents/workspace/MutationOperators/transforms/";

	public Mutator() {

		TransformationExecutor.BlackboxRegistry.INSTANCE.registerModule(UtilitiesLibrary.class,
				"m2m.qvt.oml.ExampleJavaLib", "m2m.qvt.oml");

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		MSWordPackage mwp = MSWordPackage.eINSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		mutations = new ArrayList<MutationOperatorInterface>();
		mutations.add(new MutationOperator("AddPage", basePath + "AddPage.qvto"));
		
	/*	MutationOperatorHolder mHolderTC = new MutationOperatorHolder("AddTextContainer");
		mHolderTC.addMutationOperator(new MutationOperator("AddParagraph", basePath + "AddParagraph.qvto"), 0.85);
		mHolderTC.addMutationOperator(new MutationOperator("AddTextBox", basePath + "AddTextBox.qvto"), 0.15);
		mutations.add(mHolderTC);*/
		
		mutations.add(new MutationOperator("AddParagraph", basePath + "AddParagraph.qvto"));
		mutations.add(new MutationOperator("AddTable", basePath + "AddTable.qvto"));
		
		MutationOperatorHolder mHolder = new MutationOperatorHolder("AddText");
		mHolder.addMutationOperator(new MutationOperator("AddWord", basePath + "AddWord.qvto"), 0.99);
		mHolder.addMutationOperator(new MutationOperator("AddHyperLink", basePath + "AddHyperLink.qvto"), 0.01);
		mutations.add(mHolder);
		mutations.add(new MutationOperator("ChangeColumnNumber", basePath + "ChangeColumnNumber.qvto"));
		mutations.add(new MutationOperator("AddTextBox", basePath + "AddTextBox.qvto"));
		
		docMut = new ArrayList<DocumentMutator>();

		evaluators = new ArrayList<OCLEvaluator>();

		evaluators.add(new OCLEvaluator("pagecount", "self.pages->size()"));
		evaluators.add(new OCLEvaluator("tablecount", "self.pages.elements->selectByKind(Table)->size()"));
		evaluators.add(new OCLEvaluator("paragraphcount", "self.pages.elements->selectByKind(Paragraph)->size()"));
		evaluators.add(new OCLEvaluator("wordcount", "self.pages.elements->selectByKind(TextContainer).words->size()"));
		evaluators.add(new OCLEvaluator("words", "self.pages.elements->selectByKind(TextContainer).words.value"));
		evaluators.add(new OCLEvaluator("words-textbox", "self.pages.elements->selectByKind(TextBox).words.value"));
		evaluators.add(new OCLEvaluator("format", "self.format"));
		evaluators.add(new OCLEvaluator("columns", "self.numColum"));
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
		for (int f = 0; f < formats.length; f++) {

			for (int i = 0; i < n; i++) {
				DocumentMutator dm = new DocumentMutator(
						new DocumentHolder("Document" + cnt, "PIMs/Document.xmi", formats[f], formatCodes[f]));
				cnt++;
				boolean control = false; 
				for (int j = 0; j < m; j++) {
					
					if (j>0 && control==false) {
						dm.addMutation(mutations.get(5), 1);
						control = true;
					}
					dm.addMutation(mutations.get(j), featureDist[i][j]);
				}
				dm.addMutation(mutations.get(4), 1);
				docMut.add(dm);
			}

		}

		for (int i = 0; i < docMut.size(); i++) {
			DocumentMutator mutator = docMut.get(i);
			mutator.mutate();
			for (int j = 0; j < evaluators.size(); j++) {
				evaluators.get(j).evaluateDocument(mutator.getDocumentHolder());
			}
			codeGenerator.generateCode(mutator.getDocumentHolder());
			mutator.getDocumentHolder().saveToFile(
					"/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Models/");
			mutator.getDocumentHolder().exportGroundTruth(
					"/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/GroundTruth/");
			mutator.getDocumentHolder().saveGeneratedCode(
					"/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Macro/");

			System.out.println("Done");
		}

		// Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		// MSWordPackage mwp = MSWordPackage.eINSTANCE;
		// Map<String, Object> m = reg.getExtensionToFactoryMap();
		// m.put("xmi", new XMIResourceFactoryImpl());
		//
		// ResourceSet resourceSet = new ResourceSetImpl();
		//
		// Map<String, Object> opts = new HashMap<String, Object>();
		// opts.put(XMIResource.OPTION_SCHEMA_LOCATION, true);
		//
		// Resource inResource =
		// resourceSet.getResource(URI.createURI("PIMs/Document.xmi"), true);
		// EList<EObject> inObjects = inResource.getContents();
		//
		// // create the input extent with its initial contents
		// ModelExtent input = new BasicModelExtent(inObjects);
		// // create an empty extent to catch the output
		// ModelExtent output = new BasicModelExtent();
		//
		// // setup the execution environment details ->
		// // configuration properties, logger, monitor object etc.
		// ExecutionContextImpl context = new ExecutionContextImpl();
		// context.setConfigProperty("keepModeling", true);
		//
		// // run the transformation assigned to the executor with the given
		// // input and output and execution context -> ChangeTheWorld(in, out)
		// // Remark: variable arguments count is supported
		// ExecutionDiagnostic result = executor.execute(context, input,
		// output);
		// output = input;
		// // check the result for success
		// if (result.getSeverity() == Diagnostic.OK) {
		// // the output objects got captured in the output extent
		// List<EObject> outObjects = output.getContents();
		// // let's persist them using a resource
		// ResourceSet resourceSet2 = new ResourceSetImpl();
		// Resource outResource =
		// resourceSet2.createResource(URI.createURI("PIMs/Document1.xmi"));
		// outResource.getContents().addAll(outObjects);
		// try {
		// outResource.save(opts);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// } else {
		// // turn the result diagnostic into status and send it to error
		// // log
		// IStatus status = BasicDiagnostic.toIStatus(result);
		// // Activator.getDefault().getLog().log(status);
		// System.out.println(status.getMessage());
		// for (IStatus st : status.getChildren()) {
		// System.out.println(st.getMessage());
		// }
		// }
		System.out.println("Transformation done");

	}

}
