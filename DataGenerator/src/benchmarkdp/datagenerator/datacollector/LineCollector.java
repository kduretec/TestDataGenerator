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
import benchmarkdp.datagenerator.testcase.Text;

public class LineCollector implements TextCollectorInterface {

	@Override
	public List<Text> collectTextELementsList(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, Text> collectTextElemenentsMap(String name) {
		String filePath = Utils.generatedTextPath + name + ".txt";

		File f = new File(filePath);

		Map<String, Text> values = new HashMap<String, Text>();

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
					values.put(entr[0], new Text());
				}
				values.get(entr[0]).getLines().add(entr[2]);
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
