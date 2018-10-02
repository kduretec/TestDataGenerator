package benchmarkdp.datagenerator.app.deamon;

import org.slf4j.LoggerFactory;

public class WindowsComDevice extends AbstractComDevice{
	
	public WindowsComDevice(String platform) {
		this.platform = platform; 
		this.fileFolder = "c:\\Users\\" + "Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\publications\\"
				+ "INFSOF\\experiments\\ComunicationFolder\\ToVM\\";
		this.dropbIn = "c:\\Users\\" + "Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\publications\\"
				+ "INFSOF\\experiments\\ComunicationFolder\\ToVM\\machine\\";
		this.dropbOut = "c:\\Users\\" + "Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\publications\\"
				+ "INFSOF\\experiments\\ComunicationFolder\\FromVM\\machine\\";
		log = LoggerFactory.getLogger(WindowsComDevice.class);
		
	}

}
