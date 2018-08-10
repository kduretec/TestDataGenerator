package benchmarkdp.datagenerator.properties;

import java.io.File;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class PropertiesHandler {

	private Configurations configs; 
	
	public PropertiesHandler() {
		configs = new Configurations();
	}
	
	public ExperimentProperties loadProperties(String file) {
		ExperimentProperties prop = new ExperimentProperties();
		String s = calculateAbsoluteFolder(file);
		prop.setFullFolderPath(s);
		try {
			XMLConfiguration xmlC = configs.xml(file);
			String en = xmlC.getString("experimentName");
			prop.setExperimentName(en);
			String es = xmlC.getString("experimentState");
			prop.setExperimentState(es);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	private String calculateAbsoluteFolder(String file) {
		File f = new File(file);
		String s = f.getAbsolutePath();
		s = s.substring(0, s.lastIndexOf("/"));
		return s;
	}
}
