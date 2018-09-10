package benchmarkdp.datagenerator.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.generator.MutationProc;
import benchmarkdp.datagenerator.generator.utils.ZipUtil;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.properties.PropertiesHandler;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.TestCaseContainer;
import benchmarkdp.datagenerator.testcase.TestCaseHandler;

public class WindowsVM {

	private static Logger log = LoggerFactory.getLogger(WindowsVM.class);

	private static String dropbPathIn = "c:\\Users\\"
			+ "Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\publications\\"
			+ "INFSOF\\experiments\\ComunicationFolder\\ToVM\\";
	private static String dropbPathOut = "c:\\Users\\"
			+ "Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\publications\\"
			+ "INFSOF\\experiments\\ComunicationFolder\\FromVM\\";

	private static String tmpFolder = "c:\\Users\\Kresimir Duretec\\Desktop\\tmp\\";

	private int numbProc;
	
	private long timeout;
	
	private boolean visible; 	
	
	public WindowsVM(int numbProc, long timeout, boolean visible) {
		this.numbProc = numbProc;
		this.timeout = timeout;
		this.visible = visible;
	}

	public void execute(String platform, String experiment) {

		ExperimentProperties ep = prepareExperiment(platform, experiment);
		if (ep != null) {
		log.info("Experiment name " + ep.getExperimentName() + " is prepared");
		runDataGeneration(ep);
		log.info("Document generation done");
		finalize(platform, experiment, ep);
		} else {
			log.info("Quitting, nothing to do");
		}
	}

	private ExperimentProperties prepareExperiment(String platform, String experiment) {
		ExperimentProperties eProperties = null;
		String rootFolder = tmpFolder;
		String zipFile = dropbPathIn + experiment + "-" + platform + ".zip";
		File f = new File(zipFile);
		if (f.exists()) {
			log.info("File detected");
			File tmpF = new File(tmpFolder);
			if (!tmpF.exists()) {
				tmpF.mkdir();
			}
			try {
				ZipUtil.unzipFile(zipFile, tmpFolder);

				rootFolder = rootFolder + experiment + "-" + platform;
				String ePropFile = rootFolder + "\\properties.xml";
				PropertiesHandler ph = new PropertiesHandler();
				eProperties = ph.loadProperties(ePropFile);

				String documentsFolder = rootFolder + "\\" + eProperties.getDocumentFolder();
				File fDocs = new File(documentsFolder);
				fDocs.mkdirs();
				String metaFolder = rootFolder + "\\" + eProperties.getGeneratedMetadataFolder();
				File fMeta = new File(metaFolder);
				fMeta.mkdirs();
				String textFolder = rootFolder + "\\" + eProperties.getGeneratedTextFolder();
				File fText = new File(textFolder);
				fText.mkdirs();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return eProperties;
		} else {
			log.warn("Unable to find " + zipFile);
			return null;
		}
	}

	private void runDataGeneration(ExperimentProperties ep) {
		TestCaseHandler th = new TestCaseHandler();
		TestCaseContainer tCC = th.load(ep, false);
		log.info("Loaded testcases");
		Set<String> toGenerate = loadCasesToGenerate(ep);
		log.info("Detected " + toGenerate.size() + " testcases to generate");

		ExecutorService exec = Executors.newFixedThreadPool(numbProc);

		for (TestCase tc : tCC.getTestCases()) {
			if (toGenerate.contains(tc.getTestCaseName())) {
				
				exec.execute(new WindowsVMProc(ep, tc, timeout, visible));
			}

		}
		exec.shutdown();
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th.save(ep, tCC);
	}

	private void finalize(String platform, String experiment, ExperimentProperties ep) {
		try {
			ZipUtil.zipFolder(ep.getFullFolderPath(), dropbPathOut, experiment + "-" + platform);
			FileUtils.deleteDirectory(new File(ep.getFullFolderPath()));
			File f = new File(dropbPathIn + experiment + "-" + platform + ".zip");
			//f.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Set<String> loadCasesToGenerate(ExperimentProperties ep) {
		Set<String> toGen = new HashSet<String>();
		String toGenPath = ep.getFullFolderPath() + "\\toGenerate.tsv";
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
}
