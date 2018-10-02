package benchmarkdp.datagenerator.app.deamon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VirtualBoxMachine {

	private static Logger log = LoggerFactory.getLogger(VirtualBoxMachine.class);

	private String vmName;

	public VirtualBoxMachine(String name) {
		vmName = name;
	}

	public String getPlatform() {
		return vmName; 
	}
	
	public void start() {
		String command = "VBoxManage startvm ";
		command = command + vmName;
		command = command + " --type headless";
		try {
			Process p = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForShutdown() {
		log.info("Waiting " + vmName + " to shutdown");
		while (isRunning()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean isRunning() {
		String command = "VBoxManage list runningvms";
		try {
			Process p = Runtime.getRuntime().exec(command);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuffer sb = new StringBuffer(); 
			String s = null;
			while ((s = br.readLine()) != null) {
			    sb.append(s + " ");
			}
			s = sb.toString();
			if (s.indexOf(vmName) >= 0) {
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
