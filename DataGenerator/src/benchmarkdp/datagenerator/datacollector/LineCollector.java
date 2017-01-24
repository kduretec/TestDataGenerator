package benchmarkdp.datagenerator.datacollector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import benchmarkdp.datagenerator.generator.utils.Utils;

public class LineCollector {

	public Map<String, List<String>> collect(String name) {

		String filePath = Utils.generatedTextPath + name + ".txt";

		File f = new File(filePath);

		Map<String, List<String>> values = new HashMap<String, List<String>>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(f));

			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				if (line.length() == 0)
					continue;
				String[] entr = line.split(":");
				if (entr.length < 3) 
					continue;
				if (!values.containsKey(entr[0])) {
					values.put(entr[0], new ArrayList<String>());
				}
				values.get(entr[0]).add(entr[2]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return values;
	}
}
