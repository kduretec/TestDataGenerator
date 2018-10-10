package benchmarkdp.datagenerator.properties;

import java.io.File;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class PropertiesHandler {

	// the most recent configuration
	FileBasedConfigurationBuilder<XMLConfiguration> builder;
	XMLConfiguration xmlC;

	public PropertiesHandler() {
	}

	public ExperimentProperties loadProperties(String file) {
		Configurations configs = new Configurations();
		ExperimentProperties prop = new ExperimentProperties();
		String s = calculateAbsoluteFolder(file);
		prop.setFullFolderPath(s);
		try {
			builder = configs.xmlBuilder(file);
			xmlC = builder.getConfiguration();
			String en = xmlC.getString("experimentName");
			prop.setExperimentName(en);
			String es = xmlC.getString("experimentState");
			prop.setExperimentState(es);
			String tcN = xmlC.getString("testCaseNumber");
			prop.setTestCaseNumber(Integer.parseInt(tcN));
			String mutationSettings = xmlC.getString("mutationPlatformSettings");
			prop.setMutationPlatformSettings(mutationSettings);
			String formatSettings = xmlC.getString("mutationFormatSettings");
			prop.setMutationPlatformSettings(formatSettings);
			
			if (es.compareTo("START") != 0) {
				prop.setDocumentFolder(xmlC.getString("folderPath.Documents"));
				prop.setResultsFolder(xmlC.getString("folderPath.Results"));
				prop.setFitsFolder(xmlC.getString("folderPath.Fits"));
				prop.setToolOutputFolder(xmlC.getString("folderPath.ToolOutput"));
				prop.setGroundTruthFolder(xmlC.getString("folderPath.GroundTruth"));
				prop.setMetadataFolder(xmlC.getString("folderPath.Metadata"));
				prop.setModelMetadataFolder(xmlC.getString("folderPath.ModelMetadata"));
				prop.setGeneratedMetadataFolder(xmlC.getString("folderPath.GeneratedMetadata"));
				prop.setTextFolder(xmlC.getString("folderPath.Text"));
				prop.setModelTextFolder(xmlC.getString("folderPath.ModelText"));
				prop.setGeneratedTextFolder(xmlC.getString("folderPath.GeneratedText"));
				prop.setModelsFolder(xmlC.getString("folderPath.Models"));
				prop.setMacroFolder(xmlC.getString("folderPath.Macro"));
			}
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}

	public void saveProperties(ExperimentProperties prop) {
		try {
			xmlC.setProperty("experimentState", prop.getExperimentState());
			if (prop.getDocumentFolder() != null) {
				xmlC.setProperty("folderPath.Documents", prop.getDocumentFolder());
				xmlC.setProperty("folderPath.Results", prop.getResultsFolder());
				xmlC.setProperty("folderPath.Fits", prop.getFitsFolder());
				xmlC.setProperty("folderPath.ToolOutput", prop.getToolOutputFolder());
				xmlC.setProperty("folderPath.GroundTruth", prop.getGroundTruthFolder());
				xmlC.setProperty("folderPath.Metadata", prop.getMetadataFolder());
				xmlC.setProperty("folderPath.ModelMetadata", prop.getModelMetadataFolder());
				xmlC.setProperty("folderPath.GeneratedMetadata", prop.getGeneratedMetadataFolder());
				xmlC.setProperty("folderPath.Text", prop.getTextFolder());
				xmlC.setProperty("folderPath.ModelText", prop.getModelTextFolder());
				xmlC.setProperty("folderPath.GeneratedText", prop.getGeneratedTextFolder());
				xmlC.setProperty("folderPath.Models", prop.getModelsFolder());
				xmlC.setProperty("folderPath.Macro", prop.getMacroFolder());
			}
			builder.save();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String calculateAbsoluteFolder(String file) {
		File f = new File(file);
		String s = f.getAbsolutePath();
		s = s.substring(0, s.lastIndexOf(File.separator)) + File.separator;
		return s;
	}
}
