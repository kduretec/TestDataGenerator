package benchmarkdp.datagenerator.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.datacollector.FinalizeStep;
import benchmarkdp.datagenerator.datacollector.FitsStep;
import benchmarkdp.datagenerator.documentgenerator.GenerateDocumentsStep;
import benchmarkdp.datagenerator.generator.MutationStep;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.properties.PropertiesHandler;
import benchmarkdp.datagenerator.testcase.InitializeTestCasesStep;
import benchmarkdp.datagenerator.testcase.TestCaseContainer;
import benchmarkdp.datagenerator.testcase.TestCaseHandler;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class MainWorkflow {

	private static Logger log = LoggerFactory.getLogger(MainWorkflow.class);

	public void execute(String propertiesFile) {

		PropertiesHandler ph = new PropertiesHandler();
		if (propertiesFile != null) {
			ExperimentProperties pr = ph.loadProperties(propertiesFile);
			log.info("Experiment name " + pr.getExperimentName());
			log.info("Folder " + pr.getFullFolderPath());
			log.info("Experiment state " + pr.getExperimentState());
			IWorkflowStep step = null;
			String state = pr.getExperimentState();
			TestCaseContainer tCC = null;
			TestCaseHandler tch = new TestCaseHandler();

			if (state.compareTo("START") != 0 && state.compareTo("FOLDER_STRUCTURE_INITIALIZED") != 0) {
				tCC = tch.load(pr, true);
				log.info(tCC.numberTestCases() + " testcases loaded");
				// log.info("TestCase number " + tCC.numberTestCases());
				// log.info(tCC.getTestCases().get(0).getTestFeature().getFeature("numWords"));
			}
			switch (state) {
			case "START":
				step = new InitializeFolderStep();
				break;
			case "FOLDER_STRUCTURE_INITIALIZED":
				step = new InitializeTestCasesStep();
				break;
			case "TEST_CASES_INITIALIZED":
				step = new MutationStep();
				break;
			case "TEST_CASES_MUTATED":
				step = new GenerateDocumentsStep();
				break;
			case "TEST_CASES_DISTRIBUTED":
				step = new GenerateDocumentsStep();
				break;
			case "TEST_CASES_COLLECTED":
				step = new FitsStep();
				break;
			case "TEST_CASES_FITSDONE":
				step = new FinalizeStep();
				break;
			case "TEST_CASES_FINALIZED":
				step = new ToolEvaluatorStep();
				break;
			default:
				step = null;
				break;
			}
			if (tCC == null) {
				tCC = new TestCaseContainer();
			}
			
			while (step != null) {
				step.executeStep(pr, tCC);
				log.info("State = " + pr.getExperimentState());
				ph.saveProperties(pr);
				if (tCC.numberTestCases() > 0) {
					tch.save(pr, tCC);
				}
				step = step.nextStep();
			}
			
			log.info("Done");
		}

	}
}
