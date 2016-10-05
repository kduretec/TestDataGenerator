package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import benchmarkdp.datagenerator.utils.Utils;

public class ParagraphMeasure extends AbstractMeasure {

	private String measureCode = "PARAGRAPH";

	@Override
	public Map<String, String> evaluate() {
		Map<String, String> values = new HashMap<String, String>();
		String pathGT = Utils.groundTruthPath + testName + Utils.groundTruthParagraphEnding;
		File gt = new File(pathGT);
		String code = toolLoader.getToolCode() + "_" + measureCode;
		if (gt.exists()) {
			String toolOutput = toolLoader.load(testName);
			List<String> paragraphs = readFileToStringList(gt);

			if (paragraphs.size() == 0) {
				values.put(code, "1");
			} else if (paragraphs.size() > 0 && toolOutput == null) {
				values.put(code, "0");
			} else if (paragraphs.size() > 0) {
				toolOutput = toolOutput.trim();
				int count = 0;
				int pos = 0;
				for (String sg : paragraphs) {
					pos++;
					if (sg.indexOf(" ") == -1) {
						count++;
						continue;
					}
					sg = sg.substring(sg.indexOf(" ") + 1);
					sg = sg.trim();
					if (checkStringInString(sg, toolOutput)) {
						count++;
					} else {
						System.out.println(gt.getName() + " " + code + " " + pos + " wrong\n\n");
						// System.out.println(sg.substring(0, 20) + "\n " +
						// sg.substring(sg.length() - 20) + "\n");
					}
				}
				String res = new Double((double) count / paragraphs.size()).toString();
				values.put(code, res);

			}
		}
		return values;
	}
}
