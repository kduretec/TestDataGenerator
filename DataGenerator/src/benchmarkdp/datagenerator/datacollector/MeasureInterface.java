package benchmarkdp.datagenerator.datacollector;

import java.util.Map;

public interface MeasureInterface {

	public void setTestName(String name);
	
	public void setToolLoader(ToolLoaderInterface tL);
	
	public Map<String,String> evaluate();
}
