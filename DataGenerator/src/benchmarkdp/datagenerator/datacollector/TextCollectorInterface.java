package benchmarkdp.datagenerator.datacollector;

import java.util.List;
import java.util.Map;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.core.TestCase;
import benchmarkdp.datagenerator.core.Text;

public interface TextCollectorInterface {

	List<Text> collectTextELementsList(String name);
	
	List<Text> collectTextELementsList(ExperimentProperties ep, TestCase tc);
	
	Map<String, Text> collectTextElemenentsMap(String name);
	
	Map<String, Text> collectTextElemenentsMap(ExperimentProperties ep, TestCase tc);
}
