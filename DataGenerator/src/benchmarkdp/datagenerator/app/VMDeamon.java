package benchmarkdp.datagenerator.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VMDeamon {

	private static Logger log = LoggerFactory.getLogger(VMDeamon.class);
	
	private String dropbPathIn = "/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/"
			+ "INFSOF/experiments/ComunicationFolder/ToVM/machine/";
	private String dropbPathOut = "/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/"
			+ "INFSOF/experiments/ComunicationFolder/FromVM/machine/";

	public void execute(String platform) {
		log.info("VM Deamon is active");
		sendReport("HELLO", platform);
		waitForCommad("EXEC", platform);
		String experiment = readExperiment(platform);
		sendReport("EXECUTING", platform);
		LinuxExecutor work = new LinuxExecutor(1, 10, false);
		work.execute(platform, experiment);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendReport("DONE", platform);
		waitForCommad("RECIEVED", platform);
		try {
			log.info("Going to shutdown now");
			Process p = Runtime.getRuntime().exec("sudo shutdown -h now");
			InputStream is = p.getInputStream(); 
			for (int i = 0; i < is.available(); i++) {
	            System.out.println("" + is.read());
	         }
			Thread.sleep(5000);
			log.info("Bye");
			p.wait();
			System.exit(0);
			//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		    //bw.write("benchmarkdp\n"); 
		    //bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendReport(String report, String platform) {
		String reportPath = dropbPathOut + platform + "." + report;
		File diF = new File(dropbPathOut);
		if (!diF.exists()) {
			diF.mkdirs();
			changeUser(dropbPathOut); 
		}
		File f = new File(reportPath);
		try {

			f.createNewFile();
			changeUser(reportPath); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// try {
		// BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		// bw.write(report + "\n");
		// bw.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	private void waitForCommad(String command, String platform) {
		String commandPath = dropbPathIn + platform + "." + command;
		File diF = new File(dropbPathIn);
		if (!diF.exists()) {
			diF.mkdirs();
			changeUser(dropbPathIn);
		}
		File f = new File(commandPath);
		while (!f.exists()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	String readExperiment(String platform) {
		String pathFile = dropbPathIn + platform + "." + "EXEC";
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
	
	private void changeUser(String p) {
		Path path = Paths.get(p); 
		FileSystem fileSystem = path.getFileSystem();
        UserPrincipalLookupService service = fileSystem.getUserPrincipalLookupService();
        UserPrincipal userPrincipal;
		try {
			userPrincipal = service.lookupPrincipalByName("kresimir");
			Files.setOwner(path, userPrincipal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
