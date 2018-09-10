package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCase;

public class FitsProc implements Runnable {

	private static Logger log = LoggerFactory.getLogger(FitsProc.class);

	private ExperimentProperties ep;
	private TestCase tc;

	public FitsProc(ExperimentProperties ep, TestCase tc) {
		this.ep = ep;
		this.tc = tc;
	}

	@Override
	public void run() {
		log.info("Running FITS on " + tc.getTestCaseName());
		String fits = "bash /Users/kresimir/Programs/fits-1.0.1/fits.sh";
		String inputFile = ep.getFullFolderPath() + tc.getGeneratedDocument();
		String relFits = ep.getFitsFolder() + File.separator + tc.getTestCaseName() + ".fits.xml";
		String outputFile = ep.getFullFolderPath() + relFits;
		// log.info(fits + "\n" + inputFile + "\n" + outputFile);
		String command = fits + " -i " + inputFile + " -o " + outputFile;
		try {
			Process p = Runtime.getRuntime().exec(command);
			p.waitFor();
			File f = new File(outputFile);
			if (f.exists()) {
				tc.setFitsFile(relFits);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}