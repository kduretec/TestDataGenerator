package benchmarkdp.datagenerator.mutation;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.ModelExtent;

public class ModelHolder {

	private String ID;
	
	private ModelType modelType;
	
	private ModelHolder parent; 
	
	private EList<EObject> modelObjects; 
	
	private ModelExtent modelExtent;
	
	private Map<String, String> groundTruth; 
	
	private String generatedCode;

	public ModelHolder() {
		
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

	public void setModelObjects(EList<EObject> modelObjects) {
		this.modelObjects = modelObjects;
	}

	public ModelExtent getModelExtent() {
		return modelExtent;
	}

	public void setModelExtent(ModelExtent modelExtent) {
		this.modelExtent = modelExtent;
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

	public ModelHolder getParent() {
		return parent;
	}

	public void setParent(ModelHolder parent) {
		this.parent = parent;
	} 
	
	
	
}
