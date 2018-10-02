package benchmarkdp.datagenerator.app.deamon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainDeamonProc implements Runnable{

	private static Logger log = LoggerFactory.getLogger(MainDeamonProc.class);
	
	private VirtualBoxMachine vbMachine; 
	private IComDevice comDevice; 
	private String experimentName;
	
	
	public MainDeamonProc(VirtualBoxMachine vbMachine, IComDevice comDevice, String experimentName) {
		super();
		this.vbMachine = vbMachine;
		this.comDevice = comDevice;
		this.experimentName = experimentName;
	}


	@Override
	public void run() {
		log.info("Starting " + vbMachine.getPlatform());
		//startVM(platform);
		vbMachine.start();
		//sendCommand(platform, "START", null);
		comDevice.sendCommand("START", null);
		//waitForCommand(platform, "HELLO");
		comDevice.waitForCommand("HELLO");
		//deleteCommand(platform, "HELLO");
		comDevice.deleteCommand("HELLO");
		//sendCommand(platform, "EXEC", experimentName);
		comDevice.sendCommand("EXEC", experimentName);
		//waitForCommand(platform, "EXECUTING");
		comDevice.waitForCommand("EXECUTING");
		//deleteCommand(platform, "EXECUTING");
		comDevice.deleteCommand("EXECUTING");
		//waitForCommand(platform, "DONE");
		comDevice.waitForCommand("DONE");
		//deleteCommand(platform, "DONE");
		comDevice.deleteCommand("DONE");
		comDevice.waitForFile(experimentName + "-" + vbMachine.getPlatform() + ".zip");
		//sendCommand(platform, "RECIEVED", null);
		comDevice.sendCommand("RECIEVED", null);
		vbMachine.waitForShutdown();
	}

}
