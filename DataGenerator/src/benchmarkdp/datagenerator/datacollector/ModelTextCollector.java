package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import benchmarkdp.datagenerator.generator.Text;
import benchmarkdp.datagenerator.generator.utils.Utils;

public class ModelTextCollector implements TextCollectorInterface {

	@Override
	public List<Text> collectTextELementsList(String name) {

		String filePath = Utils.modelTextPath + name + ".xml";

		File f = new File(filePath);
		List<Text> values = new ArrayList<Text>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("element");

			for (int i = 0; i < nList.getLength(); i++) {
				Element e = (Element) nList.item(i);
				Node nid = e.getElementsByTagName("ID").item(0);
				Node ntext = e.getElementsByTagName("text").item(0);
				Node nlines = e.getElementsByTagName("lines").item(0);
				String id = nid.getTextContent();
				String rwtxt = ntext.getTextContent();
				List<String> lines = getLines(nlines);
				Text tElement = new Text();
				tElement.setID(id);
				tElement.setRawText(rwtxt);
				tElement.setLines(lines);
				values.add(tElement);
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

	@Override
	public Map<String, Text> collectTextElemenentsMap(String name) {
		throw new UnsupportedOperationException();
	}

	private List<String> getLines(Node n) {
		List<String> lines = new ArrayList<String>();
		NodeList nL = n.getChildNodes();
		for (int i = 0; i < nL.getLength(); i++) {
			Node nnL = nL.item(i);
			if (nnL.getNodeName().compareTo("line") == 0) {
				lines.add(nnL.getTextContent());
			}
		}
		return lines;
	}
}
