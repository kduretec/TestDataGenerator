package benchmarkdp.datagenerator.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SingleFileCode implements IGeneratedCode {

	String generatedCode;

	String fileExtension; 
	
	public SingleFileCode(String fE) {
		fileExtension = fE;
	}

	public void setGeneratedCode(String code) {
		generatedCode = code;
	}

	@Override
	public void saveToFile(String filePath, String testCaseName) {
		if (generatedCode != null) {
			try {
				String file;
				file = filePath + testCaseName + "." + fileExtension;
				File f = new File(file);
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(generatedCode + "\n");
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	@Override
	public String getPlatform() {
		// TODO Auto-generated method stub
		return null;
	}

}
