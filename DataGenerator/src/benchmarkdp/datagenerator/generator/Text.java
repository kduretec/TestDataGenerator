package benchmarkdp.datagenerator.generator;

public class Text {

	
	private String ID;
	
	private String rawText; 
	
	public Text() {
		
	}
	
	public Text(String id, String rT) {
		ID = id;
		rawText = rT;
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
}
