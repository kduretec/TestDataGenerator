package benchmarkdp.datagenerator.workflow;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.core.TestDataset;

public interface IWorkflowStep {

	public void executeStep(ExperimentProperties ep, TestDataset tCC);
	
	public IWorkflowStep nextStep();
	
}
