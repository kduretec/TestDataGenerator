package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import benchmarkdp.datagenerator.generator.utils.Utils;

public class DataCollector {

	private List<CollectorOperatorInterface> operators;
	LineCollector lineCollector;

	public DataCollector() {
		operators = new ArrayList<CollectorOperatorInterface>();
		operators.add(new FitsCollector());
		operators.add(new GeneratedMetadataCollector());
		lineCollector = new LineCollector();
	}

	public static void main(String[] args) {
		DataCollector unifier = new DataCollector();
		unifier.execute();
	}

	public void execute() {

		File docs = new File(Utils.docsPath);

		String[] files = docs.list();

		for (String f : files) {
			if (f.compareTo(".DS_Store") == 0) {
				continue;
			}
			f = f.substring(0, f.lastIndexOf("."));

			Document metadata = getMetadata(f);

			// collect metadata information
			for (CollectorOperatorInterface coi : operators) {
				Map<String, String> mValues = coi.collect(f);
				String sourceName = coi.getName();
				metadata = addValues(metadata, mValues, sourceName);
			}

			storeMetadata(metadata, f);

			// collect integrity information
			Document text = getText(f);
			Map<String, List<String>> lValues = lineCollector.collect(f);
			text = addLines(text, lValues);

			storeText(text, f);

		}

	}

	private Document addValues(Document x, Map<String, String> values, String tool) {

		Node root = x.getElementsByTagName("metadataEntries").item(0);
		for (Map.Entry<String, String> ent : values.entrySet()) {
			Element tmp = x.createElement("entry");
			tmp.setAttribute("name", ent.getKey());
			tmp.setAttribute("source", tool);
			tmp.appendChild(x.createTextNode(ent.getValue()));
			root.appendChild(tmp);
		}
		return x;
	}

	private Document addLines(Document x, Map<String, List<String>> lines) {

		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		int numEl = lines.entrySet().size();
		int curEl = 0;
		for (Map.Entry<String, List<String>> entry : lines.entrySet()) {
			try {
				curEl++;
				System.out.println("Adding element " + curEl + "/" + numEl);
				String id = entry.getKey();
				List<String> l = entry.getValue();
				XPathExpression expr = xpath.compile("//element[ID='" + id + "']/lines");
				NodeList nl = (NodeList) expr.evaluate(x, XPathConstants.NODESET);
//				Node el = nl.item(0);
//				for (int i = 0; i < l.size(); i++) {
//					Element tmp = x.createElement("line");
//					tmp.setAttribute("num", Integer.toString(i + 1));
//					tmp.appendChild(x.createTextNode(l.get(i)));
//					el.appendChild(tmp);
//				}
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Node root = x.getElementsByTagName("metadataEntries").item(0);

		}
		return x;

	}

	private Document getMetadata(String file) {

		String metadataPath = Utils.modelMetadataPath + file + ".xml";
		File fileMetadata = new File(metadataPath);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fileMetadata);
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

		return doc;

	}

	private void storeMetadata(Document m, String file) {

		String metadataPath = Utils.metadataPath + file + ".xml";
		File fileMetadata = new File(metadataPath);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(m);
			StreamResult result = new StreamResult(fileMetadata);

			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Document getText(String file) {
		String textPath = Utils.modelTextPath + file + ".xml";
		File fileText = new File(textPath);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fileText);
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

		return doc;

	}

	private void storeText(Document text, String file) {
		String textPath = Utils.textPath + file + ".xml";
		File fileText = new File(textPath);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(text);
			StreamResult result = new StreamResult(fileText);

			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
