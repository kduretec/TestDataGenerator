package benchmarkdp.datagenerator.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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



public class DocumentHolder {

	private String documentName;
	private URI documentURI;

	private Resource documentResource;

	private Map<ModelType,EList<EObject>> documentObjects;

	private Map<ModelType,ModelExtent> documentModels;

	private Map<String, String> groundTruth;

	private Map<ModelType , String> generatedCode;

	public DocumentHolder(String name, String initDocument) {
		documentName = name;
		documentURI = URI.createURI(initDocument);

		documentObjects = new HashMap<ModelType, EList<EObject>>();
		documentModels = new HashMap<ModelType, ModelExtent>();
		generatedCode = new HashMap<ModelType, String>();
		
		ResourceSet resourceSet = new ResourceSetImpl();
		documentResource = resourceSet.getResource(documentURI, true);

		EList<EObject> tmpObjects = documentResource.getContents();
		documentObjects.put(ModelType.PIM, tmpObjects); 
		documentModels.put(ModelType.PIM, new BasicModelExtent(tmpObjects));

		groundTruth = new HashMap<String, String>();
		generatedCode = new HashMap<ModelType, String>();
		
	}

	public String getName() {
		return documentName;
	}

	public ModelExtent getModelExtent(ModelType model) {
		return documentModels.get(model);
	}

	public EList<EObject> getDocumentObjects(ModelType model) {
		return documentObjects.get(model);
	}

	public void setModelExtent(ModelType model, ModelExtent me) {
		List<EObject> meCont = me.getContents();
		documentModels.put(model, me);
		documentObjects.put(model, new BasicEList<EObject>(meCont));
	}

	public void addGroundTruth(String key, String value) {
		groundTruth.put(key, value);
	}

	public void setGeneratedCode(ModelType model, String code) {
		generatedCode.put(model, code);
	}

	public void saveToFile(ModelType model, String path) {
		Map<String, Object> opts = new HashMap<String, Object>();
		opts.put(XMIResource.OPTION_SCHEMA_LOCATION, true);

		ResourceSet resourceSetOut = new ResourceSetImpl();
		Resource outResource = resourceSetOut.createResource(URI.createURI(path + documentName + "_" + model + ".xmi"));
		outResource.getContents().addAll(documentObjects.get(model));
		try {
			outResource.save(opts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exportGroundTruth(String path) {
		try {
			File f = new File(path + documentName + "-groundtruth.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			for (Map.Entry<String, String> e : groundTruth.entrySet()) {
				if (e.getKey().compareTo("words") == 0) {
					exportWords(path, e.getValue());
				} else if (e.getKey().compareTo("words-textbox") == 0) {
					exportTextBoxWords(path, e.getValue());
				} else {
					bw.write(e.getKey() + " = " + e.getValue() + "\n");
				}
			}
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void exportWords(String path, String value) {
		try {
			File f = new File(path + documentName + "-groundtruthWords.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			value = value.replace(",", "");
			value = value.replace("[", "");
			value = value.replace("]", "");
			bw.write(value + "\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void exportTextBoxWords(String path, String value) {
		try {
			File f = new File(path + documentName + "-groundtruthTextBoxWords.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			value = value.replace(",", "");
			value = value.replace("[", "");
			value = value.replace("]", "");
			bw.write(value + "\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void saveGeneratedCode(ModelType model, String path) {
		try {
			File f = new File(path + documentName + "_" + model + ".vbs");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(generatedCode.get(model) + "\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
