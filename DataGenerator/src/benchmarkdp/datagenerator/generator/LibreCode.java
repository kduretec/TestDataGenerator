package benchmarkdp.datagenerator.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibreCode implements IGeneratedCode {

	List<String> codeElements;
	String platform;

	public LibreCode() {
		codeElements = new ArrayList<String>();
	}

	public void addCodeElement(String element) {
		codeElements.add(element);
	}

	public void setPlatform(String plat) {
		platform = plat;
	}

	@Override
	public String getPlatform() {
		return platform;
	}

	@Override
	public void saveToFile(String filePath, String testCaseName) {
		String fileMain = getFileStart(testCaseName);
		fileMain = fileMain + codeElements.get(0);
		
		for (int i=2; i<codeElements.size(); i++) {
			String scriptName = testCaseName + "_part_" + (i-1);
			fileMain = fileMain + scriptName + "(oDoc, oText)\n";
			String tempFile = getFileStart(scriptName);
			tempFile = tempFile + "Sub " + scriptName + "(oDoc, oText)\n";
			tempFile = tempFile + codeElements.get(i);
			tempFile = tempFile + "End Sub\n";
			tempFile = tempFile + getFileEnd();
			File fT = new File(filePath + scriptName + ".xba");
			save(fT, tempFile);
		}
		
		fileMain = fileMain + getFileEnd();
		File fM = new File(filePath + testCaseName + ".xba");
		save(fM, fileMain);
	}

	private String getFileStart(String scriptName) {
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n "
				+ "<!DOCTYPE library:libraries PUBLIC \"-//OpenOffice.org//DTD OfficeDocument 1.0//EN\" \"module.dtd\">\n"
				+ "<script:module xmlns:script=\"http://openoffice.org/2000/script\" script:name=" + scriptName
				+ " script:language=\"StarBasic\">\n\n";
		return str;
	}

	private String getFileEnd() {
		String str = "</script:module>";
		return str;
	}

	private void save(File f, String code) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(code + "\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
