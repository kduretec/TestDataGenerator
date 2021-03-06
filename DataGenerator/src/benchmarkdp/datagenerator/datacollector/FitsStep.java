package benchmarkdp.datagenerator.datacollector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.core.TestCase;
import benchmarkdp.datagenerator.core.TestDataset;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class FitsStep implements IWorkflowStep {

	private int NUMBER_OF_PROC = 4;
	private static Logger log = LoggerFactory.getLogger(FitsStep.class);

	@Override
	public void executeStep(ExperimentProperties ep, TestDataset tCC) {

		ExecutorService exec = Executors.newFixedThreadPool(NUMBER_OF_PROC);
		for (TestCase tc : tCC.getTestCases()) {
			if (tc.getTestCaseState().compareTo("DOCUMENT_GENERATED") == 0) {
				exec.execute(new FitsProc(ep, tc));
			}
		}
		exec.shutdown();
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ep.setExperimentState("TEST_CASES_FITSDONE");
	}

	@Override
	public IWorkflowStep nextStep() {
		return new FinalizeStep();
	}
}
