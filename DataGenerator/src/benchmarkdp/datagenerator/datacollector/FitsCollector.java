package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import benchmarkdp.datagenerator.generator.utils.Utils;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.core.TestCase;

public class FitsCollector implements CollectorOperatorInterface {

	private List<String> elements = Arrays.asList("size", "pageCount", "externalIdentifier");
	private String name = "Fits";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Map<String, Object> collect(String test) {

		String fitsFilePath = Utils.fitsPath + test + ".fits.xml";

		Map<String, Object> values = calculateMap(fitsFilePath);
		return values;
	}

	@Override
	public Map<String, Object> collect(ExperimentProperties ep, TestCase tc) {
		
		String fitsFilePath = ep.getFullFolderPath() + tc.getFitsFile();

		Map<String, Object> values = calculateMap(fitsFilePath);
		return values;
	}

	
	private Map<String, Object> calculateMap(String path) {
		File fits = new File(path);
		Map<String, Object> values = new HashMap<String, Object>();

		if (fits.exists()) {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			try {
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fits);
				doc.getDocumentElement().normalize();
				for (String el : elements) {
					String val;
					if (doc.getElementsByTagName(el).getLength() == 0) {
						val = "NA";
					} else {
						val = doc.getElementsByTagName(el).item(0).getTextContent();
					}
					values.put(el+":Fits", val);
				}
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return values;
	}
}
