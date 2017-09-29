package benchmarkdp.datagenerator.generator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

public class TestModel {

	private ModelType modelType;

	private EList<EObject> modelObjects;

	private ModelExtent modelExtent;

	private TestModel parent = null;

	public TestModel() {

	}

	public TestModel(String modelFile, ModelType type) {
		initialize(modelFile);
		modelType = type;
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
		modelObjects = new BasicEList<EObject>(modelExtent.getContents());
	}

	public TestModel getParent() {
		return parent;
	}

	public void setParent(TestModel parent) {
		this.parent = parent;
	}

	public void saveModelToFile(String filePath, String testCaseName) {
		String path;
		if (modelType == ModelType.PIM) {
			path = filePath + "PIM/";
		} else {
			path = filePath + "PSM/";
		}
		Map<String, Object> opts = new HashMap<String, Object>();
		opts.put(XMIResource.OPTION_SCHEMA_LOCATION, true);
		ResourceSet resourceSetOut = new ResourceSetImpl();

		Resource outResource = resourceSetOut.createResource(URI.createURI(path + testCaseName + ".xmi"));
		outResource.getContents().addAll(modelObjects);
		try {
			outResource.save(opts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (parent != null) {
			parent.saveModelToFile(filePath, testCaseName);
		}
	}

	private void initialize(String modelFile) {
		URI documentURI = URI.createURI(modelFile);

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource documentResource = resourceSet.getResource(documentURI, true);
		modelObjects = documentResource.getContents();
		modelExtent = new BasicModelExtent(modelObjects);
	}

}
