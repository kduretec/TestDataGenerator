package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface;
import benchmarkdp.datagenerator.core.TestCase;

public class LibreGeneratorObserver implements CodeGeneratorObserverInterface {

	Map<String, List<String>> names;

	public LibreGeneratorObserver() {
		names = new HashMap<String, List<String>>();
	}

	@Override
	public synchronized void notify(TestCase tC) {
		// String platform = tC getPlatform();
		// if (!names.containsKey(platform)) {
		// names.put(platform, new ArrayList<String>());
		// }

		// names.get(platform).add(tC.getTestFeature().getName());
	}

	@Override
	public synchronized void notify(String path, String scriptName) {
		//System.out.println("PATH = " + path + " SCRIPTNAME= " + scriptName) ;
		if (!names.containsKey(path)) {
			//System.out.println("PATH-CONTAINS = " + path);
			names.put(path, new ArrayList<String>());
		}
		names.get(path).add(scriptName);
	}

	@Override
	public void afterGeneration() {
		for (Map.Entry<String, List<String>> mE : names.entrySet()) {
			String path = mE.getKey();
			try {
				String file = path + "script.xlb";
				//saveScriptXLC(path, "script.xlb");
				//System.out.println(path);
				File f = new File(file);
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(getFileContent(mE.getValue()) + "\n");
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	private String getFileContent(List<String> nam) {
		StringBuilder sb = new StringBuilder();

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<!DOCTYPE library:library PUBLIC \"-//OpenOffice.org//DTD OfficeDocument 1.0//EN\" "
				+ "\"library.dtd\"> \n");
		sb.append("<library:library xmlns:library=\"http://openoffice.org/2000/library\" "
				+ "library:name=\"Experiment\" library:readonly=\"false\" library:passwordprotected=\"false\">\n");

		for (String n : nam) {
			sb.append("<library:element library:name=\"" + n + "\"/>\n");
		}

		sb.append("</library:library>");

		return sb.toString();

	}

	private void saveScriptXLC(String path, String fileName) {

		StringBuilder sb = new StringBuilder();
		String linuxPath = path.replaceFirst("Users", "home"); // quick hack for adapting to the linux path
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<!DOCTYPE library:libraries PUBLIC \"-//OpenOffice.org//DTD OfficeDocument 1.0//EN\" \"libraries.dtd\">\n");
		sb.append("<library:libraries xmlns:library=\"http://openoffice.org/2000/library\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n");
		sb.append("<library:library library:name=\"Standard\" xlink:href=\"$(USER)/basic/Standard/script.xlb/\" xlink:type=\"simple\" library:link=\"false\"/>\n");
		sb.append("<library:library library:name=\"Experiment\" xlink:href=\"file://"+ linuxPath + fileName +"\" xlink:type=\"simple\" library:link=\"true\" library:readonly=\"false\"/>\n");
		sb.append("</library:libraries>\n");
		
		try {
			String file = path + "script.xlc";
			System.out.println(path);
			File f = new File(file);
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(sb.toString());
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
