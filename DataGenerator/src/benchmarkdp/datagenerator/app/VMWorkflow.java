package benchmarkdp.datagenerator.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VMWorkflow {

	private static Logger log = LoggerFactory.getLogger(VMWorkflow.class);
	
	public void execute(String platform, String experiment) {
		log.info("VM workflow detected platform " + platform + " and expeirment " + experiment);
		
		if (platform.compareTo("Windows7-MSWord2007")==0) {
			WindowsVM work = new WindowsVM();
			work.execute(platform, experiment);
		}
	}
}
