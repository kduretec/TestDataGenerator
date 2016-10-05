package benchmarkdp.datagenerator.datacollector;

import java.io.File;

import benchmarkdp.datagenerator.utils.Utils;

public class TikaLoader extends AbstractToolLoader {

	private String version;

	private String suffix = "-tika.txt";

	private String testName;

	private String text;

	public TikaLoader(String v) {
		version = v;
		testName = null;
		text = null;
	}

	@Override
	public String getToolCode() {
		return "Tika_" + version;
	}

	@Override
	public String load(String name) {
		if (testName==null) {
			testName=name;
		}
		if (name.compareTo(testName) != 0) {
			String path = Utils.toolOutputPath + "ApacheTika" + version + "/text/" + name + suffix;
			File tikaOutput = new File(path);
			text = readFileToString(tikaOutput);
			testName = name;
		}
		return text;
	}

}
