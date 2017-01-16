package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import benchmarkdp.datagenerator.generator.IGeneratedCode;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface;

public class LibreGeneratedCode implements IGeneratedCode {

	List<String> codeElements;
	List<String> helperFunctions;

	String platform;
	CodeGeneratorObserverInterface cObserver;

	public LibreGeneratedCode(CodeGeneratorObserverInterface cI) {
		codeElements = new ArrayList<String>();
		helperFunctions = new ArrayList<String>();
		cObserver = cI;
	}

	public void addCodeElement(String element) {
		codeElements.add(element);
		System.out.println("Adding code elements");
	}

	public void setPlatform(String plat) {
		platform = plat;
	}

	@Override
	public String getPlatform() {
		return platform;
	}

	public void addHelperFunction(String function) {
		helperFunctions.add(function);
	}

	@Override
	public void saveToFile(String filePath, String testCaseName) {
		String path = filePath + platform + "/";
		String fileMain = getFileStart("main_" + testCaseName);
		fileMain = fileMain + codeElements.get(0);

		for (int i = 2; i < codeElements.size(); i++) {
			String scriptName = "sub_" + testCaseName + "_part_" + (i - 1);
			fileMain = fileMain + "fun_" + scriptName + "(oDoc, oText, file)\n";
			String tempFile = getFileStart(scriptName);
			tempFile = tempFile + "Sub " + "fun_" + scriptName + "(oDoc, oText, file)\n";
			tempFile = tempFile + codeElements.get(i);
			tempFile = tempFile + "End Sub\n";
			tempFile = tempFile + getFileEnd();
			save(tempFile, path, scriptName);
		}
		fileMain = fileMain + codeElements.get(1);
		fileMain = fileMain + getFileEnd();
		save(fileMain, path, "main_" + testCaseName);

		String helpersName = "helpers";
		String fileHelper = getFileStart(helpersName);
		for (int i = 0; i < helperFunctions.size(); i++) {
			fileHelper = fileHelper + helperFunctions.get(i);
		}
		fileHelper = fileHelper + getFileEnd();
		save(fileHelper, path, helpersName);
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