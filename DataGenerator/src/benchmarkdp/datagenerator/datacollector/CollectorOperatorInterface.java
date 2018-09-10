package benchmarkdp.datagenerator.datacollector;

import java.util.Map;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCase;

public interface CollectorOperatorInterface {

	String getName();
	
	Map<String, Object> collect(String name);
	
	Map<String, Object> collect(ExperimentProperties ep, TestCase tc);
}
