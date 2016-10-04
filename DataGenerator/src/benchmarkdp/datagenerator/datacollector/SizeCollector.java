package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SizeCollector implements CollectorOperatorInterface {

	@Override
	public Map<String, String> collect(File test) {
		Map<String,String> m = new HashMap<String,String>();
		m.put("size", Long.toString(test.length()));
		return m;
	}
	

}
