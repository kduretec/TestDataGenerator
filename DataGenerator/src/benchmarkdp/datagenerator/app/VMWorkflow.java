package benchmarkdp.datagenerator.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VMWorkflow {

	private static Logger log = LoggerFactory.getLogger(VMWorkflow.class);

	private int numbProc = 4;

	private long timeout = 10;

	private boolean visible = false;

	public void setNumbProc(int numbProc) {
		this.numbProc = numbProc;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void execute(String platform, String experiment) {
		log.info("VM workflow detected platform " + platform + " and expeirment " + experiment);

		if (platform.compareTo("Windows7-MSWord2007") == 0) {
			WindowsVM work = new WindowsVM(numbProc, timeout, visible);
			work.execute(platform, experiment);
		}
	}
}
