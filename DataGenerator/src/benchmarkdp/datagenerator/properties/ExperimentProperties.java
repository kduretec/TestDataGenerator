package benchmarkdp.datagenerator.properties;

import benchmarkdp.datagenerator.app.state.ExperimentState;

public class ExperimentProperties {

	private String experimentName = null;

	private String experimentState = null; 
	
	private String fullFolderPath = null;
	
	private String documentFolder = null; 
	
	private String resultsFolder = null;
	
	private String fitsFolder = null;
	
	private String toolOutputFolder = null;
	
	private String groundTruthFolder = null;
	
	private String metadataFolder = null; 
	
	private String modelMetadataFolder = null;
	
	private String generatedMetadataFolder = null;
	
	private String textFolder = null;
	
	private String modelTextFolder = null;
	
	private String generatedTextFolder = null; 
	
	private String modelsFolder = null;
	
	private String macroFolder = null; 
	
	private int testCaseNumber; 
	
	public String getExperimentName() {
		return experimentName;
	}

	public void setExperimentName(String experimentName) {
		this.experimentName = experimentName;
	}

	public String getFullFolderPath() {
		return fullFolderPath;
	}

	public void setFullFolderPath(String fullFolderPath) {
		this.fullFolderPath = fullFolderPath;
	}

	public String getExperimentState() {
		return experimentState;
	}

	public void setExperimentState(String experimentState) {
		this.experimentState = experimentState;
	}

	public String getDocumentFolder() {
		return documentFolder;
	}

	public void setDocumentFolder(String documentFolder) {
		this.documentFolder = documentFolder;
	}

	public String getResultsFolder() {
		return resultsFolder;
	}

	public void setResultsFolder(String resultsFolder) {
		this.resultsFolder = resultsFolder;
	}

	public String getFitsFolder() {
		return fitsFolder;
	}

	public void setFitsFolder(String fitsFolder) {
		this.fitsFolder = fitsFolder;
	}

	public String getToolOutputFolder() {
		return toolOutputFolder;
	}

	public void setToolOutputFolder(String toolOutputFolder) {
		this.toolOutputFolder = toolOutputFolder;
	}

	public String getGroundTruthFolder() {
		return groundTruthFolder;
	}

	public void setGroundTruthFolder(String groundTruthFolder) {
		this.groundTruthFolder = groundTruthFolder;
	}

	public String getMetadataFolder() {
		return metadataFolder;
	}

	public void setMetadataFolder(String metadataFolder) {
		this.metadataFolder = metadataFolder;
	}

	public String getModelMetadataFolder() {
		return modelMetadataFolder;
	}

	public void setModelMetadataFolder(String modelMetadataFolder) {
		this.modelMetadataFolder = modelMetadataFolder;
	}

	public String getGeneratedMetadataFolder() {
		return generatedMetadataFolder;
	}

	public void setGeneratedMetadataFolder(String generatedMetadataFolder) {
		this.generatedMetadataFolder = generatedMetadataFolder;
	}

	public String getTextFolder() {
		return textFolder;
	}

	public void setTextFolder(String textFolder) {
		this.textFolder = textFolder;
	}

	public String getModelTextFolder() {
		return modelTextFolder;
	}

	public void setModelTextFolder(String modelTextFolder) {
		this.modelTextFolder = modelTextFolder;
	}

	public String getGeneratedTextFolder() {
		return generatedTextFolder;
	}

	public void setGeneratedTextFolder(String generatedTextFolder) {
		this.generatedTextFolder = generatedTextFolder;
	}

	public String getModelsFolder() {
		return modelsFolder;
	}

	public void setModelsFolder(String modelsFolder) {
		this.modelsFolder = modelsFolder;
	}

	public String getMacroFolder() {
		return macroFolder;
	}

	public void setMacroFolder(String macroFolder) {
		this.macroFolder = macroFolder;
	}

	public int getTestCaseNumber() {
		return testCaseNumber;
	}

	public void setTestCaseNumber(int testCaseNumber) {
		this.testCaseNumber = testCaseNumber;
	}

	
	
}
