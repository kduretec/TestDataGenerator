package benchmarkdp.datagenerator.documentgenerator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.generator.utils.ZipUtil;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.properties.PropertiesHandler;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.TestCaseContainer;
import benchmarkdp.datagenerator.testcase.TestCaseHandler;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class GenerateDocumentsStep implements IWorkflowStep {

	private static Logger log = LoggerFactory.getLogger(GenerateDocumentsStep.class);

	private static String COM_FOLDER_TO = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/INFSOF/experiments/ComunicationFolder/ToVM";
	private static String COM_FOLDER_FROM = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/INFSOF/experiments/ComunicationFolder/FromVM";

	private Map<String, List<TestCase>> ditTC;

	public GenerateDocumentsStep() {
		ditTC = new HashMap<String, List<TestCase>>();
	}

	@Override
	public void executeStep(ExperimentProperties ep, TestCaseContainer tCC) {

		log.info("Generating step");
		if (ep.getExperimentState().compareTo("TEST_CASES_MUTATED") == 0) {
			distributeTestCases(ep, tCC);
		} else if (ep.getExperimentState().compareTo("TEST_CASES_DISTRIBUTED") == 0) {
			collectTestCases(ep, tCC);
		} else if (ep.getExperimentState().compareTo("TEST_CASES_COLLECTED") == 0) {
			//distributeTestCases(ep, tCC);
		}

	}

	@Override
	public IWorkflowStep nextStep() {
		// TODO Auto-generated method stub
		return null;
	}

	private void distributeTestCases(ExperimentProperties ep, TestCaseContainer tCC) {
		log.info("Distributing test cases to VMs");
		List<TestCase> testCases = tCC.getTestCases();
		String experimentName = ep.getExperimentName();
		String pathTmp = ep.getFullFolderPath() + "/tmp/";
		File f = new File(pathTmp);
		if (!f.exists()) {
			f.mkdir();
		}
		for (TestCase tc : testCases) {
			if (tc.getTestCaseState().compareTo("MUTATED") == 0
					|| tc.getTestCaseState().compareTo("GENERATION_ERROR") == 0) {
				String k = experimentName + "-" + tc.getPlatform();
				if (!ditTC.containsKey(k)) {
					ditTC.put(k, new ArrayList<TestCase>());
				}
				ditTC.get(k).add(tc);
			}
		}

		for (Map.Entry<String, List<TestCase>> entr : ditTC.entrySet()) {
			createTmpFolder(pathTmp, entr.getKey(), entr.getValue(), ep);
		}
		if (ditTC.size() == 0) {
			ep.setExperimentState("TEST_CASES_COLLECTED");
		} else {
			ep.setExperimentState("TEST_CASES_DISTRIBUTED");
		}
	}

	private void createTmpFolder(String path, String name, List<TestCase> tC, ExperimentProperties ep) {
		String pathFolder = path + name;
		String platform = tC.get(0).getPlatform();
		File destDir = new File(pathFolder);
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		String foldExperiment = pathFolder + "/" + ep.getExperimentName();
		File fileExperiment = new File(foldExperiment);
		if (!fileExperiment.exists()) {
			fileExperiment.mkdir();
		}

		String testCasesPath = ep.getFullFolderPath() + "/testCases.xml";
		File testCasesFile = new File(testCasesPath);
		String propertiesPath = ep.getFullFolderPath() + "/properties.xml";
		File propertiesFile = new File(propertiesPath);
		String pathExp = ep.getFullFolderPath() + "/" + ep.getExperimentName() + "/Macro/" + platform;
		File srcDir = new File(pathExp);

		String destFolderMacro = foldExperiment + "/Macro/" + platform;
		File destDirMacro = new File(destFolderMacro);
		/*
		 * if (!destDirMacro.exists()) { destDirMacro.mkdirs(); }
		 */
		try {
			FileUtils.copyFileToDirectory(testCasesFile, destDir);
			FileUtils.copyFileToDirectory(propertiesFile, destDir);
			FileUtils.copyDirectory(srcDir, destDirMacro);
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

	private void collectTestCases(ExperimentProperties ep, TestCaseContainer tCC) {
		log.info("Collecting data");
		File[] zipFiles = getAllZipFiles(ep);

		for (File f : zipFiles) {
			processReturnZip(f, ep, tCC);
		}
		ep.setExperimentState("TEST_CASES_MUTATED");
	}

	private void processReturnZip(File f, ExperimentProperties ep, TestCaseContainer tCC) {
		log.info("Processing and merging " + f.getName());
		String name = f.getName().substring(0, f.getName().lastIndexOf("."));
		try {
			ZipUtil.unzipFile(f.getAbsolutePath(), ep.getFullFolderPath());
			String unZipFolder = ep.getFullFolderPath() + name;
			PropertiesHandler ph = new PropertiesHandler();
			ExperimentProperties epNew = ph.loadProperties(unZipFolder + File.separator + "properties.xml");
			TestCaseHandler th = new TestCaseHandler();
			TestCaseContainer tCCNew = th.load(epNew, false);
			mergeTestCases(ep, tCC, epNew, tCCNew);
			FileUtils.deleteDirectory(new File(unZipFolder));
			f.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void mergeTestCases(ExperimentProperties eOrig, TestCaseContainer tOrig, ExperimentProperties eNew,
			TestCaseContainer tNew) {
		List<String> tcGen = loadCasesToGenerate(eNew);

		for (String tName : tcGen) {
			TestCase originalT = tOrig.getTestCase(tName);
			TestCase newT = tNew.getTestCase(tName);
			if (newT.getTestCaseState().compareTo("DOCUMENT_GENERATED") == 0) {
				try {
					FileUtils.copyFileToDirectory(new File(eNew.getFullFolderPath() + newT.getGeneratedDocument()),
							new File(eOrig.getFullFolderPath() + eNew.getDocumentFolder()));
					originalT.setGeneratedDocument(newT.getGeneratedDocument());

					FileUtils.copyFileToDirectory(new File(eNew.getFullFolderPath() + newT.getGeneratedMetadata()),
							new File(eOrig.getFullFolderPath() + eNew.getGeneratedMetadataFolder()));
					originalT.setGeneratedMetadata(newT.getGeneratedMetadata());

					FileUtils.copyFileToDirectory(new File(eNew.getFullFolderPath() + newT.getGeneratedText()),
							new File(eOrig.getFullFolderPath() + eNew.getGeneratedTextFolder()));
					originalT.setGeneratedText(newT.getGeneratedText());

					originalT.setTestCaseState(newT.getTestCaseState());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (newT.getTestCaseState().compareTo("GENERATION_ERROR") == 0) {
				originalT.setTestCaseState(newT.getTestCaseState());
			}
		}
	}

	private List<String> loadCasesToGenerate(ExperimentProperties ep) {
		List<String> toGen = new ArrayList<String>();
		String toGenPath = ep.getFullFolderPath() + "toGenerate.tsv";
		File f = new File(toGenPath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));

			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				if (line.length() == 0)
					continue;
				toGen.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toGen;
	}

	private File[] getAllZipFiles(ExperimentProperties ep) {
		String name = ep.getExperimentName();
		File zipFolder = new File(COM_FOLDER_FROM);
		return zipFolder.listFiles(new ExpZipFilter(name));
	}

	private class ExpZipFilter implements FileFilter {

		private String name;

		public ExpZipFilter(String n) {
			name = n;
		}

		@Override
		public boolean accept(File pathname) {
			return pathname.getName().startsWith(name);
		}

	}
}
