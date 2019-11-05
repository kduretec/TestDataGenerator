package benchmarkdp.datagenerator.core;

import java.io.File;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TextElements {

	private List<Text> elements;

	public TextElements() {
		elements = new ArrayList<Text>();
	}

	public void addText(Text txt) {
		elements.add(txt);
	}

	public List<Text> getTextElements() {
		return elements;
	}

	public void addText(List<Text> txt) {
		elements = txt;
	}
	
	public void addText(Map<String, Text> textEl) {
		for (Text t : elements) {
			if (textEl.containsKey(t.getID())) {
				List<String> l = textEl.get(t.getID()).getLines();
				t.setLines(l);
			}
		}
	}

	public void addText(TextElements tE) {
		elements.addAll(tE.getTextElements());
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
			Element rootElement = doc.createElement("textValues");
			doc.appendChild(rootElement);
			Element d = doc.createElement("document");
			d.appendChild(doc.createTextNode(testCaseName));
			rootElement.appendChild(d);
			Element els = doc.createElement("textElements");
			rootElement.appendChild(els);
			for (Text t : elements) {
				Element tmpE = doc.createElement("element");
				Element id = doc.createElement("ID");
				id.appendChild(doc.createTextNode(t.getID()));
				Element eType = doc.createElement("ElementType");
				eType.appendChild(doc.createTextNode(t.getElementType()));
				Element txt = doc.createElement("text");
				txt.appendChild(doc.createTextNode(t.getRawText()));
				tmpE.appendChild(id);
				tmpE.appendChild(eType);
				tmpE.appendChild(txt);
				Element lines = doc.createElement("lines");
				for (int i = 0; i < t.getLines().size(); i++) {
					String l = t.getLines().get(i);
					Element line = doc.createElement("line");
					line.setAttribute("num", Integer.toString(i + 1));
					line.appendChild(doc.createTextNode(l));
					lines.appendChild(line);
				}
				tmpE.appendChild(lines);
				els.appendChild(tmpE);
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
