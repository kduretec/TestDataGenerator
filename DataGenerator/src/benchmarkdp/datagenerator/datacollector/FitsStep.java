package benchmarkdp.datagenerator.datacollector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.generator.MutationStep;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.TestCaseContainer;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class FitsStep implements IWorkflowStep {

	private int NUMBER_OF_PROC = 4;
	private static Logger log = LoggerFactory.getLogger(FitsStep.class);

	@Override
	public void executeStep(ExperimentProperties ep, TestCaseContainer tCC) {

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

	}

	@Override
	public IWorkflowStep nextStep() {
		// TODO Auto-generated method stub
		return null;
	}
}
