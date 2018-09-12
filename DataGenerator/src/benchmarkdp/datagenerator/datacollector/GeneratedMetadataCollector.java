package benchmarkdp.datagenerator.datacollector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import benchmarkdp.datagenerator.generator.utils.Utils;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.TestFeature;

public class GeneratedMetadataCollector implements CollectorOperatorInterface {

	@Override
	public String getName() {
		return "GenerationProcess";
	}

	@Override
	public Map<String, Object> collect(String name) {

		String filePath = Utils.generatedMetadataPath + name + ".txt";

		Map<String, Object> values = calculateMap(filePath);

		return values;

	}

	@Override
	public Map<String, Object> collect(ExperimentProperties ep, TestCase tc) {

		String filePath = ep.getFullFolderPath() + tc.getGeneratedMetadata();

		Map<String, Object> values = calculateMap(filePath);

		return values;
	}

	private Map<String, Object> calculateMap(String path) {

		File f = new File(path);

		Map<String, Object> values = new HashMap<String, Object>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(f));

			while (true) {
				String line = br.readLine();
				if (line == null || line.length()==0)
					break;
				String[] entr = line.split(" ");
				values.put(entr[0] + ":GeneratedGenerator", entr[1]);
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
