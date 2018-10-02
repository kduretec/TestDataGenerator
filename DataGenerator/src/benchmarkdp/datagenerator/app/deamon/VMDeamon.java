package benchmarkdp.datagenerator.app.deamon;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.app.IVMExecutor;
import benchmarkdp.datagenerator.app.LinuxExecutor;
import benchmarkdp.datagenerator.app.WindowsExecutor;

public class VMDeamon {

	private static Logger log = LoggerFactory.getLogger(VMDeamon.class);

	private String platform;
	private IComDevice comDevice;
	private IVMExecutor work;


	public VMDeamon(String vmName) {
		platform = vmName;
		comDevice = initializeComDevice();
		work = initializeWork();
	}

	public void execute() {
		log.info("VM Deamon is active");
		comDevice.waitForCommand("START");
		// waitForCommad("START", platform);
		comDevice.deleteCommand("START");
		// deleteCommand("START", platform);
		comDevice.sendCommand("HELLO", null);
		// sendReport("HELLO", platform);
		// waitForCommad("EXEC", platform);
		comDevice.waitForCommand("EXEC");
		// String experiment = readExperiment(platform);
		String experiment = comDevice.readCommand("EXEC");
		// waitForExperimentData(experiment, platform);
		comDevice.waitForFile(experiment + "-" + comDevice.getPlatform() + ".zip");
		// deleteCommand("EXEC", platform);
		comDevice.deleteCommand("EXEC");
		// sendReport("EXECUTING", platform);
		comDevice.sendCommand("EXECUTING", null);
		// work = new LinuxExecutor(1, 10, false);
		work.execute(comDevice.getPlatform(), experiment);
		// sendReport("DONE", platform);
		comDevice.sendCommand("DONE", null);
		// waitForCommad("RECIEVED", platform);
		comDevice.waitForCommand("RECIEVED");
		// deleteCommand("RECIEVED", platform);
		comDevice.deleteCommand("RECIEVED");
		log.info("Going to shutdown now");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String command = getShutdown();
			Process p = Runtime.getRuntime().exec(command);
			InputStream is = p.getInputStream();
			for (int i = 0; i < is.available(); i++) {
				System.out.println("" + is.read());
			}
			Thread.sleep(5000);
			log.info("Bye");
			p.wait();
			System.exit(0);
			// BufferedWriter bw = new BufferedWriter(new
			// OutputStreamWriter(p.getOutputStream()));
			// bw.write("benchmarkdp\n");
			// bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private IComDevice initializeComDevice() {
		switch (platform) {
		case "Ubuntu14-LibreOffice4":
			return new LinuxComDevice(platform);
		case "Ubuntu16-LibreOffice5":
			return new LinuxComDevice(platform);
		case "Windows7-MSWord2007":
			return new WindowsComDevice(platform);
		case "Windows7-MSWord2010":
			return new WindowsComDevice(platform);
		case "Windows8_1-MSWord2013":
			return new WindowsComDevice(platform);
		}
		return null;
	}
	
	private IVMExecutor initializeWork() {
		switch (platform) {
		case "Ubuntu14-LibreOffice4":
			return new LinuxExecutor(1, 10, false);
		case "Ubuntu16-LibreOffice5":
			return new LinuxExecutor(1, 10, false);
		case "Windows7-MSWord2007":
			return new WindowsExecutor(2, 10, false);
		case "Windows7-MSWord2010":
			return new WindowsExecutor(2, 10, false);
		case "Windows8_1-MSWord2013":
			return new WindowsExecutor(2, 10, false);
		}
		return null;
	}

	private String getShutdown() {
		switch (platform) {
		case "Ubuntu14-LibreOffice4":
			return "sudo shutdown -h now";
		case "Ubuntu16-LibreOffice5":
			return "sudo shutdown -h now";
		case "Windows7-MSWord2007":
			return "shutdown -s";
		case "Windows7-MSWord2010":
			return "shutdown -s";
		case "Windows8_1-MSWord2013":
			return "shutdown -s";
		}
		return null;
	}
	/*
	 * private void changeUser(String p) { Path path = Paths.get(p); FileSystem
	 * fileSystem = path.getFileSystem(); UserPrincipalLookupService service =
	 * fileSystem.getUserPrincipalLookupService(); UserPrincipal userPrincipal;
	 * try { userPrincipal = service.lookupPrincipalByName("kresimir");
	 * Files.setOwner(path, userPrincipal); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
}
