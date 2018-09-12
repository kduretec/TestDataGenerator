package benchmarkdp.datagenerator.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.documentgenerator.GenerateDocumentsStep;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreGeneratorObserver;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.TestCaseContainer;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class MutationStep implements IWorkflowStep {

	private int NUMBER_OF_PROC = 4;
	private static Logger log = LoggerFactory.getLogger(MutationStep.class);

	@Override
	public void executeStep(ExperimentProperties ep, TestCaseContainer tCC) {

		List<TestCase> testCases = tCC.getTestCases();
		log.info("Mutation found " + testCases.size() + " testcases to mutate");

		ExecutorService exec = Executors.newFixedThreadPool(NUMBER_OF_PROC);

		List<CodeGeneratorObserverInterface> codeGeneratorObserver = new ArrayList<CodeGeneratorObserverInterface>();
		codeGeneratorObserver.add(new LibreGeneratorObserver());
		for (TestCase tc : testCases) {
			if (tc.getTestCaseState().compareTo("INITIALIZED") == 0) {
				exec.execute(new MutationProc(ep, tc, codeGeneratorObserver));
			}
		}

		exec.shutdown();
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (CodeGeneratorObserverInterface cob : codeGeneratorObserver) {
			cob.afterGeneration();
		}
		
		ep.setExperimentState("TEST_CASES_MUTATED");
	}

	@Override
	public IWorkflowStep nextStep() {
		return new GenerateDocumentsStep();
	}

}
