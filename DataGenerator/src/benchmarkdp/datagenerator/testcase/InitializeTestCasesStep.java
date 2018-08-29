package benchmarkdp.datagenerator.testcase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class InitializeTestCasesStep implements IWorkflowStep {

	@Override
	public void executeStep(ExperimentProperties ep, TestCaseContainer tCC) {

		
		int numTC = ep.getTestCaseNumber();
		
		List<TestFeature> testFeatures = readSpecialCases();
		
		for (int i = 0; i < numTC; i++) {
			//TestCase tCase = new TestCase();
			TestCase tCase = new TestCase(new TestModel("PIMs/Document.xmi", ModelType.PIM));
			if (i < testFeatures.size()) {
				TestFeature tf = testFeatures.get(i);
				tCase.setTestFeature(tf);
			} else {
				tCase.setTestFeature(new TestFeature());
			}
			tCase.setTestCaseState("INITIALIZED");
			tCC.addTestCase(tCase);
		}
		ep.setExperimentState("TEST_CASES_INITIALIZED");
	}

	@Override
	public IWorkflowStep nextStep() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<TestFeature> readSpecialCases() {
		File f = new File("resources/SpecialCases.tsv");
		List<TestFeature> tFeatures = new ArrayList<TestFeature>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				String[] spl = line.split("\t");
				TestFeature tF = new TestFeature();
				tF.setName(spl[0]);
				for (int i = 1; i < spl.length; i++) {
					String[] fsp = spl[i].split(":");
					tF.addFeature(fsp[0], fsp[1]);
				}
				tFeatures.add(tF);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Loaded " + tFeatures.size() + " special cases");
		return tFeatures;
	}

}