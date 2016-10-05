package benchmarkdp.datagenerator.datacollector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMeasure implements MeasureInterface {

	protected String testName;
	
	protected ToolLoaderInterface toolLoader;
	
	@Override
	public void setTestName(String name) {
		testName = name;
	}

	@Override
	public void setToolLoader(ToolLoaderInterface tL) {
		toolLoader = tL;
	}
	
	protected List<String> readFileToStringList(File f) {
		List<String> li = new ArrayList<String>();

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.length() > 0) {
					li.add(line.replaceAll("\\s+", " ").trim());
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			return li;
		} catch (IOException e) {
			return li;
		}
		return li;
	}
	
	protected boolean checkStringInString(String s1, String s2) {
		boolean check = true;
		String[] splitWords = s1.split(" ");
		for (int i = 0; i < splitWords.length; i++) {
			if (!s2.contains(splitWords[i])) {
				//System.out.println("does not contain " + splitWords[i]);
				check = false;
				break;
			}
		}
		return check;
	}
}
