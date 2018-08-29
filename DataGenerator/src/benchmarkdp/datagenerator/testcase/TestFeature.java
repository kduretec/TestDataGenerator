package benchmarkdp.datagenerator.testcase;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class TestFeature {

	private String name = null;
	
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
	
	@XmlElement(name="feature")
	public Map<String, String> getFeatures() {
		return features;
	}
	
	public void addFeature(String feature, String value) {
		features.put(feature, value);
	}

	public String getName() {
		return name;
	}

	@XmlTransient
	public void setName(String name) {
		this.name = name;
	}
	
	
}
