package benchmarkdp.datagenerator.core;

import java.util.ArrayList;
import java.util.List;

public class Text {

	
	private String ID;
	
	private String rawText; 
	
	private String elementType;
	
	private List<String> lines; 
	
	public Text() {
		lines = new ArrayList<String>(); 
		rawText = "";
	}
	
	public Text(String id, String rT) {
		ID = id;
		rawText = rT;
		lines = new ArrayList<String>();
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String id) {
		ID = id;
	}

	public String getRawText() {
		return rawText;
	}
	
	
	public void setRawText(String rT) {
		rawText = rT;
	}
	
	public void addLine(String line) {
		if (!rawText.endsWith(" ")) {
			rawText = rawText + " ";
		}
		rawText = rawText + line;
		lines.add(line);
	}
	
	public List<String> getLines() {
		return lines;
	}
	
	public void setLines(List<String> ls) {
		lines = ls;
	}
	
	public String getElementType() {
		return elementType;
	}
	
	public void setElementType(String eT) {
		elementType = eT;
	}
}
