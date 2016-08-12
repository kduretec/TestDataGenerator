package benchmarkdp.datagenerator.mutation;

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

	private Map<String,EList<EObject>> documentObjects;

	private Map<String,ModelExtent> documentModels;

	private Map<String, String> groundTruth;

	private Map<String , String> generatedCode;

	public DocumentHolder(String name, String initDocument) {
		documentName = name;
		documentURI = URI.createURI(initDocument);

		documentObjects = new HashMap<String, EList<EObject>>();
		documentModels = new HashMap<String, ModelExtent>();
		generatedCode = new HashMap<String, String>();
		
		ResourceSet resourceSet = new ResourceSetImpl();
		documentResource = resourceSet.getResource(documentURI, true);

		EList<EObject> tmpObjects = documentResource.getContents();
		documentObjects.put("PIM", tmpObjects); 
		documentModels.put("PIM", new BasicModelExtent(tmpObjects));

		groundTruth = new HashMap<String, String>();
		generatedCode = new HashMap<String, String>();
		
	}

	public String getName() {
		return documentName;
	}

	public ModelExtent getModelExtent(String name) {
		return documentModels.get(name);
	}

	public EList<EObject> getDocumentObjects(String name) {
		return documentObjects.get(name);
	}

	public void setModelExtent(String name, ModelExtent me) {
		List<EObject> meCont = me.getContents();
		documentModels.put(name, me);
		documentObjects.put(name, new BasicEList<EObject>(meCont));
	}

	public void addGroundTruth(String key, String value) {
		groundTruth.put(key, value);
	}

	public void setGeneratedCode(String name, String code) {
		generatedCode.put(name, code);
	}

	public void saveToFile(String name, String path) {
		Map<String, Object> opts = new HashMap<String, Object>();
		opts.put(XMIResource.OPTION_SCHEMA_LOCATION, true);

		ResourceSet resourceSetOut = new ResourceSetImpl();
		Resource outResource = resourceSetOut.createResource(URI.createURI(path + documentName + "_" + name + ".xmi"));
		outResource.getContents().addAll(documentObjects.get(name));
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
	
	public void saveGeneratedCode(String name, String path) {
		try {
			File f = new File(path + documentName + "_" + name + ".vbs");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(generatedCode.get(name) + "\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
