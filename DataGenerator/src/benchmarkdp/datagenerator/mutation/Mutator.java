package benchmarkdp.datagenerator.mutation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.examples.blackbox.UtilitiesLibrary;

import benchmarkdp.datagenerator.model.PIM.PIMPackage;

public class Mutator {

	private int[][] featureDist = null;
	int n;
	int m;

	String[] formats = { "doc", "docx" };
	String[] formatCodes = { "0", "16" };
	private List<MutationOperatorInterface> mutations;

	private List<DocumentMutator> docMut;

	private List<OCLEvaluator> evaluators;

	private CodeGenerator codeGenerator;

	private String basePathPIMTransform = "file://Users/kresimir/Projects/TestDataGenerator/TestDataGenerator/MutationOperators/transforms/";

	public Mutator() {

		featureDist = readFeatureDistributions();

		TransformationExecutor.BlackboxRegistry.INSTANCE.registerModule(UtilitiesLibrary.class,
				"m2m.qvt.oml.ExampleJavaLib", "m2m.qvt.oml");

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		PIMPackage mwp = PIMPackage.eINSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		mutations = new ArrayList<MutationOperatorInterface>();

		mutations.add(new MutationOperator("AddPage", "PIM", "PSM", basePathPIMTransform + "AddPage.qvto"));
		mutations.add(new MutationOperator("AddParagraph", "PIM", "PSM", basePathPIMTransform + "AddParagraph.qvto"));
		mutations.add(new MutationOperator("AddTable", "PIM", "PSM", basePathPIMTransform + "AddTable.qvto"));
		mutations.add(new MutationOperator("AddWord", "PIM", "PSM", basePathPIMTransform + "AddWord.qvto"));

		docMut = new ArrayList<DocumentMutator>();

		evaluators = new ArrayList<OCLEvaluator>();

		evaluators.add(new OCLEvaluator("pagecount", "PIM", "self.pages->size()"));
		evaluators.add(new OCLEvaluator("tablecount", "PIM", "self.pages.elements->selectByKind(Table)->size()"));
		evaluators.add(new OCLEvaluator("paragraphcount", "PIM", "self.pages.elements->selectByKind(Paragraph)->size()"));
		evaluators.add(new OCLEvaluator("wordcount", "PIM", "self.pages.elements->selectByKind(TextContainer).words->size()"));
		evaluators.add(new OCLEvaluator("words", "PIM", "self.pages.elements->selectByKind(TextContainer).words.value"));
		evaluators.add(new OCLEvaluator("words-textbox", "PIM", "self.pages.elements->selectByKind(TextBox).words.value"));
		evaluators.add(new OCLEvaluator("format", "PIM", "self.format"));
		evaluators.add(new OCLEvaluator("columns", "PIM", "self.numColum"));
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
			mutator.getDocumentHolder().saveToFile("PIM",
					"/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Models/");
			mutator.getDocumentHolder().exportGroundTruth(
					"/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/GroundTruth/");
			mutator.getDocumentHolder().saveGeneratedCode("PSM",
					"/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Macro/");

			System.out.println("Done");
		}

		System.out.println("Transformation done");

	}

	private int[][] readFeatureDistributions() {
		File f = new File("resources/FeatureDistributions.tsv");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			String[] spl = line.split("\t");
			n = Integer.parseInt(spl[0]);
			m = Integer.parseInt(spl[1]);
			line = br.readLine();
			int[][] mat = new int[n][m];
			for (int i = 0; i < n; i++) {
				line = br.readLine();
				spl = line.split("\t");
				for (int j = 0; j < m; j++) {
					mat[i][j] = Integer.parseInt(spl[j + 1]);
				}
			}
			return mat;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
