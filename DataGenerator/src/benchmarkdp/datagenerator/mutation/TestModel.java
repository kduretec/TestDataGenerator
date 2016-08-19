package benchmarkdp.datagenerator.mutation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.ModelExtent;

public class TestModel {

	private String ID;
	
	private ModelType modelType;
	
	private TestModel parent; 
	
	private EList<EObject> modelObjects; 
	
	private ModelExtent modelExtent;
	
	private Map<String, String> groundTruth; 
	
	private String generatedCode;
	
	private TestFeature testFeature; 

	public TestModel() {
		ID = UUID.randomUUID().toString();
		groundTruth = new HashMap<String, String>();
	}
	
	public ModelType getModelType() {
		return modelType;
	}

	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}

	public EList<EObject> getModelObjects() {
		return modelObjects;
	}


	public ModelExtent getModelExtent() {
		return modelExtent;
	}

	public void setModelExtent(ModelExtent modelExtent) {
		this.modelExtent = modelExtent;
		modelObjects = new BasicEList<EObject>(modelExtent.getContents());
	}

	public Map<String, String> getGroundTruth() {
		return groundTruth;
	}

	public void setGroundTruth(Map<String, String> groundTruth) {
		this.groundTruth = groundTruth;
	}

	public String getGeneratedCode() {
		return generatedCode;
	}

	public void setGeneratedCode(String generatedCode) {
		this.generatedCode = generatedCode;
	}

	public String getID() {
		return ID;
	}

	public TestModel getParent() {
		return parent;
	}

	public void setParent(TestModel parent) {
		this.parent = parent;
	} 
	
	public TestFeature getTestFeature() {
		return testFeature;
	}

	public void setTestFeature(TestFeature testFeature) {
		this.testFeature = testFeature;
	}
	
	public void initialize(String initModel) {
		URI documentURI = URI.createURI(initModel);

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource documentResource = resourceSet.getResource(documentURI, true);
		modelObjects = documentResource.getContents(); 
	}
	
	public void initialize(TestModel tm) {
		this.setGeneratedCode(tm.getGeneratedCode());
		this.setGroundTruth(tm.getGroundTruth());
		this.setModelExtent(tm.getModelExtent());
		this.setModelType(tm.getModelType());
		this.setParent(tm);
		this.setTestFeature(tm.getTestFeature());
	}
}
