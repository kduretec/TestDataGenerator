package benchmarkdp.datagenerator.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

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

	public String getTestCaseName() {
		return testCaseName;
	}

	public TestFeature getTestFeature() {
		return testFeature;
	}

	public void setStatus(boolean st) {
		status = st;
	}
	
	public void setTestFeature(TestFeature testFeature) {
		if (testFeature.getName() != null) {
			this.testCaseName = testFeature.getName();
		}
		this.testFeature = testFeature;
	}

	public TestModel getTestModel() {
		return testModel;
	}

	public void setTestModel(TestModel tM) {
		testModel = tM;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata m) {
		metadata.add(m);
	}

	public TextElements getTextElements() {
		return textElements;
	}

	public void setGeneratedCode(IGeneratedCode gC) {
		generatedCode = gC;
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

}
