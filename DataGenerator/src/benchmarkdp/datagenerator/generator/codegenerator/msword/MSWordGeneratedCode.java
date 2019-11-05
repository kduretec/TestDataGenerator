package benchmarkdp.datagenerator.generator.codegenerator.msword;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import benchmarkdp.datagenerator.core.IGeneratedCode;

public class MSWordGeneratedCode implements IGeneratedCode {

	String generatedCode;

	String fileExtension;

	String operatingSystem;
	String software;

	public MSWordGeneratedCode(String fE, String os, String soft) {
		fileExtension = fE;
		operatingSystem = os;
		software = soft;
		generatedCode="";
	}

	public void setGeneratedCode(String code) {
		generatedCode = code;
	}

	public void addGeneratedCode(String code) {
		generatedCode += code;
	}
	
	@Override
	public void saveToFile(String filePath, String testCaseName) {
		if (generatedCode != null) {
			try {
				String platPath = filePath + "/" + getPlatform();
				File f = new File(platPath);
				if (!f.exists()) {
					f.mkdir();
				}
				
				String file = platPath + "/" + testCaseName + "." + fileExtension;
				f = new File(file);
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
		return operatingSystem + "-" + software;
	}

}
