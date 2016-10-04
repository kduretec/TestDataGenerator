package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import benchmarkdp.datagenerator.utils.Utils;

public class TextExtractionCollector implements CollectorOperatorInterface {

	List<ToolLoaderInterface> toolLoaders;
	List<MeasureInterface> measures;
	
	public TextExtractionCollector() {
		toolLoaders.add(new TikaLoader("1_1"));
	}
	
	@Override
	public Map<String, String> collect(File test) {
		Map<String, String> values = new HashMap<String, String>();
		String testName = Utils.getFileName(test);
		
		for (MeasureInterface measure: measures) {
			measure.setTestName(testName);
		}
		for (ToolLoaderInterface tL: toolLoaders) {
			for (MeasureInterface measure: measures) {
				measure.setToolLoader(tL);
				Map<String,String> tmpMap = measure.evaluate();
				values.putAll(tmpMap);
			}
		}
		return values;
	}

	
}
