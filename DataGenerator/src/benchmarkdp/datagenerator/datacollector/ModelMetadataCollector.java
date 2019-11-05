package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import benchmarkdp.datagenerator.generator.utils.Utils;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.core.TestCase;

public class ModelMetadataCollector implements CollectorOperatorInterface {

	@Override
	public String getName() {
		return "DataGenerator";
	}

	@Override
	public Map<String, Object> collect(String name) {

		String filePath = Utils.modelMetadataPath + name + ".xml";

		Map<String, Object> values = calculateMap(filePath);

		return values;
	}

	@Override
	public Map<String, Object> collect(ExperimentProperties ep, TestCase tc) {

		String filePath = ep.getFullFolderPath() + tc.getModelMetadata();

		Map<String, Object> values = calculateMap(filePath);

		return values;
	}

	private Map<String, Object> calculateMap(String path) {

		File f = new File(path);
		Map<String, Object> values = new HashMap<String, Object>();

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);
			doc.getDocumentElement().normalize();
			NodeList val = doc.getElementsByTagName("entry");

			for (int i = 0; i < val.getLength(); i++) {
				Node n = val.item(i);
				String metName = n.getAttributes().getNamedItem("name").getNodeValue();
				String metSource = n.getAttributes().getNamedItem("source").getNodeValue();
				String metVal = n.getTextContent();
				values.put(metName + ":" + metSource, metVal);
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

		return values;
	}
}
