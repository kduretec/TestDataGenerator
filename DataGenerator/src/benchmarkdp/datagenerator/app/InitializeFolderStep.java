package benchmarkdp.datagenerator.app;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.generator.InitializeTestCasesStep;
import benchmarkdp.datagenerator.core.TestDataset;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class InitializeFolderStep implements IWorkflowStep{

	private static Logger log = LoggerFactory.getLogger(InitializeFolderStep.class);
	
	@Override
	public void executeStep(ExperimentProperties ep, TestDataset tCC) {
		log.info("Initializing folder structure");		
		String eN = ep.getExperimentName();
		String path = ep.getFullFolderPath();
		path = path + "/" + ep.getExperimentName();
		File bDir = new File(path);
		if (bDir.exists()) {
			deleteDirectory(bDir);
		}
		bDir.mkdir();
		String documentsPath = path + "/Documents";
		File f = new File(documentsPath);
		f.mkdir();
		ep.setDocumentFolder(eN + "/Documents");
		String resultsPath = path + "/Results";
		f = new File(resultsPath);
		f.mkdir();
		ep.setResultsFolder(eN + "/Results");
		String fitsPath = path + "/Fits";
		f = new File(fitsPath);
		f.mkdir();
		ep.setFitsFolder(eN + "/Fits");
		String toolOutputPath = path + "/ToolOutput";
		f = new File(toolOutputPath);
		f.mkdir();
		ep.setToolOutputFolder(eN + "/ToolOutput");
		String groundTruthPath = path + "/GroundTruth";
		f = new File(groundTruthPath);
		f.mkdir();
		ep.setGroundTruthFolder(eN + "/GroundTruth");
		String metadataPath = groundTruthPath + "/Metadata";
		f = new File(metadataPath);
		f.mkdir();
		ep.setMetadataFolder(eN + "/GroundTruth/Metadata");
		String modelMetadataPath = groundTruthPath + "/ModelMetadata";
		f = new File(modelMetadataPath);
		f.mkdir();
		ep.setModelMetadataFolder(eN + "/GroundTruth/ModelMetadata");
		String generatedMetadataPath = groundTruthPath + "/GeneratedMetadata";
		f = new File(generatedMetadataPath);
		f.mkdir();
		ep.setGeneratedMetadataFolder(eN + "/GroundTruth/GeneratedMetadata");
		String textPath = groundTruthPath + "/Text";
		f = new File(textPath);
		f.mkdir();
		ep.setTextFolder(eN + "/GroundTruth/Text");
		String modelTextPath = groundTruthPath + "/ModelText";
		f = new File(modelTextPath);
		f.mkdir();
		ep.setModelTextFolder(eN + "/GroundTruth/ModelText");
		String generatedTextPath = groundTruthPath + "/GeneratedText";
		f = new File(generatedTextPath);
		f.mkdir();
		ep.setGeneratedTextFolder(eN + "/GroundTruth/GeneratedText");
		String modelsPath = path + "/Models";
		f = new File(modelsPath);
		f.mkdir();
		ep.setModelsFolder(eN + "/Models");
		String macroPath = path + "/Macro";
		f = new File(macroPath);
		f.mkdir();
		ep.setMacroFolder(eN + "/Macro");
		
		ep.setExperimentState("FOLDER_STRUCTURE_INITIALIZED");
	}

	@Override
	public IWorkflowStep nextStep() {
		return new InitializeTestCasesStep();
	}

	private static void deleteDirectory(File d) {
		File[] files = d.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				deleteDirectory(f);
			}
			f.delete();
		}
	}
	
}
