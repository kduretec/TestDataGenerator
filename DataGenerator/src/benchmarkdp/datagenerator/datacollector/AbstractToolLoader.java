package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public abstract class AbstractToolLoader implements ToolLoaderInterface {

	protected String readFileToString(File f) {
		StringBuilder sb = new StringBuilder();
		try {
			Reader r = new InputStreamReader(new FileInputStream(f), "UTF-8");
			int c = 0;
			while ((c = r.read()) != -1) {
				sb.append((char) c);
			}
			r.close();
		} catch (IOException e) {
			return null;
		}
		String result = sb.toString().replaceAll("\\s+", " ").trim();
		result = result.replaceAll("(\\r|\\n|\\r\\n)+", " ");
		result = result.replaceAll("HYPERLINK", " ");
		result = result.replaceAll("\"http://www.google.com\"", " ");
		// result = result.replaceAll("[^A-Za-z0-9- ]", "");
		result = result.replaceAll("\\s+", " ").trim();
		return result;
	}
}
