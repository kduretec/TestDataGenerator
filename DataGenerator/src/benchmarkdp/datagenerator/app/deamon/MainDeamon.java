package benchmarkdp.datagenerator.app.deamon;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.properties.PropertiesHandler;
import benchmarkdp.datagenerator.testcase.TestCase;

public class MainDeamon {

	private static Logger log = LoggerFactory.getLogger(MainDeamon.class);

	private String dropbOut = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/"
			+ "publications/INFSOF/experiments/ComunicationFolder/ToVM/";
	private String dropbIn = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/"
			+ "publications/INFSOF/experiments/ComunicationFolder/FromVM/";

	public void execute(String epFile) {
		PropertiesHandler pHandler = new PropertiesHandler();
		ExperimentProperties ep = pHandler.loadProperties(epFile);
		String experimentName = ep.getExperimentName();
		log.info("Experiment name " + experimentName);
		File f = new File(dropbOut);
		String[] zipFiles = f.list(new PlatformFilter(experimentName));
		if (zipFiles.length == 0) {
			log.info("Nothing to do here");
		}
		for (String fileName : zipFiles) {
			String platform = fileName.substring(fileName.indexOf("-") + 1, fileName.lastIndexOf("."));
			executePlatform(platform, experimentName);
		}
	}

	private void executePlatform(String platform, String experimentName) {

		log.info("Starting " + platform);
		startVM(platform);
		sendCommand(platform, "START", null);
		waitForCommand(platform, "HELLO");
		deleteCommand(platform, "HELLO");
		sendCommand(platform, "EXEC", experimentName);
		waitForCommand(platform, "EXECUTING");
		deleteCommand(platform, "EXECUTING");
		waitForCommand(platform, "DONE");
		deleteCommand(platform, "DONE");
		sendCommand(platform, "RECIEVED", null);
		finalizeVM(platform);
	}

	private void startVM(String vm) {
		String command = "VBoxManage startvm ";
		command = command + vm;
		command = command + " --type headless";
		try {
			Process p = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void finalizeVM(String vm) {
		log.info("Waiting " + vm + " to shutdown");
		

	}

	private void waitForCommand(String platform, String command) {
		String pathFile = dropbIn + "machine/" + platform + "." + command;
		File f = new File(pathFile);
		log.info("Waiting for " + command + " from " + platform);
		while (!f.exists()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.info("Recieved " + command + " from " + platform);
	}

	private void deleteCommand(String platform, String command) {
		String pathFile = dropbIn + "machine/" + platform + "." + command;
		File f = new File(pathFile);
		f.delete();
	}

	private void sendCommand(String platform, String command, String content) {
		String pathFile = dropbOut + "machine/" + platform + "." + command;
		File f = new File(pathFile);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (content != null) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(content + "\n");
				bw.close();
			} catch (IOException e) {
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
