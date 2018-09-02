package benchmarkdp.datagenerator.datacollector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import benchmarkdp.datagenerator.generator.ocl.OCLEvaluatorInterface;
import benchmarkdp.datagenerator.generator.ocl.OCLLibreText;
import benchmarkdp.datagenerator.generator.ocl.OCLMSWordText;
import benchmarkdp.datagenerator.generator.utils.Utils;
import benchmarkdp.datagenerator.model.PIM.PIMPackage;
import benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage;
import benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage;
import benchmarkdp.datagenerator.testcase.TestCase;

/**
 * This class is used in case ground truth needs to be extracted again from the models. 
 * It allows us to not reexecute the whole generation process. 
 * @author kresimir
 *
 */
public class AdditionalExtractor {

	private List<OCLEvaluatorInterface> evaluators;
	
	public AdditionalExtractor() {
		initializeEvaluators();
	}
	
	public static void main(String[] args) {
		
		AdditionalExtractor ae = new AdditionalExtractor();
		ae.execute();
	}
	
	
	private void execute() {
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		PIMPackage mwp = PIMPackage.eINSTANCE;
		PSMDocxPackage pwd = PSMDocxPackage.eINSTANCE;
		PSMLibrePackage pld = PSMLibrePackage.eINSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		System.out.println("Modelling environment initialized");
		
		List<TestCase> testCases = loadTestCases();
		System.out.println("Found " + testCases.size() + " test cases");
	
		for (TestCase tc : testCases) {
			//tc.loadModels(Utils.modelsPath);
		}
		System.out.println("Test case models loaded");
		
		for (TestCase tc : testCases) {
			for (OCLEvaluatorInterface oE : evaluators) {
				oE.evaluateTestModel(tc);
			}
		}
		System.out.println("Evaluation done");
		
		for (TestCase tc : testCases) {
			System.out.println("Saving testcase:" + tc.getTestCaseName());
			tc.saveTestCaseComponents(Utils.modelMetadataPath, Utils.modelTextPath, true);
		}
		
		System.out.println("Done");
	}
	

	

	
	private List<TestCase> loadTestCases() {
		List<TestCase> tc = new ArrayList<TestCase>();
		File f = new File(Utils.basePath + "testcases.tsv"); 
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				if (line.length() == 0)
					continue;
				String[] entr = line.split("\t");
				if (entr.length < 2) 
					continue;
				TestCase tmp = new TestCase(entr[0]);
				if (entr[1].compareTo("false")==0) {
					tmp.setStatus(false);
				} else {
					tmp.setStatus(true);
				}
				tc.add(tmp);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.delete();
		return tc;
	}
	
	private void initializeEvaluators() {
		evaluators = new ArrayList<OCLEvaluatorInterface>();
		
		evaluators.add(new OCLLibreText());
		evaluators.add(new OCLMSWordText());
		
	}
}
