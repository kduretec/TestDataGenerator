package benchmarkdp.datagenerator.generator.codegenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import benchmarkdp.datagenerator.generator.TestCase;

public class LibreGeneratorObserver implements CodeGeneratorObserverInterface {

	Map<String, List<String>> names;

	public LibreGeneratorObserver() {
		names = new HashMap<String, List<String>>();
	}

	@Override
	public void notify(TestCase tC) {
	//	String platform = tC getPlatform();
	//	if (!names.containsKey(platform)) {
	//		names.put(platform, new ArrayList<String>());
	//	}
		
	//	names.get(platform).add(tC.getTestFeature().getName());
	}

	@Override
	public void afterGeneration(String path) {
		
		for (Map.Entry<String, List<String>> mE : names.entrySet()) {
			String platform = mE.getKey();
			try {
				String file = path + "/" + platform + "/script.xlb";
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
}
