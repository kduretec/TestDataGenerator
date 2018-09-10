package benchmarkdp.datagenerator.datacollector;

import java.util.List;
import java.util.Map;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.Text;

public interface TextCollectorInterface {

	List<Text> collectTextELementsList(String name);
	
	List<Text> collectTextELementsList(ExperimentProperties ep, TestCase tc);
	
	Map<String, Text> collectTextElemenentsMap(String name);
	
	Map<String, Text> collectTextElemenentsMap(ExperimentProperties ep, TestCase tc);
}
