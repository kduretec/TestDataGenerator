package benchmarkdp.datagenerator.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ModelExtent;

import benchmarkdp.datagenerator.generator.utils.Utils;

public class TestCase {

	private String ID;

	private String testCaseName;

	private TestFeature testFeature;

	private TestModel testModel;

	private Metadata metadata;

	private TextElements textElements;

	private IGeneratedCode generatedCode;

	public TestCase() {
		ID = UUID.randomUUID().toString();
		testCaseName = ID.replace("-", "");
		System.out.println("Name testcase: " + testCaseName);
		metadata = new Metadata();
		textElements = new TextElements();
		testModel = new TestModel();
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

	public void saveTestCaseComponents() {

		if (testModel != null) {
			testModel.saveModelToFile(Utils.modelsPath, testCaseName);
		}
//		if (metadata != null) {
//			metadata.saveToXML(Utils.modelMetadataPath, testCaseName);
//		}
//		if (textElements != null) {
//			textElements.saveToXML(Utils.modelTextPath, testCaseName);
//		}
//		if (generatedCode != null) {
//			generatedCode.saveToFile(Utils.macroPath, testCaseName);
//		}
	}

}
