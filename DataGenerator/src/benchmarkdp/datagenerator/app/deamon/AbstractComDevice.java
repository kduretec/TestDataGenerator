package benchmarkdp.datagenerator.app.deamon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;

public abstract class AbstractComDevice implements IComDevice {

	protected static Logger log;
	
	protected String dropbIn; 
	protected String dropbOut; 
	protected String fileFolder; 
	protected String platform;
	

	public void waitForCommand(String command) {
		String pathFile = dropbIn + platform + "." + command;
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
		System.out.flush();
	}

	public void sendCommand(String command, String content) {
		String pathFile = dropbOut + platform + "." + command;
		//log.info("PATH="+pathFile);
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

	public void deleteCommand(String command) {
		String pathFile = dropbIn + platform + "." + command;
		File f = new File(pathFile);
		f.delete();
	}

	public void waitForFile(String fileName) {
		String pathZip = fileFolder;
		//String fileName = experiment + "-" + platform + ".zip";
		pathZip = pathZip + fileName;
		File f = new File(pathZip); 
		log.info("Waiting for " + fileName);
		while (!f.exists()) {
			
		}
		log.info("File " + fileName + " detected");
	}

	public String readCommand(String command) {
		String pathFile = dropbIn + platform + "." + command;
		File f = new File(pathFile);
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			line = br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}
	
	public String getPlatform() {
		return platform;
	}
}
