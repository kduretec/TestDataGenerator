package benchmarkdp.datagenerator.datacollector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import benchmarkdp.datagenerator.utils.Utils;

public class GroundTruthCollector implements CollectorOperatorInterface {

	private List<String> endings;
	private List<String> prefix;
	private List<Integer> positions;

	public GroundTruthCollector() {
		endings = Arrays.asList(Utils.groundTruthFileEnding, Utils.groundTruthVBFileEnding);
		prefix = Arrays.asList("GT_", "VB_");
		positions = Arrays.asList(2,1);
	}

	@Override
	public Map<String, String> collect(File test) {
		Map<String, String> values = new HashMap<String, String>();
		String testName = Utils.getFileName(test);

		for (int i = 0; i < endings.size(); i++) {

			File fGT = new File(Utils.groundTruthPath + testName + endings.get(i));
			try {
				BufferedReader br = new BufferedReader(new FileReader(fGT));
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					String[] elem = line.split(" ");
					values.put(prefix.get(i) + elem[0], elem[positions.get(i).intValue()]);
				}
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return values;
	}

}
