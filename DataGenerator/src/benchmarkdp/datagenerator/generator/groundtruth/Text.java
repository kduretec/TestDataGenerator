package benchmarkdp.datagenerator.generator.groundtruth;

public class Text {

	
	private String ID;
	
	private String rawText; 
	
	public Text(String id, String rT) {
		ID = id;
		rawText = rT;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getRawText() {
		return rawText;
	}
}
