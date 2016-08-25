package benchmarkdp.datagenerator.mutation;

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

public class TestModel {

	private String ID;

	private ModelType modelType;

	private TestModel parent;

	private EList<EObject> modelObjects;

	private ModelExtent modelExtent;

	private Map<String, Object> groundTruth;

	private String generatedCode;

	private TestFeature testFeature;

	private String format;

	private String platform;

	public TestModel() {
		ID = UUID.randomUUID().toString();
		groundTruth = new HashMap<String, Object>();
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

	public Map<String, Object> getGroundTruth() {
		return groundTruth;
	}

	public void setGroundTruth(Map<String, Object> groundTruth) {
		for (Map.Entry<String, Object> e : groundTruth.entrySet()) {
			this.groundTruth.put(e.getKey(), e.getValue());
		}
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

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public void initialize(String initModel) {
		URI documentURI = URI.createURI(initModel);

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource documentResource = resourceSet.getResource(documentURI, true);
		modelObjects = documentResource.getContents();
		modelExtent = new BasicModelExtent(modelObjects);
	}

	public void initialize(TestModel tm) {
		this.setGeneratedCode(tm.getGeneratedCode());
		this.setGroundTruth(tm.getGroundTruth());
		this.setModelExtent(tm.getModelExtent());
		this.setModelType(tm.getModelType());
		this.setParent(tm);
		this.setTestFeature(tm.getTestFeature());
	}

	public void saveModelToFile(String path) {
		Map<String, Object> opts = new HashMap<String, Object>();
		opts.put(XMIResource.OPTION_SCHEMA_LOCATION, true);

		ResourceSet resourceSetOut = new ResourceSetImpl();

		String file = path;
		if (modelType == ModelType.PIM) {
			file += "PIM/";
			file += testFeature.getName() + ".xmi";
		} else {
			file += "PSM/";
			file += testFeature.getName() + "_" + modelType + "_" + format + "_" + platform + ".xmi";
		}

		Resource outResource = resourceSetOut.createResource(URI.createURI(file));
		outResource.getContents().addAll(modelObjects);
		try {
			outResource.save(opts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveGeneratedCodeToFile(String path) {
		if (generatedCode != null) {
			try {
				String file = path + "/" + platform + "/" + testFeature.getName() + "_" + modelType + "_" + format + "_" + platform
						+ ".vbs";
				File f = new File(file);
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(generatedCode + "\n");
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void saveGroundTruth(String path) {
		try {
			String file = path  + testFeature.getName() + "_" + modelType + "_" + format + "_" + platform + "-groundtruthAll.txt";
			File f = new File(file);
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write("platform = " + platform + "\n");
			bw.write("format = " + format + "\n");
			bw.write("modelType = " + modelType + "\n");

			for (Map.Entry<String, Object> e : groundTruth.entrySet()) {
				if (e.getKey().compareTo("words") == 0) {
					exportWords(path, e.getValue());
				} else if (e.getKey().compareTo("words-textbox") == 0) {
					exportTextBoxWords(path, e.getValue());
				} else if (e.getKey().compareTo("words-controlbox") == 0) {
					exportControlBoxWords(path, e.getValue());
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

	private void exportWords(String path, Object words) {
		try {
			String file = path  + testFeature.getName() + "_" + modelType + "_" + format + "_" + platform + "-groundtruthWords.txt";
			File f = new File(file);
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			List<String> list = (List<String>) words;
			for (String w: list) {
				bw.write(w + " ");
			}
			bw.write("\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void exportTextBoxWords(String path, Object words) {
		try {
			String file = path  + testFeature.getName() + "_" + modelType + "_" + format + "_" + platform + "-groundtruthTextBoxWords.txt";
			File f = new File(file);
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			List<Object> list = (List<Object>) words;
			for (Object l: list) {
				List<String> ls = (List<String>) l;
				for (String w: ls) {
					bw.write(w + " ");	
				}
				bw.write("\n");
			}
			bw.write("\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void exportControlBoxWords(String path, Object words) {
		try {
			String file = path  + testFeature.getName() + "_" + modelType + "_" + format + "_" + platform + "-groundtruthControlBoxWords.txt";
			File f = new File(file);
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			List<Object> list = (List<Object>) words;
			for (Object l: list) {
				List<String> ls = (List<String>) l;
				for (String w: ls) {
					bw.write(w + " ");	
				}
				bw.write("\n");
			}
			bw.write("\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
