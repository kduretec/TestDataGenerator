package benchmarkdp.datagenerator.app.deamon;

import org.slf4j.LoggerFactory;

public class MainComDevice extends AbstractComDevice{

	
 	public MainComDevice(String platform) {
		this.platform = platform; 
		this.fileFolder = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/"
				+ "publications/INFSOF/experiments/ComunicationFolder/FromVM/";
		this.dropbIn = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/"
				+ "publications/INFSOF/experiments/ComunicationFolder/FromVM/machine/";
		this.dropbOut = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/"
				+ "publications/INFSOF/experiments/ComunicationFolder/ToVM/machine/";
		log = LoggerFactory.getLogger(MainComDevice.class);
	}
	
}
