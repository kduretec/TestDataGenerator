package benchmarkdp.datagenerator.generator;

public interface IGeneratedCode {

	public String getPlatform();
	
	public void saveToFile(String filePath, String testCaseName);

}
