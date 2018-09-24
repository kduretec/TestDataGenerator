package benchmarkdp.datagenerator.app;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.generator.utils.ZipUtil;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCaseContainer;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class ToolEvaluatorStep implements IWorkflowStep {

	private static Logger log = LoggerFactory.getLogger(ToolEvaluatorStep.class);

	private static String COM_FOLDER_TO = "/Users/kresimir/Mount/Hephaistos/Experiments/TaskIn";
	private static String COM_FOLDER_FROM = "/Users/kresimir/Mount/Hephaistos/Experiments/TaskOut";

	@Override
	public void executeStep(ExperimentProperties ep, TestCaseContainer tCC) {

		log.info("Tool Evaluator step");
		if (ep.getExperimentState().compareTo("TEST_CASES_FINALIZED") == 0) {
			copyToEvaluation(ep, tCC);
		} else if (ep.getExperimentState().compareTo("TEST_CASES_SEND_TO_EVALUATION") == 0) {

		}

	}

	@Override
	public IWorkflowStep nextStep() {
		// TODO Auto-generated method stub
		return null;
	}

	private void copyToEvaluation(ExperimentProperties ep, TestCaseContainer tCC) {
		log.info("Sending documents to evaluation");

		try {
			String experimentName = ep.getExperimentName();
			String pathTmp = ep.getFullFolderPath() + "/tmp/" + experimentName;
			File f = new File(pathTmp);
			if (!f.exists()) {
				f.mkdirs();
			}
			File sDocs = new File(ep.getFullFolderPath() + ep.getDocumentFolder());
			File dDocs = new File(pathTmp + "/Documents");
			FileUtils.copyDirectory(sDocs, dDocs);
			File sText = new File(ep.getFullFolderPath() + ep.getTextFolder());
			File dText = new File(pathTmp + "/GroundTruth/Text");
			FileUtils.copyDirectory(sText, dText);
			File sMet = new File(ep.getFullFolderPath() + ep.getMetadataFolder());
			File dMet = new File(pathTmp + "/GroundTruth/Metadata");
			FileUtils.copyDirectory(sMet, dMet);
			
			File propFile = new File (ep.getFullFolderPath() + "properties.xml");
			FileUtils.copyFileToDirectory(propFile, f);
			File tcFile = new File (ep.getFullFolderPath() + "testCases.xml");
			FileUtils.copyFileToDirectory(tcFile, f);
			
			ZipUtil.zipFolder(pathTmp, COM_FOLDER_TO, ep.getExperimentName());
			FileUtils.deleteDirectory(new File(ep.getFullFolderPath() + "/tmp"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
