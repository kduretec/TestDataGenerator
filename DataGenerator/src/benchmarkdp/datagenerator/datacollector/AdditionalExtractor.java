package benchmarkdp.datagenerator.datacollector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import benchmarkdp.datagenerator.generator.TestCase;
import benchmarkdp.datagenerator.model.PIM.PIMPackage;
import benchmarkdp.datagenerator.model.PSMDoc.PSMDocPackage;
import benchmarkdp.datagenerator.model.PSMDocx.Document;
import benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage;

public class AdditionalExtractor {

	private String oclQuery = "self.pages.elements->selectByKind(TextBox)->asSequence()->size()";
	
	public static void main(String[] args) {
		
		AdditionalExtractor ae = new AdditionalExtractor();
		ae.execute();
	}
	
	
	private void execute() {
		
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		PIMPackage mwp = PIMPackage.eINSTANCE;
		PSMDocPackage pwp = PSMDocPackage.eINSTANCE;
		PSMDocxPackage pwd = PSMDocxPackage.eINSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		
		File psmModels = new File("/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Models/PSM/");

		File[] files = psmModels.listFiles();
		boolean header = true;
		for (File model : files) {
			System.out.println("Loading model " + model.getName());
			if (model.getName().contains("PSMDocx")) {
				extract(model, 1);
			} else {
				extract(model, 2);
			}
		}
		
	}
	
	
	private void extract(File model, int meta) {
	
//		OCL ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
//		OCLHelper helper = ocl.createOCLHelper();
//
//		if (meta==1) {
//			helper.setContext(PSMDocxPackage.Literals.DOCUMENT);		
//		} else {
//			helper.setContext(PSMDocPackage.Literals.DOCUMENT);
//		}
//
//		OCLExpression<EClassifier> query = null;
//		
//		try {
//			query = helper.createQuery(oclQuery);
//		} catch (ParserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Query eval = ocl.createQuery(query);
//		
//		TestCase tmp = new TestCase();
//		tmp.initialize(model.getAbsolutePath());
//		
//		EList<EObject> objects = tmp.getModelObjects();
//		Object doc = objects.get(0);
//		
//		Object value = eval.evaluate(doc);
//		
//		save(model.getName(), value);
	}
	
	private void save(String name, Object value) {
		String pathGT = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/GroundTruth/";
		String fName = name.substring(0, name.indexOf("."));
		fName = fName + "-groundtruthAll.txt";
		File tF = new File(fName); 
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(pathGT + tF, true));
			System.out.println("Saving to " + fName + " textboxcount=" + value);
			bw.write("textboxcount = " + value + "\n");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
