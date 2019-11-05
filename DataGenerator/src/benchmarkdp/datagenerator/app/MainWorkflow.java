package benchmarkdp.datagenerator.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.datacollector.FinalizeStep;
import benchmarkdp.datagenerator.datacollector.FitsStep;
import benchmarkdp.datagenerator.documentgenerator.GenerateDocumentsStep;
import benchmarkdp.datagenerator.generator.MutationStep;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.mappers.PropertiesMapper;
import benchmarkdp.datagenerator.generator.InitializeTestCasesStep;
import benchmarkdp.datagenerator.core.TestDataset;
import benchmarkdp.datagenerator.mappers.TestDatasetMapper;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class MainWorkflow {

	private static Logger log = LoggerFactory.getLogger(MainWorkflow.class);

	public void execute(String propertiesFile) {

		PropertiesMapper ph = new PropertiesMapper();
		if (propertiesFile != null) {
			ExperimentProperties pr = ph.loadProperties(propertiesFile);
			log.info("Experiment name " + pr.getExperimentName());
			log.info("Folder " + pr.getFullFolderPath());
			log.info("Experiment state " + pr.getExperimentState());
			IWorkflowStep step = null;
			String state = pr.getExperimentState();
			TestDataset tCC = null;
			TestDatasetMapper tch = new TestDatasetMapper();

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
			case "TEST_CASES_SENT_TO_EVALUATION":
				step = new ToolEvaluatorStep();
				break;
			default:
				step = null;
				break;
			}
			if (tCC == null) {
				tCC = new TestDataset();
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
