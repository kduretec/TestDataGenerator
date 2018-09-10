package benchmarkdp.datagenerator.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.ModelType;
import benchmarkdp.datagenerator.testcase.TestCase;

public class MutationProc implements Runnable {

	private static Logger log = LoggerFactory.getLogger(MutationProc.class);

	private TestCase tc;
	private ExperimentProperties ep;

	private List<MutationOperatorInterface> mutationsPIM;
	private List<MutationOperatorInterface> mutationsPIM2PSM;
	private List<MutationOperatorInterface> mutationsPSM;

	private List<OCLEvaluatorInterface> evaluators;

	private List<CodeGeneratorInterface> codeGenerator;

	private List<CodeGeneratorObserverInterface> codeGeneratorObserver;

	public MutationProc(ExperimentProperties e, TestCase t) {
		ep = e;
		tc = t;

		mutationsPIM = new ArrayList<MutationOperatorInterface>();
		mutationsPIM2PSM = new ArrayList<MutationOperatorInterface>();
		mutationsPSM = new ArrayList<MutationOperatorInterface>();

		initializeMutationsPIM();
		initializeMutationsPIM2PSM();
		initializeMutationsPSM();

		initializeEvaluators();

		initializeCodeGenerator();
	}

	@Override
	public void run() {

		if (tc.getTestModel().getModelType() == ModelType.PIM) {
			for (int j = 0; j < mutationsPIM.size(); j++) {
				MutationOperatorInterface mo = mutationsPIM.get(j);
				if (mo.getSourceModel() == ModelType.PIM) {
					mo.mutateTestCase(tc);
				}
			}
		}

		for (int j = 0; j < mutationsPIM2PSM.size(); j++) {
			// MutationOperatorInterface mo =
			// mutationsPIM2PSM.get(rnd.nextInt(mutationsPIM2PSM.size()));
			MutationOperatorInterface mo = mutationsPIM2PSM.get(0);
			if (tc.getTestModel().getModelType() == ModelType.PIM && mo.getSourceModel() == ModelType.PIM
					&& mo.getDestinationModel() != ModelType.PIM) {
				mo.mutateTestCase(tc);
			}
		}

		if (tc.getTestModel().getModelType() != ModelType.PIM) {
			for (int j = 0; j < mutationsPSM.size(); j++) {
				MutationOperatorInterface mo = mutationsPSM.get(j);
				mo.mutateTestCase(tc);
			}
		}

		for (OCLEvaluatorInterface oE : evaluators) {
			oE.evaluateTestModel(tc);
		}

		for (CodeGeneratorInterface cg : codeGenerator) {
			if (tc.getTestModel().getModelType() == cg.getModelType()) {
				cg.generateCode(tc);
			}
		}

		tc.saveTestCaseComponents(ep);

		for (CodeGeneratorObserverInterface cob : codeGeneratorObserver) {
			cob.afterGeneration();
		}

		verifyTestCase();
		log.info("TestCase " + tc.getTestCaseName() + " mutated");

	}

	private void verifyTestCase() {
		String pim = ep.getModelsFolder() + "/PIM/" + tc.getTestCaseName() + ".xmi";
		File f = new File(ep.getFullFolderPath() + "/" + pim);
		if (f.exists()) {
			tc.setPimModelPath(pim);
		}
		String psm = ep.getModelsFolder() + "/PSM/" + tc.getTestCaseName() + ".xmi";
		f = new File(ep.getFullFolderPath() + "/" + psm);
		if (f.exists()) {
			tc.setPsmModelPath(psm);
		}
		String modelMet = ep.getModelMetadataFolder() + File.separator + tc.getTestCaseName() + ".xml";
		log.info(modelMet);
		f = new File(ep.getFullFolderPath() + File.separator + modelMet);
		if (f.exists()) {
			tc.setModelMetadata(modelMet);
		}
		String modelTxt = ep.getModelTextFolder() + File.separator + tc.getTestCaseName() + ".xml";
		log.info(modelTxt);
		f = new File(ep.getFullFolderPath() + File.separator + modelTxt);
		log.info("FILE = " + f.getAbsolutePath());
		if (f.exists()) {
			tc.setModelText(modelTxt);
		}
		tc.setTestCaseState("MUTATED");
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
		codeGenerator.add(new LibreCodeGenerator(libreObserver));
		codeGeneratorObserver.add(libreObserver);
	}

}
