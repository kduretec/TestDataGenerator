package benchmarkdp.datagenerator.mutation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibreGeneratorObserver implements CodeGeneratorObserverInterface {

	List<String> names;

	public LibreGeneratorObserver() {
		names = new ArrayList<String>();
	}

	@Override
	public void notify(String name) {
		names.add(name);
	}

	@Override
	public void afterGeneration(String path) {
		try {
			String file = path + "/Ubuntu14-LibreOffice/script.xlb";
			File f = new File(file);
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(getFileContent() + "\n");
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private String getFileContent() {
		StringBuilder sb = new StringBuilder();

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<!DOCTYPE library:library PUBLIC \"-//OpenOffice.org//DTD OfficeDocument 1.0//EN\" "
				+ "\"library.dtd\"> \n");
		sb.append("<library:library xmlns:library=\"http://openoffice.org/2000/library\" "
				+ "library:name=\"Experiment\" library:readonly=\"false\" library:passwordprotected=\"false\">\n");

		for (String n : names) {
			sb.append("<library:element library:name=\"" + n + "\"/>\n");
		}

		sb.append("</library:library>");

		return sb.toString();

	}
}
