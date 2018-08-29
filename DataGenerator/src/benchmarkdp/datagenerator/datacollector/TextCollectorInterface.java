package benchmarkdp.datagenerator.datacollector;

import java.util.List;
import java.util.Map;

import benchmarkdp.datagenerator.testcase.Text;

public interface TextCollectorInterface {

	List<Text> collectTextELementsList(String name);
	
	Map<String, Text> collectTextElemenentsMap(String name);
}
