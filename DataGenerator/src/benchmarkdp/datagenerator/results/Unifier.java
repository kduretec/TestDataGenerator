package benchmarkdp.datagenerator.results;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Unifier {

	private String path = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/ToolOutput/";

	private String pathGroundTruth = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/GroundTruth/";

	private String pathVBResults = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/ToolOutput/VBScript/";

	private String pathNLNZResults = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/ToolOutput/NLNZMetadataExtractor3.4/";

	private String pathExifResults = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/ToolOutput/NLNZMetadataExtractor3.6/";

	private String pathTikaResults = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/ToolOutput/ApacheTika/";

	private String pathTextUtilsResults = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/ToolOutput/TextUtil/";

	private int num = 40;

	public static void main(String[] args) {
		Unifier unifier = new Unifier();
		unifier.execute();
	}

	public void execute() {
		try {
			File f = new File(path + "results.tsv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));

			bw.write(
					"DocumentName\tGT-FORMAT\tGT-COLUMNS\tGT-PC\tGT-PARC\tGT-TC\tGT-WC\tGTVB-PC\tGTVB-PARC\tGTVB-WC\tVB-PC\tVB-PARC\tVB-WC\tVB-TC\tNLNZ-PC\tNLNZ-WC\tEXIF-PC\tEXIF-PARC\tEXIF-WC\tTIKA-PC\tTIKA-WC\t"
							+ "TIKA-TXT\tTEXTUTILS-DIFF\tTIKA-TXTBX\tTEXTUTILS-TXTBX\t" + "\n");

			for (int i = 0; i < num; i++) {
				bw.write("Document" + i + "\t");
				Map<String, String> m = getGroundTruth(i);
				bw.write(m.get("format") + "\t");
				bw.write(m.get("columns") + "\t");
				bw.write(m.get("pagecount") + "\t");
				bw.write(m.get("paragraphcount") + "\t");
				bw.write(m.get("tablecount") + "\t");
				bw.write(m.get("wordcount") + "\t");

				m = getGroundTruthVB(i);
				bw.write(m.get("pagecount") + "\t");
				bw.write(m.get("paragraphcount") + "\t");
				bw.write(m.get("wordcount") + "\t");

				m = getVBResults(i);
				bw.write(m.get("pagecount") + "\t");
				bw.write(m.get("paragraphcount") + "\t");
				bw.write(m.get("wordcount") + "\t");
				bw.write(m.get("tablecount") + "\t");

				m = getNLNZResults(i);
				bw.write(m.get("pagecount") + "\t");
				bw.write(m.get("wordcount") + "\t");

				m = getExifResults(i);
				bw.write(m.get("pagecount") + "\t");
				bw.write(m.get("paragraphcount") + "\t");
				bw.write(m.get("wordcount") + "\t");

				m = getTikaMetadata(i);
				bw.write(m.get("pagecount") + "\t");
				bw.write(m.get("wordcount") + "\t");

				m = getTikaDiff(i);
				bw.write(m.get("diff") + "\t");

				m = getUtilsDiff(i);
				bw.write(m.get("diff") + "\t");

				m = getTikaTxtBx(i);
				bw.write(m.get("present") + "\t");
				m = getTextUtilsTxtBx(i);
				bw.write(m.get("present") + "\t");

				bw.write("\n");
			}
			System.out.println("Done");
			bw.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public Map<String, String> getGroundTruth(int ind) {
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathGroundTruth + "Document" + ind + "-groundtruth.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				String[] elem = line.split(" ");
				values.put(elem[0], elem[2]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public Map<String, String> getGroundTruthVB(int ind) {
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathGroundTruth + "Document" + ind + "-wordgroundtruth.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				String[] elem = line.split(" ");
				values.put(elem[0], elem[1]);
			}
		} catch (FileNotFoundException e) {
			values.put("pagecount", "null");
			values.put("paragraphcount", "null");
			values.put("wordcount", "null");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public Map<String, String> getVBResults(int ind) {
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathVBResults + "Document" + ind + ".txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				String[] elem = line.split(" ");
				values.put(elem[0], elem[1]);
			}
		} catch (FileNotFoundException e) {
			values.put("pagecount", "null");
			values.put("paragraphcount", "null");
			values.put("wordcount", "null");
			values.put("tablecount", "null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public Map<String, String> getNLNZResults(int ind) {
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathNLNZResults + "Document" + ind + ".fits");
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);

			doc.getDocumentElement().normalize();
			String pC, wC;
			if (doc.getElementsByTagName("pageCount").getLength() == 0) {
				pC = null;
			} else {
				pC = doc.getElementsByTagName("pageCount").item(0).getTextContent();
			}
			if (doc.getElementsByTagName("wordCount").getLength() == 0) {
				wC = null;
			} else {
				wC = doc.getElementsByTagName("wordCount").item(0).getTextContent();
			}
			values.put("pagecount", pC);
			values.put("wordcount", wC);

		} catch (FileNotFoundException e) {
			values.put("pagecount", "null");
			values.put("wordcount", "null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public Map<String, String> getExifResults(int ind) {
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathExifResults + "Document" + ind + ".fits");
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);

			doc.getDocumentElement().normalize();

			values.put("pagecount", doc.getElementsByTagName("pageCount").item(0).getTextContent());
			values.put("wordcount", doc.getElementsByTagName("wordCount").item(0).getTextContent());
			values.put("paragraphcount", doc.getElementsByTagName("paragraphCount").item(0).getTextContent());

		} catch (FileNotFoundException e) {
			values.put("pagecount", "null");
			values.put("wordcount", "null");
			values.put("paragraphcount", "null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public Map<String, String> getTikaMetadata(int ind) {
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathTikaResults + "Document" + ind + "-metadatatika.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				String[] elem = line.split(": ");
				if (elem[0].compareTo("Page-Count") == 0) {
					values.put("pagecount", elem[1]);
				}
				if (elem[0].compareTo("Word-Count") == 0) {
					values.put("wordcount", elem[1]);
				}
			}
		} catch (FileNotFoundException e) {
			values.put("pagecount", "null");
			values.put("wordcount", "null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public Map<String, String> getTikaDiff(int ind) {
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathTikaResults + "Document" + ind + "-wdiff.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line1, line2;
			line1 = br.readLine();
			line2 = br.readLine();
			String[] elem1 = line1.split(" ");
			String[] elem2 = line2.split(" ");

			String s1 = elem1[5];
			s1 = s1.substring(0, s1.length() - 1);
			int num1 = Integer.parseInt(s1);
			String s2 = elem2[5];
			s2 = s2.substring(0, s2.length() - 1);
			int num2 = Integer.parseInt(s2);

			if (num1 > num2) {
				values.put("diff", s2);
			} else {
				values.put("diff", s1);
			}
		} catch (FileNotFoundException e) {
			values.put("diff", "null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			values.put("diff", "null");
		}
		return values;
	}

	public Map<String, String> getUtilsDiff(int ind) {
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathTextUtilsResults + "Document" + ind + "-wdiff.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line1, line2;
			line1 = br.readLine();
			line2 = br.readLine();
			String[] elem1 = line1.split(" ");
			String[] elem2 = line2.split(" ");

			String s1 = elem1[5];
			s1 = s1.substring(0, s1.length() - 1);
			int num1 = Integer.parseInt(s1);
			String s2 = elem2[5];
			s2 = s2.substring(0, s2.length() - 1);
			int num2 = Integer.parseInt(s2);

			if (num1 > num2) {
				values.put("diff", s2);
			} else {
				values.put("diff", s1);
			}
		} catch (FileNotFoundException e) {
			values.put("diff", "null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			values.put("diff", "null");
		}
		return values;
	}

	public Map<String, String> getTikaTxtBx(int ind) {
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathGroundTruth + "Document" + ind + "-groundtruthTextBoxWords.txt");
		File fTika = new File(pathTikaResults + "Document" + ind + "-tika.txt");
		String sGT = readFileToString(f);
		String tRes = readFileToString(fTika);

		if (sGT == null || tRes == null) {
			values.put("present", "0");
			return values;
		}

		sGT = sGT.trim();
		tRes = tRes.trim();
		
		if (tRes.contains(sGT)) {
			values.put("present", "1");
		} else {
			values.put("present", "0");
		}

		return values;
	}

	public Map<String, String> getTextUtilsTxtBx(int ind) {
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathGroundTruth + "Document" + ind + "-groundtruthTextBoxWords.txt");
		File fTika = new File(pathTextUtilsResults + "Document" + ind + "-textutil.txt");
		String sGT = readFileToString(f);
		String tRes = readFileToString(fTika);

		if (sGT == null || tRes == null) {
			values.put("present", "0");
			return values;
		}

		sGT = sGT.trim();
		tRes = tRes.trim();
		
		if (tRes.contains(sGT)) {
			values.put("present", "1");
		} else {
			values.put("present", "0");
		}

		return values;
	}

	private String readFileToString(File f) {
		StringBuilder sb = new StringBuilder();
		try {
			Reader r = new InputStreamReader(new FileInputStream(f), "UTF-8");
			int c = 0;
			while ((c = r.read()) != -1) {
				sb.append((char) c);
			}
		} catch (IOException e) {
			return null;
		}
		return sb.toString();
	}
}
