package benchmarkdp.datagenerator.testcase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import benchmarkdp.datagenerator.generator.utils.Utils;
import benchmarkdp.datagenerator.properties.ExperimentProperties;

public class TestCase {

	private String ID;

	private String testCaseName;

	private TestFeature testFeature;

	private TestModel testModel;

	private Metadata metadata;

	private TextElements textElements;

	private IGeneratedCode generatedCode;

	private boolean status = false;

	private String testCaseState;

	private String initModelPath;

	private String pimModelPath;

	private String psmModelPath;
	
	private String generatedDocument; 
	
	private String platform; 

	public TestCase() {
		ID = UUID.randomUUID().toString();
		testCaseName = ID.replace("-", "");
		metadata = new Metadata();
		textElements = new TextElements();
		testModel = new TestModel();
		testCaseState = "NULL";
	}

	public TestCase(String tName) {
		this();
		testCaseName = tName;
	}

	public TestCase(TestModel tm) {
		this();
		testModel = tm;
	}

	public TestCase(TestCase tC) {
		this();
		metadata.add(tC.getMetadata());
		textElements.addText(tC.getTextElements());
		testFeature = tC.getTestFeature();
		testModel.setParent(tC.getTestModel());
	}

	public String getID() {
		return ID;
	}

	@XmlElement(name = "name")
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public TestFeature getTestFeature() {
		return testFeature;
	}

	public void setStatus(boolean st) {
		status = st;
	}

	// @XmlElement(name="")
	public void setTestFeature(TestFeature testFeature) {
		if (testFeature.getName() != null) {
			this.testCaseName = testFeature.getName();
		}
		this.testFeature = testFeature;
	}

	public TestModel getTestModel() {
		return testModel;
	}

	@XmlTransient // causes an exception if not set
	public void setTestModel(TestModel tM) {
		testModel = tM;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	@XmlTransient
	public void setMetadata(Metadata m) {
		metadata.add(m);
	}

	public TextElements getTextElements() {
		return textElements;
	}

	public void setGeneratedCode(IGeneratedCode gC) {
		generatedCode = gC;
		platform = generatedCode.getPlatform();
	}

	public String getTestCaseState() {
		return testCaseState;
	}

	@XmlElement(name = "testCaseState")
	public void setTestCaseState(String testCaseState) {
		this.testCaseState = testCaseState;
	}

	public String getInitModelPath() {
		return initModelPath;
	}

	@XmlElement(name = "initModelPath")
	public void setInitModelPath(String initModelPath) {
		this.initModelPath = initModelPath;
	}

	public String getPimModelPath() {
		return pimModelPath;
	}

	@XmlElement(name = "pimModelPath")
	public void setPimModelPath(String pimModelPath) {
		this.pimModelPath = pimModelPath;
	}

	public String getPsmModelPath() {
		return psmModelPath;
	}

	@XmlElement(name = "psmModelPath")
	public void setPsmModelPath(String psmModelPath) {
		this.psmModelPath = psmModelPath;
	}
	
	public String getGeneratedDocument() {
		return generatedDocument;
	}
	@XmlElement(name = "generatedDocument")
	public void setGeneratedDocument(String generatedDocument) {
		this.generatedDocument = generatedDocument;
	}

	public String getPlatform() {
		return platform;
	}

	@XmlElement(name = "platform")
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public void saveTestCaseComponents(ExperimentProperties ep) {

		String basePath = ep.getFullFolderPath();
		String modelPath = basePath + "/" + ep.getModelsFolder() + "/";
		if (testModel != null) {
			testModel.saveModelToFile(modelPath, testCaseName);
		}

		String codePath = basePath + "/" + ep.getMacroFolder() + "/";
		if (generatedCode != null) {
			generatedCode.saveToFile(codePath, testCaseName);
		}

		String metadataPath = basePath + "/" + ep.getModelMetadataFolder() + "/";
		if (metadata != null) {
			metadata.saveToXML(metadataPath, testCaseName);
		}

		String textPath = basePath + "/" + ep.getModelTextFolder() + "/";
		if (textElements != null) {
			textElements.saveToXML(textPath, testCaseName);
		}
	}

	public void saveTestCaseComponents(String metadataPath, String textPath, boolean flag) {

		if (flag) {
			if (testModel != null) {
				testModel.saveModelToFile(Utils.modelsPath, testCaseName);
			}

			if (generatedCode != null) {
				generatedCode.saveToFile(Utils.macroPath, testCaseName);
			}
		}

		if (metadata != null) {
			metadata.saveToXML(metadataPath, testCaseName);
		}
		if (textElements != null) {
			textElements.saveToXML(textPath, testCaseName);
		}

		File f = new File(Utils.basePath + "testcases.tsv");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
			bw.write(testCaseName + "\t" + status + "\n");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void load(ExperimentProperties ep) {
		// if (true){
		if (testCaseState == "INITIALIZED") {
			testModel = new TestModel(initModelPath, ModelType.PIM);
		} else {
			String pimPath = ep.getFullFolderPath() + "/" + pimModelPath;
			TestModel pimModel = new TestModel(pimPath, ModelType.PIM);

			String psmPath = ep.getFullFolderPath() + "/" + psmModelPath;
			TestModel psmModel = new TestModel(psmPath, null);

			psmModel.setParent(pimModel);

			testModel = psmModel;
		}
	}

}
