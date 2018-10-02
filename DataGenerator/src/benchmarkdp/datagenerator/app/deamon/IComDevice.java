package benchmarkdp.datagenerator.app.deamon;

public interface IComDevice {

	public void waitForCommand(String command); 
	
	public void sendCommand(String command, String content); 
	
	public void deleteCommand(String command);
	
	public void waitForFile(String fileName); 
	
	public String readCommand(String command);
	
	public String getPlatform(); 
}
