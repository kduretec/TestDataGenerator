package benchmarkdp.datagenerator.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import benchmarkdp.datagenerator.testcase.TestCase;

public class VMDeamon {

	private String dropbPathIn = "/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/"
			+ "INFSOF/experiments/ComunicationFolder/ToVM/";
	private String dropbPathOut = "/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/"
			+ "INFSOF/experiments/ComunicationFolder/FromVM/";
	
	public void execute(String platform) {
		sendReport("Hello I am ready to recieve orders", platform);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Process p = Runtime.getRuntime().exec("shutdown -h now");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendReport(String report, String platform) {
		String reportPath = dropbPathOut + platform + ".log";
		File f = new File(reportPath);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(report + "\n");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
