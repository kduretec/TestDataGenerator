package benchmarkdp.datagenerator.core;

public interface IGeneratedCode {

	public String getPlatform();
	
	public void saveToFile(String filePath, String testCaseName);

}
