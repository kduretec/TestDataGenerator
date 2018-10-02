package benchmarkdp.datagenerator.app.deamon;

import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.properties.PropertiesHandler;

public class MainDeamon {

	private static Logger log = LoggerFactory.getLogger(MainDeamon.class);

	private String dropbOut = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/"
			+ "publications/INFSOF/experiments/ComunicationFolder/ToVM/";

	public void execute(String epFile) {
		PropertiesHandler pHandler = new PropertiesHandler();
		ExperimentProperties ep = pHandler.loadProperties(epFile);
		String experimentName = ep.getExperimentName();
		log.info("Experiment name " + experimentName);
		File f = new File(dropbOut);
		String[] zipFiles = f.list(new PlatformFilter(experimentName));
		if (zipFiles.length == 0) {
			log.info("Nothing to do here");
		} else {
			ExecutorService exec = Executors.newFixedThreadPool(2);

			long startTime = System.nanoTime();
			
			for (String fileName : zipFiles) {
				String platform = fileName.substring(fileName.indexOf("-") + 1, fileName.lastIndexOf("."));
				exec.execute(new MainDeamonProc(new VirtualBoxMachine(platform), new MainComDevice(platform),
						experimentName));
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

		}

	}

	private class PlatformFilter implements FilenameFilter {

		private String nameExp;

		public PlatformFilter(String n) {
			nameExp = n;
		}

		@Override
		public boolean accept(File dir, String name) {
			if (name.endsWith(".zip") && name.startsWith(nameExp)) {
				return true;
			}
			return false;
		}

	}

}
