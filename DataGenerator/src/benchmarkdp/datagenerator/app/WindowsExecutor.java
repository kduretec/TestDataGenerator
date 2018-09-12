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
