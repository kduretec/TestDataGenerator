package benchmarkdp.datagenerator.app;

import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCase;

public class WindowsExecutor extends AbstractVMExecutor {

	public WindowsExecutor(int numbProc, long timeout, boolean visible) {
		super(numbProc, timeout, visible);
		log = LoggerFactory.getLogger(WindowsExecutor.class);

		dropbPathIn = "c:\\Users\\" + "Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\publications\\"
				+ "INFSOF\\experiments\\ComunicationFolder\\ToVM\\";
		dropbPathOut = "c:\\Users\\" + "Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\publications\\"
				+ "INFSOF\\experiments\\ComunicationFolder\\FromVM\\";

		tmpFolder = "c:\\Users\\Kresimir Duretec\\Desktop\\tmp\\";
	}

	@Override
	protected void initializeExecution(ExperimentProperties ep, String platform, String experiment) {
		
	}
	
	@Override
	protected Runnable getRunnable(ExperimentProperties ep, TestCase tc, long timeout, boolean visible) {
		return new WindowsVMProc(ep, tc, timeout, visible);
	}



}
