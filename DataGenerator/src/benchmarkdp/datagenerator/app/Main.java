package benchmarkdp.datagenerator.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.properties.PropertiesHandler;

public class Main {

	private static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		log.info("Starting the app");
		PropertiesHandler ph = new PropertiesHandler();
		if (args.length > 0) {
			ExperimentProperties pr = ph.loadProperties(args[0]);
			log.info("Experiment name "  + pr.getExperimentName());
			log.info("Folder " + pr.getFullFolderPath());
		}

	}

}
