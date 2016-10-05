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

import benchmarkdp.datagenerator.utils.Utils;

public class FitsCollector implements CollectorOperatorInterface {

	private List<String> elements = Arrays.asList("size");
	private String code = "FITS";

	@Override
	public Map<String, String> collect(File test) {

		String testName = Utils.getFileName(test);
		String path = Utils.fitsPath + testName + ".fits.xml";
		File fits = new File(path);

		Map<String, String> values = new HashMap<String, String>();

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
				values.put(code + "_" + el, val);
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
