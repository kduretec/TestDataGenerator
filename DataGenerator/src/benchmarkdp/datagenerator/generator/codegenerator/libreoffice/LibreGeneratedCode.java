package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface;
import benchmarkdp.datagenerator.testcase.IGeneratedCode;

public class LibreGeneratedCode implements IGeneratedCode {

	List<String> codeElements;
	List<String> helperFunctions;

	String operatingSystem;
	String software;
	CodeGeneratorObserverInterface cObserver;

	public LibreGeneratedCode(CodeGeneratorObserverInterface cI) {
		codeElements = new ArrayList<String>();
		helperFunctions = new ArrayList<String>();
		cObserver = cI;
	}

	public void addCodeElement(String element) {
		codeElements.add(element);
	}

	public void setOperatingSystem(String os) {
		operatingSystem = os;
	}

	public void setSoftware(String soft) {
		software = soft;
	}

	@Override
	public String getPlatform() {
		return operatingSystem + "-" + software;
	}

	public void addHelperFunction(String function) {
		helperFunctions.add(function);
	}

	@Override
	public void saveToFile(String filePath, String testCaseName) {

		String platPath = filePath + getPlatform() + "/";
		File f = new File(platPath);
		if (!f.exists()) {
			f.mkdir();
		}

		String fileMain = getFileStart("main_" + testCaseName);
		fileMain = fileMain + codeElements.get(0);

		for (int i = 2; i < codeElements.size(); i++) {
			String scriptName = "sub_" + testCaseName + "_part_" + (i - 1);
			fileMain = fileMain + "oTables = ThisComponent.TextTables \n" + "If (oTables.getCount() > 0) Then \n"
					+ "oTable = oTables(oTables.getCount() - 1) \nEnd If \n" + "fun_" + scriptName
					+ "(oDoc, oText, oTable, file)\n";
			String tempFile = getFileStart(scriptName);
			tempFile = tempFile + "Sub " + "fun_" + scriptName + "(oDoc, oText, oTable, file)\n";
			tempFile = tempFile + codeElements.get(i);
			tempFile = tempFile + "End Sub\n";
			tempFile = tempFile + getFileEnd();
			save(tempFile, platPath, scriptName);
		}
		fileMain = fileMain + codeElements.get(1);
		fileMain = fileMain + getFileEnd();
		save(fileMain, platPath, "main_" + testCaseName);

		String helpersName = "helpers";
		String fileHelper = getFileStart(helpersName);
		for (int i = 0; i < helperFunctions.size(); i++) {
			fileHelper = fileHelper + helperFunctions.get(i);
		}
		fileHelper = fileHelper + getFileEnd();
		save(fileHelper, platPath, helpersName);
	}

	private String getFileStart(String scriptName) {
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n "
				+ "<!DOCTYPE library:libraries PUBLIC \"-//OpenOffice.org//DTD OfficeDocument 1.0//EN\" \"module.dtd\">\n"
				+ "<script:module xmlns:script=\"http://openoffice.org/2000/script\" script:name=\"" + scriptName
				+ "\" script:language=\"StarBasic\">\n\n";
		return str;
	}

	private String getFileEnd() {
		String str = "</script:module>";
		return str;
	}

	private void save(String code, String path, String scriptName) {
		File f = new File(path + scriptName + ".xba");
		if (!f.exists()) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(code + "\n");
				bw.close();
				cObserver.notify(path, scriptName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
