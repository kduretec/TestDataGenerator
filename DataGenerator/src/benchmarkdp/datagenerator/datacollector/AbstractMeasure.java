package benchmarkdp.datagenerator.datacollector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMeasure {

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
}
