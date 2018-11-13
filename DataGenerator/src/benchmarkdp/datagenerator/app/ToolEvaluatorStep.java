package benchmarkdp.datagenerator.app;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.generator.utils.ZipUtil;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.properties.PropertiesHandler;
import benchmarkdp.datagenerator.testcase.TestCaseContainer;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class ToolEvaluatorStep implements IWorkflowStep {

	private static Logger log = LoggerFactory.getLogger(ToolEvaluatorStep.class);

	//private static String COM_FOLDER_TO = "/Users/kresimir/Mount/Hephaistos/Experiments/TaskIn";
	//private static String COM_FOLDER_FROM = "/Users/kresimir/Mount/Hephaistos/Experiments/TaskOut";
	
	private static String COM_FOLDER_TO = "/Users/kresimir/Mount/Canada/Experiments/TaskIn";
	private static String COM_FOLDER_FROM = "/Users/kresimir/Mount/Canada/Experiments/TaskOut";

	@Override
	public void executeStep(ExperimentProperties ep, TestCaseContainer tCC) {

		log.info("Tool Evaluator step");
		if (ep.getExperimentState().compareTo("TEST_CASES_FINALIZED") == 0) {
			copyToEvaluation(ep, tCC);
			ep.setExperimentState("TEST_CASES_SENT_TO_EVALUATION");
		} else if (ep.getExperimentState().compareTo("TEST_CASES_SENT_TO_EVALUATION") == 0) {
			gatherFromEvaluation(ep, tCC);	
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
			String zipFolder = pathTmp;
			pathTmp = pathTmp + "/" + experimentName;
			File sDocs = new File(ep.getFullFolderPath() + ep.getDocumentFolder());
			File dDocs = new File(pathTmp + "/Documents");
			FileUtils.copyDirectory(sDocs, dDocs);
			File sText = new File(ep.getFullFolderPath() + ep.getTextFolder());
			File dText = new File(pathTmp + "/GroundTruth/Text");
			FileUtils.copyDirectory(sText, dText);
			File sMet = new File(ep.getFullFolderPath() + ep.getMetadataFolder());
			File dMet = new File(pathTmp + "/GroundTruth/Metadata");
			FileUtils.copyDirectory(sMet, dMet);

			File propFile = new File(ep.getFullFolderPath() + "properties.xml");
			FileUtils.copyFileToDirectory(propFile, f);
			File tcFile = new File(ep.getFullFolderPath() + "testCases.xml");
			FileUtils.copyFileToDirectory(tcFile, f);

			ZipUtil.zipFolder(zipFolder, COM_FOLDER_TO, ep.getExperimentName());
			FileUtils.deleteDirectory(new File(ep.getFullFolderPath() + "/tmp"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void gatherFromEvaluation(ExperimentProperties ep, TestCaseContainer tCC) {
		log.info("Gathering results from evaluation");
		String experimentName = ep.getExperimentName();
		String pathZip = COM_FOLDER_FROM + "/" + experimentName + ".zip";
		File zipFile = new File(pathZip);
		if (zipFile.exists()) {

			try {
				String pathTmp = ep.getFullFolderPath() + "/tmp/";
				File f = new File(pathTmp);
				if (!f.exists()) {
					f.mkdirs();
				}
				ZipUtil.unzipFile(pathZip, pathTmp);
				PropertiesHandler phtmp = new PropertiesHandler();
				ExperimentProperties epTmp = phtmp.loadProperties(pathTmp + experimentName + "/properties.xml");
				String toolTmpPath = epTmp.getFullFolderPath() + epTmp.getToolOutputFolder();
				String toolPath = ep.getFullFolderPath() + ep.getExperimentName();
				File toolTmpFold = new File(toolTmpPath);
				File toolFold = new File(toolPath);
				FileUtils.copyDirectoryToDirectory(toolTmpFold, toolFold);
				
				String resTmpPath = epTmp.getFullFolderPath() + epTmp.getResultsFolder();
				String resPath = ep.getFullFolderPath() + ep.getExperimentName();
				File resTmpFold = new File(resTmpPath);
				File resFold = new File(resPath);
				FileUtils.copyDirectoryToDirectory(resTmpFold, resFold);
				FileUtils.deleteDirectory(f);
				/*
				 * String zipFolder = pathTmp; pathTmp = pathTmp + "/" +
				 * experimentName; File sDocs = new File(ep.getFullFolderPath()
				 * + ep.getDocumentFolder()); File dDocs = new File(pathTmp +
				 * "/Documents"); FileUtils.copyDirectory(sDocs, dDocs); File
				 * sText = new File(ep.getFullFolderPath() +
				 * ep.getTextFolder()); File dText = new File(pathTmp +
				 * "/GroundTruth/Text"); FileUtils.copyDirectory(sText, dText);
				 * File sMet = new File(ep.getFullFolderPath() +
				 * ep.getMetadataFolder()); File dMet = new File(pathTmp +
				 * "/GroundTruth/Metadata"); FileUtils.copyDirectory(sMet,
				 * dMet);
				 * 
				 * File propFile = new File(ep.getFullFolderPath() +
				 * "properties.xml"); FileUtils.copyFileToDirectory(propFile,
				 * f); File tcFile = new File(ep.getFullFolderPath() +
				 * "testCases.xml"); FileUtils.copyFileToDirectory(tcFile, f);
				 * 
				 * ZipUtil.zipFolder(zipFolder, COM_FOLDER_TO,
				 * ep.getExperimentName()); FileUtils.deleteDirectory(new
				 * File(ep.getFullFolderPath() + "/tmp"));
				 */
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			log.info("Seems like there is nothing to gather, exiting");
		}

	}
}
