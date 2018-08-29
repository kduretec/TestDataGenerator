package benchmarkdp.datagenerator.workflow;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCaseContainer;

public interface IWorkflowStep {

	public void executeStep(ExperimentProperties ep, TestCaseContainer tCC);
	
	public IWorkflowStep nextStep();
	
}
