package benchmarkdp.datagenerator.documentgenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.generator.MutationStep;
import benchmarkdp.datagenerator.generator.utils.ZipUtil;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.TestCaseContainer;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class GenerateDocumentsStep implements IWorkflowStep {

	private static String COM_FOLDER_TO = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/INFSOF/ComunicationFolder/ToVM";

	private static Logger log = LoggerFactory.getLogger(MutationStep.class);

	private Map<String, List<TestCase>> ditTC;

	public GenerateDocumentsStep() {
		ditTC = new HashMap<String, List<TestCase>>();
	}

	@Override
	public void executeStep(ExperimentProperties ep, TestCaseContainer tCC) {

		log.info("Distributing test cases to VMs");
		List<TestCase> testCases = tCC.getTestCases();
		String experimentName = ep.getExperimentName();
		String pathTmp = ep.getFullFolderPath() + "/tmp/";
		File f = new File(pathTmp);
		if (!f.exists()) {
			f.mkdir();
		}
		for (TestCase tc : testCases) {
			String k = experimentName + "-" + tc.getPlatform();
			if (!ditTC.containsKey(k)) {
				ditTC.put(k, new ArrayList<TestCase>());
			}
			ditTC.get(k).add(tc);
		}

		for (Map.Entry<String, List<TestCase>> entr : ditTC.entrySet()) {
			createTmpFolder(pathTmp, entr.getKey(), entr.getValue(), ep);
		}
	}

	@Override
	public IWorkflowStep nextStep() {
		// TODO Auto-generated method stub
		return null;
	}

	private void createTmpFolder(String path, String name, List<TestCase> tC, ExperimentProperties ep) {
		String pathFolder = path + name;
		File destDir = new File(pathFolder);
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		String pathExp = ep.getFullFolderPath() + "/" + ep.getExperimentName();
		File srcDir = new File(pathExp);
		try {
			FileUtils.copyDirectory(srcDir, destDir);
			addTestCaseToGenerate(pathFolder, tC);
			ZipUtil.zipFolder(pathFolder, COM_FOLDER_TO, name);
			FileUtils.deleteDirectory(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addTestCaseToGenerate(String path, List<TestCase> testCases) {

		File f = new File(path + "/toGenerate.tsv");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, false));
			for (TestCase tc : testCases) {
				bw.write(tc.getTestCaseName() + "\n");
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
