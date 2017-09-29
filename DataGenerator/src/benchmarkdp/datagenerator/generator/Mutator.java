package benchmarkdp.datagenerator.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.examples.blackbox.UtilitiesLibrary;

import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreCodeGenerator;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreGeneratorObserver;
import benchmarkdp.datagenerator.generator.codegenerator.msword.DocxCodeGenerator;
import benchmarkdp.datagenerator.generator.mutation.LibreOfficeMutationOperator;
import benchmarkdp.datagenerator.generator.mutation.MSWordMutationOperator;
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

public class Mutator {

	int n = 20; // number of test cases to generate
	int m = 3;

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
		// mutationsPIM2PSM = new ArrayList<MutationOperatorInterface>();
		// mutationsPSM = new ArrayList<MutationOperatorInterface>();
		//
		initializeMutationsPIM();
		// initializeMutationsPIM2PSM();
		// initializeMutationsPSM();
		//
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
		//
		// initializeEvaluators();
		//
		// initializeCodeGenerator();

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
			 //System.out.println("Mutating according to test feature:" + tC.getTestFeature().getName());
			 if (tC.getTestModel().getModelType() == ModelType.PIM) {
			 	for (int j = 0; j < mutationsPIM.size(); j++) {
			 		MutationOperatorInterface mo = mutationsPIM.get(j);
			 		if (mo.getSourceModel() == ModelType.PIM) {
			 			mo.mutateTestCase(tC);
			 		}
			 	}
			 }
		 }
		// for (OCLEvaluatorInterface oE : evaluators) {
		// if (oE.getModelType() == ModelType.PIM) {
		// oE.evaluateTestModel(tC);
		// }
		// }
		// }
		// }
		//
		// // PIM2PSM mutations
		// System.out.println("Starting PIM2PSM model transformations ");
		// for (int i = 0; i < testCases.size(); i++) {
		// TestCase tC = testCases.get(i);
		// for (int j = 0; j < mutationsPIM2PSM.size(); j++) {
		// MutationOperatorInterface mo = mutationsPIM2PSM.get(j);
		// if (tC.getTestModel().getModelType() == ModelType.PIM &&
		// mo.getSourceModel() == ModelType.PIM
		// && mo.getDestinationModel() != ModelType.PIM) {
		// List<TestCase> newModels = mo.mutateTestCase(tC);
		// if (newModels.size() > 0) {
		// testCases.addAll(newModels);
		// }
		// }
		// }
		// }
		//
		// // PSM mutations
		// System.out.println("Starting PSM transformations");
		// for (int i = 0; i < testCases.size(); i++) {
		// TestCase tC = testCases.get(i);
		// if (tC.getTestModel().getModelType() != ModelType.PIM) {
		// for (int j = 0; j < mutationsPSM.size(); j++) {
		// MutationOperatorInterface mo = mutationsPSM.get(j);
		// List<TestCase> newModels = mo.mutateTestCase(tC);
		// if (newModels.size() > 0) {
		// testCases.addAll(newModels);
		// }
		// }
		// for (OCLEvaluatorInterface oE : evaluators) {
		// if (oE.getModelType() == tC.getTestModel().getModelType()) {
		// oE.evaluateTestModel(tC);
		// }
		// }
		// }
		//
		// }

		// // code generation
		// System.out.println("Starting Code generation");
		// int siz = testCases.size();
		// int counter = 0;
		// System.out.println("In total " + siz + " test cases");
		// for (TestCase tC : testCases) {
		// counter++;
		// System.out.println(
		// "Compilling test case " + counter + "/" + siz + " init feature:" +
		// tC.getTestFeature().getName());
		// for (CodeGeneratorInterface cg : codeGenerator) {
		// if (tC.getTestModel().getModelType() == cg.getModelType()) {
		// cg.generateCode(tC);
		// }
		// }
		// }
		//
		//
		// System.out.println("Size of models " + testCases.size());
		// for (TestCase tm : testCases) {
		// tm.saveTestCaseComponents();
		// }
		//
		// for (CodeGeneratorObserverInterface cob : codeGeneratorObserver) {
		// cob.afterGeneration();
		// }
		//
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
			while((line=br.readLine())!=null) {
				String[] spl = line.split("\t");
				TestFeature tF = new TestFeature();
				tF.setName(spl[0]);
				for (int i=1; i<spl.length; i++) {
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

//	private void initializeMutationsPIM2PSM() {
//		// mutationsPIM2PSM.add(new ComplexMutationOperator("PIM2Doc",
//		// ModelType.PIM, ModelType.PSMDoc,
//		// Utils.pim2psmTransformation + "PIM2Doc.qvto", Arrays.asList("textbox,
//		// format, platform"),
//		// Arrays.asList("doc", "pdf"), Arrays.asList("Win7-Office2007")));
//		mutationsPIM2PSM.add(new MSWordMutationOperator("PIM2Docx", ModelType.PIM, ModelType.PSMDocx,
//				Utils.pim2psmTransformation + "PIM2Docx.qvto",
//				Arrays.asList("textbox", "controlbox", "format", "platform"), Arrays.asList("docx", "pdf"),
//				Arrays.asList("Win7-Office2007", "Win7-Office2010")));
//		mutationsPIM2PSM.add(new LibreOfficeMutationOperator("PIM2Libre", ModelType.PIM, ModelType.PSMLibre,
//				Utils.pim2psmTransformation + "PIM2Libre.qvto", Arrays.asList("format", "platform"),
//				Arrays.asList("odt", "pdf"), Arrays.asList("Ubuntu14-LibreOffice")));
//	}

//	private void initializeMutationsPSM() {
//		mutationsPSM.add(new MutationOperator("ChangeTextColor", ModelType.PSMDoc, ModelType.PSMDoc,
//				Utils.psmDocTransformation + "ChangeTextColor.qvto", Arrays.asList("textcolor")));
//		mutationsPSM.add(new MutationOperator("ChangeTextSize", ModelType.PSMDoc, ModelType.PSMDoc,
//				Utils.psmDocTransformation + "ChangeTextSize.qvto", Arrays.asList("textsize")));
//		mutationsPSM.add(new MutationOperator("ChangeTextSize", ModelType.PSMDocx, ModelType.PSMDocx,
//				Utils.psmDocxTransformation + "ChangeTextColorDocx.qvto", Arrays.asList("textcolor")));
//
//	}

	private void initializeEvaluators() {
		evaluators = new ArrayList<OCLEvaluatorInterface>();

		// evaluators.add(new OCLEvaluatorPIM("pagecount",
		// "self.pages->size()"));
		// evaluators.add(new OCLEvaluatorPIM("tablecount",
		// "self.pages.elements->selectByType(Table)->size()"));
		// evaluators.add(new OCLEvaluatorPIM("paragraphcount",
		// "self.pages.elements->selectByType(Paragraph)->size()"));
		// evaluators.add(new OCLEvaluatorPIM("wordcount",
		// "self.pages.elements->selectByType(Paragraph).words->size()"));
		//
		// evaluators.add(new OCLEvaluatorPSMDoc("words-textbox",
		// "self.pages.elements->selectByType(TextBox)->asSequence()->collectNested(words.value->asSequence())"));
		// evaluators.add(new OCLEvaluatorPSMDocx("words-textbox",
		// "self.pages.elements->selectByType(TextBox)->asSequence()->collectNested(words.value->asSequence())"));
		// evaluators.add(new OCLEvaluatorPSMDocx("words-controlbox",
		// "self.pages.elements->selectByType(ControlBox)->asSequence()->collectNested(words.value->asSequence())"));
		// // evaluators.add(new OCLEvaluatorPSMDocx("words",
		// // "self.pages.elements->selectByType(Paragraph).words.value"));
		// // evaluators.add(new OCLEvaluatorPSMDoc("words",
		// // "self.pages.elements->selectByType(Paragraph).words.value"));
		//
		// evaluators.add(new OCLEvaluatorPSMDocx("words",
		// "self.pages.elements->selectByType(Paragraph)->asSequence()->collectNested(words.value->asSequence())"));
		// evaluators.add(new OCLEvaluatorPSMDoc("words",
		// "self.pages.elements->selectByType(Paragraph)->asSequence()->collectNested(words.value->asSequence())"));
		//
		// evaluators.add(new OCLEvaluatorPSMDocx("controlboxcount",
		// "self.pages.elements->selectByKind(ControlBox)->asSequence()->size()"));
		//
		// evaluators.add(new OCLEvaluatorPSMDoc("numCol", "self.numColum"));
		// evaluators.add(new OCLEvaluatorPSMDocx("numCol", "self.numColum"));
		//
		// evaluators.add(new OCLEvaluatorPSMDoc("format",
		// "self.documentFormat"));
		// evaluators.add(new OCLEvaluatorPSMDocx("format",
		// "self.documentFormat"));
		//
		// evaluators.add(new OCLEvaluatorPSMDoc("platform",
		// "self.documentPlatform"));
		// evaluators.add(new OCLEvaluatorPSMDocx("platform",
		// "self.documentPlatform"));

		evaluators.add(
				new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "format", "self.documentFormat"));
		evaluators.add(new OCLMetadata(ModelType.PSMLibre, PSMLibrePackage.Literals.DOCUMENT, "format",
				"self.documentFormat"));
		evaluators.add(new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "platform",
				"self.documentPlatform"));
		evaluators.add(new OCLMetadata(ModelType.PSMLibre, PSMLibrePackage.Literals.DOCUMENT, "platform",
				"self.documentPlatform"));

		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "tablecount",
				"self.pages.elements->selectByType(Table)->size()"));
		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "paragraphcount",
				"self.pages.elements->selectByType(Paragraph)->size()"));
		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "imagecount",
				"self.pages.elements->selectByType(Image)->size()"));
		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "pagecount", "self.pages->size()"));
		evaluators.add(new OCLMetadata(ModelType.PIM, PIMPackage.Literals.DOCUMENT, "freewordcount",
				"self.pages.elements->selectByType(Paragraph).words->size()"));
		// evaluators.add(new OCLMetadata(ModelType.PIM,
		// PIMPackage.Literals.DOCUMENT, "allwordcount",
		// "Word::allInstances()->asSequence()->size()"));
		// evaluators.add(new OCLMetadata(ModelType.PIM,
		// PIMPackage.Literals.DOCUMENT, "freewordcount",
		// "self.pages.elements->selectByType(Paragraph)->asSequence()->collectNested(words->size())->sum()"));

		evaluators.add(new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "textboxcount",
				"self.pages.elements->selectByKind(TextBox)->asSequence()->size()"));
		evaluators.add(new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "controlboxcount",
				"self.pages.elements->selectByKind(ControlBox)->asSequence()->size()"));
		evaluators.add(new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "emeddedexcelcount",
				"self.pages.elements->selectByKind(EmbeddedExcel)->asSequence()->size()"));
		evaluators.add(new OCLMetadata(ModelType.PSMDocx, PSMDocxPackage.Literals.DOCUMENT, "simpleparagraphcount",
				"self.pages.elements->selectByKind(Paragraph)->asSequence()->size()"));

		evaluators.add(new OCLMetadata(ModelType.PSMLibre, PSMLibrePackage.Literals.DOCUMENT, "simpleparagraphcount",
				"self.pages.elements->selectByKind(Paragraph)->asSequence()->size()"));

		evaluators.add(new OCLLibreText());
		evaluators.add(new OCLMSWordText());

	}

	private void initializeCodeGenerator() {
		codeGenerator = new ArrayList<CodeGeneratorInterface>();
		codeGeneratorObserver = new ArrayList<CodeGeneratorObserverInterface>();
		// codeGenerator.add(new DocCodeGenerator());
		codeGenerator.add(new DocxCodeGenerator());
		CodeGeneratorObserverInterface libreObserver = new LibreGeneratorObserver();
		codeGenerator.add(new LibreCodeGenerator(libreObserver));
		codeGeneratorObserver.add(libreObserver);
	}

}
