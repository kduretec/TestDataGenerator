package benchmarkdp.datagenerator.app.deamon;

import org.slf4j.LoggerFactory;

public class LinuxComDevice extends AbstractComDevice{
	
	public LinuxComDevice(String platform) {
		this.platform = platform; 
		this.fileFolder = "/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/"
				+ "INFSOF/experiments/ComunicationFolder/ToVM/";
		this.dropbIn = "/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/"
				+ "INFSOF/experiments/ComunicationFolder/ToVM/machine/";
		this.dropbOut = "/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/"
				+ "INFSOF/experiments/ComunicationFolder/FromVM/machine/";
		log = LoggerFactory.getLogger(LinuxComDevice.class);
	}

}
