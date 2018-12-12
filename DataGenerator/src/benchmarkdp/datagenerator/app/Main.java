package benchmarkdp.datagenerator.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.PatternLayout;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.examples.blackbox.UtilitiesLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.app.deamon.MainDeamon;
import benchmarkdp.datagenerator.app.deamon.VMDeamon;
import benchmarkdp.datagenerator.model.PIM.PIMPackage;
import benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage;
import benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage;

public class Main {

	private static Logger log = LoggerFactory.getLogger(Main.class);

	private Options options;

	public Main() {
		initializeModellingEnvironment();
		initializeCMD();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.execute(args);
	}

	public void execute(String[] args) {
		log.info("Starting the app");

		CommandLine cmd = parseArgs(args);

		if (cmd.hasOption("vm")) {
			log.info("VM workflow setting detected");
			String vmName = cmd.getOptionValue("vm");
			String eName = cmd.getOptionValue("e");
			VMWorkflow vmWork = new VMWorkflow();
			if (cmd.hasOption("p")) {
				int p = Integer.parseInt(cmd.getOptionValue("p"));
				vmWork.setNumbProc(p);
			}
			if (cmd.hasOption("t")) {
				long t = Long.parseLong(cmd.getOptionValue("t"));
				vmWork.setTimeout(t);
			}
			if (cmd.hasOption("v")) {
				vmWork.setVisible(true);
			}
			vmWork.execute(vmName, eName);
		} else if (cmd.hasOption("w")) {
			log.info("Main workflow setting detected");
			String pFile = cmd.getOptionValue("w");
			if (cmd.hasOption("d")) {
				MainDeamon deamon = new MainDeamon();
				deamon.execute(pFile);
			} else {
				MainWorkflow mWork = new MainWorkflow();
				mWork.execute(pFile);
			}
		} else if (cmd.hasOption("a")) {
			log.info("Redirecting log output");
			String vmName = cmd.getOptionValue("a");
			redirectLogging(vmName);
			VMDeamon deamon = new VMDeamon(vmName);
			deamon.execute();
		}
	}

	private void initializeModellingEnvironment() {
		TransformationExecutor.BlackboxRegistry.INSTANCE.registerModule(UtilitiesLibrary.class,
				"m2m.qvt.oml.ExampleJavaLib", "m2m.qvt.oml");

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		PIMPackage mwp = PIMPackage.eINSTANCE;
		PSMDocxPackage pwd = PSMDocxPackage.eINSTANCE;
		PSMLibrePackage pld = PSMLibrePackage.eINSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
	}

	private void initializeCMD() {
		options = new Options();
		Option workflow = Option.builder("w").hasArg(true).desc("point to the expeirment properties file").build();
		Option vm = Option.builder("vm").hasArg(true).desc("name of the vm").build();
		Option experimentName = Option.builder("e").hasArg(true).desc("experiment name").build();
		Option procNumber = Option.builder("p").hasArg(true).desc("number of processes").build();
		Option time = Option.builder("t").hasArg(true).desc("timeout - time to wait for").build();
		Option vis = Option.builder("v").hasArg(false).desc("is visble during generation").build();
		Option deamon = Option.builder("a").hasArg(true).desc("run deamon").build();
		Option mainDeamon = Option.builder("d").hasArg(false).desc("run main deamon").build();
		options.addOption(workflow);
		options.addOption(vm);
		options.addOption(experimentName);
		options.addOption(procNumber);
		options.addOption(time);
		options.addOption(vis);
		options.addOption(deamon);
		options.addOption(mainDeamon);
	}

	private CommandLine parseArgs(String[] args) {
		CommandLineParser cmdLineParser = new DefaultParser();
		CommandLine commandLine = null;
		try {
			commandLine = cmdLineParser.parse(options, args);
		} catch (ParseException parseException) {
			log.info("ERROR: Unable to parse command-line arguments " + Arrays.toString(args) + " due to: "
					+ parseException);
		}
		return commandLine;
	}

	private void redirectLogging(String vmName) {
		FileAppender fa = new FileAppender();
		DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String pathLogs = "/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/"
				+ "INFSOF/experiments/ComunicationFolder/logs/";
		if (vmName.contains("Windows")) {
			pathLogs = "c:\\Users\\" + "Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\publications\\"
					+ "INFSOF\\experiments\\ComunicationFolder\\logs\\";
		}
		fa.setName("FileLogger");
		fa.setFile(pathLogs + vmName + "_" + sdf.format(new Date()) + ".log");
		fa.setLayout(new PatternLayout("%d [%t] %-5p %c %x - %m%n"));
		fa.setThreshold(Level.INFO);
		fa.setAppend(true);
		fa.activateOptions();
		org.apache.log4j.Logger logger = LogManager.getRootLogger();
		logger.getLoggerRepository().resetConfiguration();
		logger.addAppender(fa);
	}
}
