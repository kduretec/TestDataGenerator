package benchmarkdp.datagenerator.datacollector;

import java.io.File;

import benchmarkdp.datagenerator.utils.Utils;

public class TikaLoader extends AbstractToolLoader {

	private String version;

	private String suffix = "-tika.txt";

	public TikaLoader(String v) {
		version = v;
	}

	@Override 
	public String getToolCode(){
		return "Tika_" + version;
	}
	
	@Override
	public String load(String name) {

		String path = Utils.toolOutputPath + "ApacheTika" + version + "/text/" + name + suffix;
		File tikaOutput = new File(path);
		String text = readFileToString(tikaOutput);
		
		return text;
	}

}
