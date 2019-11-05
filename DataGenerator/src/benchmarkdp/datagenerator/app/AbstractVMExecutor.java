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

import benchmarkdp.datagenerator.generator.utils.ZipUtil;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.mappers.PropertiesMapper;
import benchmarkdp.datagenerator.core.TestCase;
import benchmarkdp.datagenerator.core.TestDataset;
import benchmarkdp.datagenerator.mappers.TestDatasetMapper;

public abstract class AbstractVMExecutor implements IVMExecutor{
	
	protected static Logger log;

	protected String dropbPathIn;
	protected String dropbPathOut;

	protected String tmpFolder;

	protected int numbProc;
	
	protected long timeout;
	
	protected boolean visible;

	public AbstractVMExecutor(int numbProc, long timeout, boolean visible) {
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
				String ePropFile = rootFolder + File.separator + "properties.xml";
				PropertiesMapper ph = new PropertiesMapper();
				eProperties = ph.loadProperties(ePropFile);

				String documentsFolder = rootFolder + File.separator + eProperties.getDocumentFolder();
				File fDocs = new File(documentsFolder);
				fDocs.mkdirs();
				String metaFolder = rootFolder + File.separator + eProperties.getGeneratedMetadataFolder();
				File fMeta = new File(metaFolder);
				fMeta.mkdirs();
				String textFolder = rootFolder + File.separator + eProperties.getGeneratedTextFolder();
				File fText = new File(textFolder);
				fText.mkdirs();
				initializeExecution(eProperties, platform, experiment);
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
		TestDatasetMapper th = new TestDatasetMapper();
		TestDataset tCC = th.load(ep, false);
		log.info("Loaded testcases");
		Set<String> toGenerate = loadCasesToGenerate(ep);
		log.info("Detected " + toGenerate.size() + " testcases to generate");
		long startTime = System.nanoTime();
		ExecutorService exec = Executors.newFixedThreadPool(numbProc);
		
		for (TestCase tc : tCC.getTestCases()) {
			if (toGenerate.contains(tc.getTestCaseName())) {
				
				exec.execute(getRunnable(ep, tc, timeout, visible));
			}

		}
		exec.shutdown();
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
			long endTime = System.nanoTime();
			double elapsedTime = ((double) endTime - startTime) / 1000000000;
			log.info("Generation done in " + elapsedTime + " seconds");
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File f = new File(dropbPathIn + experiment + "-" + platform + ".zip");
		f.delete();
	}

	private Set<String> loadCasesToGenerate(ExperimentProperties ep) {
		Set<String> toGen = new HashSet<String>();
		String toGenPath = ep.getFullFolderPath() + File.separator + "toGenerate.tsv";
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
	
	protected abstract void initializeExecution(ExperimentProperties ep, String platform, String experiment); 
	
	protected abstract Runnable getRunnable(ExperimentProperties ep, TestCase tc, long timeout, boolean visible); 

}
