package benchmarkdp.datagenerator.app;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCase;

public class LinuxVMProc implements Runnable {

	private static Logger log = LoggerFactory.getLogger(LinuxVMProc.class);

	private TestCase tc;
	private ExperimentProperties ep;

	private long timeout;
	private boolean visible;

	public LinuxVMProc(ExperimentProperties e, TestCase t, long tout, boolean vis) {
		tc = t;
		ep = e;
		timeout = tout;
		visible = vis;
	}

	@Override
	public void run() {
		log.info("Generating " + tc.getTestCaseName());

		String documentFolder = ep.getFullFolderPath() + ep.getDocumentFolder() + File.separator;
		// documentFolder = documentFolder.replace("/", "\\");
		String metadataFolder = ep.getFullFolderPath() + ep.getGeneratedMetadataFolder() + File.separator;
		// metadataFolder = metadataFolder.replace("/", "\\");
		String textFolder = ep.getFullFolderPath() + ep.getGeneratedTextFolder() + File.separator;
		// textFolder = textFolder.replace("/", "\\");
		// log.info("Document folder = " + documentFolder);
		// log.info("Metadatafolder = " + metadataFolder);
		// log.info("Textfolder = " + textFolder);

		// scriptFilePath = scriptFilePath.replace("/", "\\");
		// log.info("Script path = " + scriptFilePath);
		try {
			String command = "soffice";
			if (!visible) {
				command = command + " --headless";
			}
			command = command + " macro:///Experiment.main_" + tc.getTestCaseName() + ".Main(" + documentFolder + ","
					+ metadataFolder + "," + textFolder + ")";
			// String command = "soffice";
			// log.info("Executing = " + command);
			Process p = Runtime.getRuntime().exec(command);
			// p.waitFor();
			// log.info("TIMEOUT in minutes is " + timeout);
			if (p.waitFor(timeout, TimeUnit.MINUTES)) {
				File f = new File(documentFolder);
				String[] docs = f.list(new FFilter(tc.getTestCaseName()));
				if (docs.length > 0) {
					tc.setGeneratedDocument(ep.getDocumentFolder() + "/" + docs[0]);
					String metadataPath = metadataFolder + tc.getTestCaseName() + ".txt";
					File metadataFile = new File(metadataPath);
					if (metadataFile.exists()) {
						tc.setGeneratedMetadata(ep.getGeneratedMetadataFolder() + "/" + metadataFile.getName());
					}
					String textPath = textFolder + tc.getTestCaseName() + ".txt";
					File textFile = new File(textPath);
					if (textFile.exists()) {
						tc.setGeneratedText(ep.getGeneratedTextFolder() + "/" + textFile.getName());
					}
					tc.setTestCaseState("DOCUMENT_GENERATED");
				} else {
					tc.setTestCaseState("GENERATION_ERROR");
					log.error("ERROR during generating " + tc.getTestCaseName());
				}
			} else {
				// p.destroyForcibly();
				tc.setTestCaseState("GENERATION_ERROR");
				log.error("TIMEOUT during generating " + tc.getTestCaseName());
			}

		} catch (IOException e) {
			tc.setTestCaseState("GENERATION_ERROR");
			// e.printStackTrace();
			log.error("ERROR during generating " + tc.getTestCaseName());
		} catch (InterruptedException e) {
			tc.setTestCaseState("GENERATION_ERROR");
			// e.printStackTrace();
			log.error("ERROR during generating " + tc.getTestCaseName());
		}

	}

	private class FFilter implements FilenameFilter {
		private String fname;

		public FFilter(String n) {
			fname = n;
		}

		public boolean accept(File dir, String name) {
			// log.info("Checking " + name + " with " + fname);
			return name.startsWith(fname);
		}
	}

}
