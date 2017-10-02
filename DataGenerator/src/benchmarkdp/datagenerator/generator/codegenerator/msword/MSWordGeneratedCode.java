package benchmarkdp.datagenerator.generator.codegenerator.msword;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import benchmarkdp.datagenerator.generator.IGeneratedCode;

public class MSWordGeneratedCode implements IGeneratedCode {

	String generatedCode;

	String fileExtension;

	String platform;

	public MSWordGeneratedCode(String fE, String plat) {
		fileExtension = fE;
		platform = plat;
	}

	public void setGeneratedCode(String code) {
		generatedCode = code;
	}

	@Override
	public void saveToFile(String filePath, String testCaseName) {
		if (generatedCode != null) {
			try {
				String platPath = filePath + "/" + platform;
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
		// TODO Auto-generated method stub
		return null;
	}

}
