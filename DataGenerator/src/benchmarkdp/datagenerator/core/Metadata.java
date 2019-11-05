package benchmarkdp.datagenerator.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Metadata {

	private Map<String, Object> values;

	public Metadata() {
		values = new HashMap<String, Object>();
	}

	public void add(String name, Object value) {
		values.put(name, value);
	}
	
	public void add(Map<String, Object> v) {
		values.putAll(v);
	}
	
	public Map<String, Object> getValues() {
		return values;
	}

	public void add(Metadata m) {
		for (Map.Entry<String, Object> ent : m.getValues().entrySet()) {
			values.put(ent.getKey(), ent.getValue());
		}
	}
	
	public void saveToXML(String filePath, String testCaseName) {
		File f = new File(filePath); 
		if (!f.exists()) {
			f.mkdir();
		}
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("metadata");
			doc.appendChild(rootElement);
			Element d = doc.createElement("document");
			d.appendChild(doc.createTextNode(testCaseName));
			rootElement.appendChild(d);
			Element entries = doc.createElement("metadataEntries");
			rootElement.appendChild(entries);
			for (Map.Entry<String, Object> entr : values.entrySet()) {
				Element entry = doc.createElement("entry");
				String str[] = entr.getKey().split(":");
				entry.setAttribute("name", str[0]);
				entry.setAttribute("source", str[1]);
				entry.appendChild(doc.createTextNode(entr.getValue().toString()));
				entries.appendChild(entry);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath + testCaseName + ".xml"));

			transformer.transform(source, result);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
