package benchmarkdp.datagenerator.mutation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

import benchmarkdp.datagenerator.model.PIM.Document;



public class DocumentHolder {

	private String documentName;
	private URI documentURI;

	private Resource documentResource;

	EList<EObject> documentObjects;

	ModelExtent documentModel;

	private Map<String, String> groundTruth;

	private String generatedCode;

	public DocumentHolder(String name, String initDocument) {
		documentName = name;
		documentURI = URI.createURI(initDocument);

		ResourceSet resourceSet = new ResourceSetImpl();
		documentResource = resourceSet.getResource(documentURI, true);

		documentObjects = documentResource.getContents();
		documentModel = new BasicModelExtent(documentObjects);


		groundTruth = new HashMap<String, String>();
	}

	public String getName() {
		return documentName;
	}

	public ModelExtent getModelExtent() {
		return documentModel;
	}

	public EList<EObject> getDocumentObjects() {
		return documentObjects;
	}

	public void setModelExtent(ModelExtent me) {
		documentModel = me;
		documentObjects = new BasicEList<EObject>(documentModel.getContents());
	}

	public void addGroundTruth(String key, String value) {

		groundTruth.put(key, value);

	}

	public void setGeneratedCode(String s) {
		generatedCode = s;
	}

	public void saveToFile(String path) {
		Map<String, Object> opts = new HashMap<String, Object>();
		opts.put(XMIResource.OPTION_SCHEMA_LOCATION, true);

		ResourceSet resourceSetOut = new ResourceSetImpl();
		Resource outResource = resourceSetOut.createResource(URI.createURI(path + documentName + ".xmi"));
		outResource.getContents().addAll(documentObjects);
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
	
	public void saveGeneratedCode(String path) {
		try {
			File f = new File(path + documentName + ".vbs");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(generatedCode + "\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
