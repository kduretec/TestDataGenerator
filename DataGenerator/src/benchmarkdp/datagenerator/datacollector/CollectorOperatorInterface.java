package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.util.Map;

public interface CollectorOperatorInterface {

	String getName();
	
	Map<String, Object> collect(String name);
}
