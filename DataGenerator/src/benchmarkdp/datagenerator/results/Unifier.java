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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Unifier {

	private String basePath = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/";
	private String docPath = basePath + "Documents/";

	private String path = basePath + "ToolOutput/";

	private List<String> names;

	public Unifier() {
		names = new ArrayList<String>();
	}

	public static void main(String[] args) {
		Unifier unifier = new Unifier();
		unifier.execute();
	}

	public void execute() {

		try {
			File fResults = new File(path + "results.tsv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(fResults));

			File f = new File(docPath);
			File[] documents = f.listFiles();
			boolean header = true;
			for (File dF : documents) {
				if (dF.getName().compareTo(".DS_Store") == 0)
					continue;
				int pos = dF.getName().indexOf(".");
				String fileName = dF.getName().substring(0, pos);
				System.out.println(fileName);
				Map<String, String> mapDoc = new HashMap<String, String>();

				Map<String, String> tmp = getGroundTruth(fileName, names);
				mapDoc.putAll(tmp);

				tmp = getGroundTruthVB(fileName, names);
				mapDoc.putAll(tmp);

				tmp = getVBMetadata(fileName, names);
				mapDoc.putAll(tmp);

				tmp = getNLNZResults(fileName, names);
				mapDoc.putAll(tmp);

				tmp = getExifResults(fileName, names);
				mapDoc.putAll(tmp);

				tmp = getTika(fileName, names);
				mapDoc.putAll(tmp);

				tmp = getUtils(fileName, names);
				mapDoc.putAll(tmp);

				if (header) {
					bw.write("Name");
					for (int i = 0; i < names.size(); i++) {
						bw.write("\t" + names.get(i));
					}
					header = false;
				}
				bw.write("\n");
				bw.write(fileName);
				for (int i = 0; i < names.size(); i++) {
					bw.write("\t" + mapDoc.get(names.get(i)));
				}
				mapDoc.clear();
				names.clear();
			}
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Map<String, String> getGroundTruth(String file, List<String> names) {
		String pathGroundTruth = basePath + "GroundTruth/";
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathGroundTruth + file + "-groundtruthAll.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				String[] elem = line.split(" ");
				names.add("GT-" + elem[0]);
				values.put("GT-" + elem[0], elem[2]);
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

	public Map<String, String> getGroundTruthVB(String file, List<String> names) {
		String pathGroundTruth = basePath + "GroundTruth/";
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathGroundTruth + file + "-wordgroundtruth.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				String[] elem = line.split(" ");
				names.add("GTVB-" + elem[0]);
				values.put("GTVB-" + elem[0], elem[1]);
			}
		} catch (FileNotFoundException e) {
			names.add("GTVB-pagecount");
			names.add("GTVB-paragraphcount");
			names.add("GTVB-wordcount");
			values.put("GTVB-pagecount", "null");
			values.put("GTVB-paragraphcount", "null");
			values.put("GTVB-wordcount", "null");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public Map<String, String> getVBMetadata(String file, List<String> names) {
		String pathVBMetadata = path + "VBScript/metadata/";
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathVBMetadata + file + ".txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				String[] elem = line.split(" ");
				names.add("VBRES-" + elem[0]);
				values.put("VBRES-" + elem[0], elem[1]);
			}
		} catch (FileNotFoundException e) {
			names.add("VBRES-pagecount");
			names.add("VBRES-paragraphcount");
			names.add("VBRES-wordcount");
			names.add("VBRES-tablecount");
			values.put("VBRES-pagecount", "null");
			values.put("VBRES-paragraphcount", "null");
			values.put("VBRES-wordcount", "null");
			values.put("VBRES-tablecount", "null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public Map<String, String> getNLNZResults(String file, List<String> names) {
		String pathNLNZ34Metadata = path + "NLNZMetadataExtractor3.4/metadata/";
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathNLNZ34Metadata + file + ".fits");
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
			names.add("NLNZ34-pagecount");
			names.add("NLNZ34-wordcount");
			values.put("NLNZ34-pagecount", pC);
			values.put("NLNZ34-wordcount", wC);

		} catch (FileNotFoundException e) {
			names.add("NLNZ34-pagecount");
			names.add("NLNZ34-wordcount");
			values.put("NLNZ34-pagecount", "null");
			values.put("NLNZ34-wordcount", "null");
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

	public Map<String, String> getExifResults(String file, List<String> names) {
		String pathExifResults = path + "NLNZMetadataExtractor3.6/";
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathExifResults + file + ".fits");
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);

			doc.getDocumentElement().normalize();
			names.add("EXIF-pagecount");
			names.add("EXIF-wordcount");
			names.add("EXIF-paragraphcount");
			values.put("EXIF-pagecount", doc.getElementsByTagName("pageCount").item(0).getTextContent());
			values.put("EXIF-wordcount", doc.getElementsByTagName("wordCount").item(0).getTextContent());
			values.put("EXIF-paragraphcount", doc.getElementsByTagName("paragraphCount").item(0).getTextContent());

		} catch (FileNotFoundException e) {
			names.add("EXIF-pagecount");
			names.add("EXIF-wordcount");
			names.add("EXIF-paragraphcount");
			values.put("EXIF-pagecount", "null");
			values.put("EXIF-wordcount", "null");
			values.put("EXIF-paragraphcount", "null");
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

	public Map<String, String> getTika(String file, List<String> names) {
		List<String> tikaVer = Arrays.asList("1_1", "1_2", "1_13");
		Map<String, String> values = new HashMap<String, String>();
		String pathGroundTruth = basePath + "GroundTruth/";
		for (String ver : tikaVer) {
			String pathTika = path + "ApacheTika" + ver + "/";
			String pathTikaMetadata = pathTika + "metadata/";
			String pathTikaText = pathTika + "text/";
			File f = new File(pathTikaMetadata + file + "-metadatatika.txt");
			getTikaMetadata(ver, f, values, names);
			f = new File(pathTikaText + file + "-wdiff.txt");
			getTextDiff("TIKA_" + ver + "txt-diff", f, values, names);
			File fGT = new File(pathGroundTruth + file + "-groundtruthTextBoxWords.txt");
			f = new File(pathTikaText + file + "-tika.txt");
			getContrTxtBx("TIKA_" + ver + "_TXTBX-present", fGT, f, values, names);
			fGT = new File(pathGroundTruth + file + "-groundtruthControlBoxWords.txt");
			if (fGT.exists()) {
				getContrTxtBx("TIKA_" + ver + "_CTBX-present", fGT, f, values, names);
			} else {
				names.add("TIKA_" + ver + "CTBX-present");
				values.put("TIKA_" + ver + "CTBX-present", "NA");
			}
		}
		return values;
	}

	private void getTikaMetadata(String version, File f, Map<String, String> values, List<String> names) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				String[] elem = line.split(": ");
				if (elem[0].compareTo("Page-Count") == 0) {
					names.add("TIKA_" + version + "-pagecount");
					names.add("TIKA_" + version + "-wordcount");
					values.put("TIKA_" + version + "-pagecount", elem[1]);
				}
				if (elem[0].compareTo("Word-Count") == 0) {
					values.put("TIKA_" + version + "-wordcount", elem[1]);
				}
			}
		} catch (FileNotFoundException e) {
			names.add("TIKA_" + version + "-pagecount");
			names.add("TIKA_" + version + "-wordcount");
			values.put("TIKA_" + version + "-pagecount", "null");
			values.put("TIKA_" + version + "-wordcount", "null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map<String, String> getUtils(String file, List<String> names) {
		Map<String, String> values = new HashMap<String, String>();
		String pathGroundTruth = basePath + "GroundTruth/";
		String pathUtils = path + "TextUtil/text";
		File f = new File(pathUtils + file + "-wdiff.txt");
		getTextDiff("TEXTUTIL_txt-diff", f, values, names);

		File fGT = new File(pathGroundTruth + file + "-groundtruthTextBoxWords.txt");
		f = new File(pathUtils + file + "-textutil.txt");
		getContrTxtBx("TEXTUTIL_TXTBX-present", fGT, f, values, names);
		fGT = new File(pathGroundTruth + file + "-groundtruthControlBoxWords.txt");
		if (fGT.exists()) {
			getContrTxtBx("TEXTUTIL_CTBX-present", fGT, f, values, names);
		} else {
			names.add("TEXTUTIL_CTBX-present");
			values.put("TEXTUTIL_CTBX-present", "NA");
		}

		return values;
	}

	private void getTextDiff(String code, File f, Map<String, String> values, List<String> names) {
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
			names.add(code);
			if (num1 > num2) {
				values.put(code, s2);
			} else {
				values.put(code, s1);
			}
		} catch (FileNotFoundException e) {
			names.add(code);
			values.put(code, "null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			names.add(code);
			values.put(code, "null");
		}
	}

	private void getContrTxtBx(String code, File fGT, File f, Map<String, String> values, List<String> names) {
		List<String> sGT = readFileToStringList(fGT);
		String tRes = readFileToString(f);
		names.add(code);
		if (sGT.size() == 0 && tRes == null) {
			values.put(code, "1");
			return;
		} else if (sGT.size() > 0 && tRes == null) {
			values.put(code, "0");
			return;
		} else if (sGT.size() > 0) {
			tRes = tRes.trim();
			int count = 0;
			for (String sg : sGT) {
				sg = sg.trim();
				if (tRes.contains(sg)) {
					count++;
				}
			}
			String res = new Double((double) count / sGT.size()).toString();
			values.put(code, res);
		}
	}

	private String readFileToString(File f) {
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
		return sb.toString();
	}

	private List<String> readFileToStringList(File f) {
		List<String> li = new ArrayList<String>();

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				li.add(line);
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
