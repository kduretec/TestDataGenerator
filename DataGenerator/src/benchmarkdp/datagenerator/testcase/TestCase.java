package benchmarkdp.datagenerator.testcase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import benchmarkdp.datagenerator.generator.utils.Utils;

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
	
	public TestCase() {
		ID = UUID.randomUUID().toString();
		testCaseName = ID.replace("-", "");
		metadata = new Metadata();
		textElements = new TextElements();
		testModel = new TestModel();
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

	@XmlElement(name="name")
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
	
	//@XmlElement(name="")
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
	}

	
	public String getTestCaseState() {
		return testCaseState;
	}

	@XmlElement(name="testCaseState")
	public void setTestCaseState(String testCaseState) {
		this.testCaseState = testCaseState;
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
	
	public void loadModels(String modelPath) {
		String pimPath = modelPath + "PIM/";
		String pimModelPath = pimPath + testCaseName + ".xmi";
		TestModel pimModel = new TestModel(pimModelPath, ModelType.PIM);
		
		String psmPath = modelPath + "PSM/";
		String psmModelPath = psmPath + testCaseName + ".xmi";
		TestModel psmModel = new TestModel(psmModelPath, null);
		
		psmModel.setParent(pimModel);
		
		testModel = psmModel;
	}

}
