package benchmarkdp.datagenerator.generator;

import java.util.HashMap;
import java.util.Map;

public class TestFeature {

	private String name;
	
	private Map<String, String> features;
	
	public TestFeature() {
		
		features = new HashMap<String,String>();
		
	}
	
	public boolean isFeatureAvailable(String feature) {
		return features.containsKey(feature);
	}
	
	public String getFeature(String feature) {
		return features.get(feature);
	}
	
	public void addFeature(String feature, String value) {
		features.put(feature, value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
