package benchmarkdp.datagenerator.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.examples.blackbox.UtilitiesLibrary;

import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreCodeGenerator;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreGeneratorObserver;
import benchmarkdp.datagenerator.generator.codegenerator.msword.DocxCodeGenerator;
import benchmarkdp.datagenerator.generator.mutation.MutationOperator;
import benchmarkdp.datagenerator.generator.mutation.MutationOperatorInterface;
import benchmarkdp.datagenerator.generator.ocl.OCLEvaluatorInterface;
import benchmarkdp.datagenerator.generator.ocl.OCLLibreText;
import benchmarkdp.datagenerator.generator.ocl.OCLMSWordText;
import benchmarkdp.datagenerator.generator.ocl.OCLMetadata;
import benchmarkdp.datagenerator.generator.utils.Utils;
import benchmarkdp.datagenerator.model.PIM.PIMPackage;
import benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage;
import benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage;
import benchmarkdp.datagenerator.testcase.ModelType;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.TestFeature;
import benchmarkdp.datagenerator.testcase.TestModel;

public class Mutator {

	int n = 1; // number of test cases to generate

	private List<MutationOperatorInterface> mutationsPIM;
	private List<MutationOperatorInterface> mutationsPIM2PSM;
	private List<MutationOperatorInterface> mutationsPSM;

	private List<TestCase> testCases;

	private List<OCLEvaluatorInterface> evaluators;

	private List<CodeGeneratorInterface> codeGenerator;

	private List<CodeGeneratorObserverInterface> codeGeneratorObserver;

	public Mutator() {

		System.out.println("Initializing");

		Utils.initializeFolderStructure();
		System.out.println("Folder structure initialized");
		
		TransformationExecutor.BlackboxRegistry.INSTANCE.registerModule(UtilitiesLibrary.class,
				"m2m.qvt.oml.ExampleJavaLib", "m2m.qvt.oml");

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		PIMPackage mwp = PIMPackage.eINSTANCE;
		PSMDocxPackage pwd = PSMDocxPackage.eINSTANCE;
		PSMLibrePackage pld = PSMLibrePackage.eINSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		System.out.println("Modelling environment initialized");

		mutationsPIM = new ArrayList<MutationOperatorInterface>();
		mutationsPIM2PSM = new ArrayList<MutationOperatorInterface>();
		mutationsPSM = new ArrayList<MutationOperatorInterface>();

		initializeMutationsPIM();
		initializeMutationsPIM2PSM();
		initializeMutationsPSM();

		System.out.println("Mutation operators initialized");

		testCases = new ArrayList<TestCase>();
		// List<TestFeature> testFeatures = readFeatureDistributions();
		List<TestFeature> testFeatures = readSpecialCases();

		for (int i = 0; i < n; i++) {
			TestCase tCase = new TestCase(new TestModel("PIMs/Document.xmi", ModelType.PIM));
			// tCase.getTestModel().setModelType(ModelType.PIM);
			if (i < testFeatures.size()) {
				TestFeature tf = testFeatures.get(i);
				tCase.setTestFeature(tf);
			} else {
				tCase.setTestFeature(new TestFeature());
			}
			testCases.add(tCase);
		}
		System.out.println("Testcases initialized");

		initializeEvaluators();
		System.out.println("Evaluators initialized");

		initializeCodeGenerator();
		System.out.println("Code generators initialized");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mutator mut = new Mutator();
		mut.mutate();
	}

	public void mutate() {

		System.out.println("Starting Test Suite generation");

		// PIM mutations
		System.out.println("Starting PIM transformations");
		for (int i = 0; i < testCases.size(); i++) {
			TestCase tC = testCases.get(i);
			// System.out.println("Mutating according to test feature:" +
			// tC.getTestFeature().getName());
			if (tC.getTestModel().getModelType() == ModelType.PIM) {
				for (int j = 0; j < mutationsPIM.size(); j++) {
					MutationOperatorInterface mo = mutationsPIM.get(j);
					if (mo.getSourceModel() == ModelType.PIM) {
						mo.mutateTestCase(tC);
					}
				}
			}
			System.out.println("Processed " + (i + 1) + "/" + testCases.size() + " PIM");
		}

		// PIM2PSM transformation
		System.out.println("Starting PIM2PSM model transformations ");
		Random rnd = new Random();
		for (int i = 0; i < testCases.size(); i++) {
			TestCase tC = testCases.get(i);
			for (int j = 0; j < mutationsPIM2PSM.size(); j++) {
				//MutationOperatorInterface mo = mutationsPIM2PSM.get(rnd.nextInt(mutationsPIM2PSM.size()));
				MutationOperatorInterface mo = mutationsPIM2PSM.get(0);
				if (tC.getTestModel().getModelType() == ModelType.PIM && mo.getSourceModel() == ModelType.PIM
						&& mo.getDestinationModel() != ModelType.PIM) {
					mo.mutateTestCase(tC);
				}
			}
		}

		// PSM mutations
		System.out.println("Starting PSM transformations");
		for (int i = 0; i < testCases.size(); i++) {
			TestCase tC = testCases.get(i);
			if (tC.getTestModel().getModelType() != ModelType.PIM) {
				for (int j = 0; j < mutationsPSM.size(); j++) {
					MutationOperatorInterface mo = mutationsPSM.get(j);
					mo.mutateTestCase(tC);
				}
			}
		}

		for (TestCase tc : testCases) {
			for (OCLEvaluatorInterface oE : evaluators) {
				oE.evaluateTestModel(tc);
			}
		}

		// code generation
		System.out.println("Starting Code generation");
		for (TestCase tC : testCases) {
			System.out.println("Compilling test case " + tC.getTestCaseName());
			for (CodeGeneratorInterface cg : codeGenerator) {
				if (tC.getTestModel().getModelType() == cg.getModelType()) {
					cg.generateCode(tC);
				}
			}
		}

		System.out.println("Number of test cases: " + testCases.size());
		for (TestCase tc : testCases) {
			System.out.println("Saving testcase:" + tc.getTestCaseName());
			tc.saveTestCaseComponents(Utils.modelMetadataPath, Utils.modelTextPath, true);
		}

		for (CodeGeneratorObserverInterface cob : codeGeneratorObserver) {
			cob.afterGeneration();
		}

		System.out.println("Test Suite generation done");
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

	private List<TestFeature> readSpecialCases() {
		File f = new File("resources/SpecialCases.tsv");
		List<TestFeature> tFeatures = new ArrayList<TestFeature>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				String[] spl = line.split("\t");
				TestFeature tF = new TestFeature();
				tF.setName(spl[0]);
				for (int i = 1; i < spl.length; i++) {
					String[] fsp = spl[i].split(":");
					tF.addFeature(fsp[0], fsp[1]);
				}
				tFeatures.add(tF);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Loaded " + tFeatures.size() + " special cases");
		return tFeatures;
	}

	private void initializeMutationsPIM() {
		mutationsPIM.add(new MutationOperator("AddPage", ModelType.PIM, ModelType.PIM,
				Utils.pimTransformation + "AddPage.qvto"));
		mutationsPIM.add(new MutationOperator("AddParagraph", ModelType.PIM, ModelType.PIM,
				Utils.pimTransformation + "AddParagraph.qvto"));
		mutationsPIM.add(new MutationOperator("AddTable", ModelType.PIM, ModelType.PIM,
				Utils.pimTransformation + "AddTable.qvto"));
		mutationsPIM.add(new MutationOperator("AddImage", ModelType.PIM, ModelType.PIM,
				Utils.pimTransformation + "AddImage.qvto"));
		mutationsPIM.add(new MutationOperator("AddWord", ModelType.PIM, ModelType.PIM,
				Utils.pimTransformation + "AddWord.qvto"));
		mutationsPIM.add(new MutationOperator("MutateColor", ModelType.PIM, ModelType.PIM,
				Utils.pimTransformation + "MutateColor.qvto"));
	}

	private void initializeMutationsPIM2PSM() {
		mutationsPIM2PSM.add(new MutationOperator("PIM2Docx", ModelType.PIM, ModelType.PSMDocx,
				Utils.pim2psmTransformation + "PIM2Docx.qvto"));
		mutationsPIM2PSM.add(new MutationOperator("PIM2Libre", ModelType.PIM, ModelType.PSMLibre,
				Utils.pim2psmTransformation + "PIM2Libre.qvto"));
	}

	private void initializeMutationsPSM() {
		mutationsPSM.add(new MutationOperator("MutatePlatformDocx", ModelType.PSMDocx, ModelType.PSMDocx,
				Utils.psmDocxTransformation + "MutatePlatform.qvto"));
		mutationsPSM.add(new MutationOperator("MutateFontFamilyDocx", ModelType.PSMDocx, ModelType.PSMDocx,
				Utils.psmDocxTransformation + "MutatefontFamily.qvto"));
		mutationsPSM.add(new MutationOperator("MutateFontFamilyLibre", ModelType.PSMLibre, ModelType.PSMLibre,
				Utils.psmLibreTransformation + "MutateFontFamily.qvto"));
		mutationsPSM.add(new MutationOperator("MutatePlatformLibre", ModelType.PSMLibre, ModelType.PSMLibre,
				Utils.psmLibreTransformation + "MutatePlatform.qvto"));
	}

	private void initializeEvaluators() {

		evaluators = new ArrayList<OCLEvaluatorInterface>();

		// OCL queries
		evaluators.add(
				new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "number_of_pages", "self.pages->size()"));
		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "number_of_paragraphs",
				"self.pages.elements->selectByType(Paragraph)->size()"));
		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "number_of_tables",
				"self.pages.elements->selectByType(Table)->size()"));
		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "number_of_images",
				"self.pages.elements->selectByType(Image)->size()"));
		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "number_of_words",
				"self.pages.elements->selectByType(Paragraph).words->size()"));

		evaluators.add(new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "file_format",
				"self.documentFormat"));
		evaluators
				.add(new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "software", "self.software"));
		evaluators.add(new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "operating_system",
				"self.operatingSystem"));
		evaluators.add(new OCLMetadata(ModelType.PSMLibre, PSMLibrePackage.Literals.DOCUMENT, "file_format",
				"self.documentFormat"));
		evaluators.add(
				new OCLMetadata(ModelType.PSMLibre, PSMLibrePackage.Literals.DOCUMENT, "software", "self.software"));
		evaluators.add(new OCLMetadata(ModelType.PSMLibre, PSMLibrePackage.Literals.DOCUMENT, "operating_system",
				"self.operatingSystem"));

		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "document_background",
				"self.documentBackground"));
		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "element_background",
				"self.pages.elements->first().backgroundColor"));
		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "font_color",
				"self.pages.elements->selectByKind(TextContainer)->first().fontColor"));
		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "element_alignment",
				"self.pages.elements->first().alignment"));

		evaluators.add(new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "font_family",
				"self.pages.elements->selectByKind(TextContainer)->first().fontFamily"));
		evaluators.add(new OCLMetadata(ModelType.PSMLibre, PSMLibrePackage.Literals.DOCUMENT, "font_family",
				"self.pages.elements->selectByKind(TextContainer)->first().fontFamily"));

		evaluators.add(new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "paragraph_implementation",
				"if self.pages.elements->selectByKind(TextBox)->size()=0 and "
						+ "self.pages.elements->selectByKind(ControlBox)->size()=0 then 'allSimpleParagraph' "
						+ "else if self.pages.elements->selectByKind(Paragraph)->size()=0 and "
						+ "self.pages.elements->selectByKind(ControlBox)->size()=0 then  'allTextBox' "
						+ "else if self.pages.elements->selectByKind(Paragraph)->size()=0 and "
						+ "self.pages.elements->selectByKind(TextBox)->size()=0 then 'allContentControlBox' else "
						+ "'mixture' endif endif endif"));

		evaluators.add(new OCLMetadata(ModelType.PSMLibre, PSMLibrePackage.Literals.DOCUMENT,
				"paragraph_implementation", "if self.pages.elements->selectByKind(Paragraph)->size() > 0 "
						+ " then 'allSimpleParagraph' else 'allSimpleParagraph' endif"));

		evaluators.add(new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "table_implementation",
				"if self.pages.elements->selectByKind(WordTable)->size() = 0 and "
						+ "self.pages.elements->selectByKind(EmbeddedExcel)->size() = 0 then 'noTable' "
						+ "else if self.pages.elements->selectByKind(EmbeddedExcel)->size() = 0 then 'allSimpleTable' "
						+ "else if self.pages.elements->selectByKind(WordTable)->size() = 0 then 'allEmbeddedTable' "
						+ "else 'mixture' " + " endif endif endif "));
		evaluators.add(new OCLMetadata(ModelType.PSMLibre, PSMLibrePackage.Literals.DOCUMENT, "table_implementation",
				"if self.pages.elements->selectByKind(Table)->size() = 0 " + " then 'noTable' "
						+ "else 'allSimpleTable' endif "));

		evaluators.add(new OCLLibreText());
		evaluators.add(new OCLMSWordText());

	}

	private void initializeCodeGenerator() {
		codeGenerator = new ArrayList<CodeGeneratorInterface>();
		codeGeneratorObserver = new ArrayList<CodeGeneratorObserverInterface>();
		// codeGenerator.add(new DocCodeGenerator());
		codeGenerator.add(new DocxCodeGenerator());
		CodeGeneratorObserverInterface libreObserver = new LibreGeneratorObserver();
		//codeGenerator.add(new LibreCodeGenerator(libreObserver));
		codeGeneratorObserver.add(libreObserver);
	}

}
