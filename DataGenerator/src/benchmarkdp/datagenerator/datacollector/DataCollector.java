package benchmarkdp.datagenerator.datacollector;

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

import benchmarkdp.datagenerator.utils.Utils;

public class DataCollector {

	private String basePath = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/";
	private String docPath = basePath + "Documents/";

	private String path = basePath + "ToolOutput/";

	private String pathResults = basePath + "Results/";

	private String resultsFileName = "rawResults.tsv";
	
	private List<CollectorOperatorInterface> operators;

	public DataCollector() {
		operators = new ArrayList<CollectorOperatorInterface>();
		operators.add(new SizeCollector());
		operators.add(new GroundTruthCollector());
		operators.add(new TextExtractionCollector());
	}

	public static void main(String[] args) {
		DataCollector unifier = new DataCollector();
		unifier.execute();
	}

	public void execute() {

		try {
			File fResults = new File(Utils.resultsPath + resultsFileName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(fResults));
			bw.write("Name\tElement\tValue");

			File f = new File(Utils.docsPath);
			File[] documents = f.listFiles();
			boolean header = true;
			for (File dF : documents) {
				if (dF.getName().compareTo(".DS_Store") == 0)
					continue;
				String fileName = Utils.getFileName(dF);
				System.out.println("Collecting data about " + fileName);
				Map<String, String> mapDoc = new HashMap<String, String>();
				for (CollectorOperatorInterface op : operators) {
					Map<String, String> tmp = op.collect(dF);
					mapDoc.putAll(tmp);
				}

				for (Map.Entry<String, String> ent : mapDoc.entrySet()) {
					bw.write("\n" + fileName + "\t" + ent.getKey() + "\t" + ent.getValue());
				}
				mapDoc.clear();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// //if (!fileName.contains("003323_PSMDocx_docx_Win7-Office2007"))
		// continue;
		// System.out.println(fileName);
		// Map<String, String> mapDoc = new HashMap<String, String>();
		// mapDoc.put("size", Long.toString(dF.length()));
		// names.add("size");
		// Map<String, String> tmp = getGroundTruth(fileName, names);
		// mapDoc.putAll(tmp);
		//
		// tmp = getGroundTruthVB(fileName, names);
		// mapDoc.putAll(tmp);
		//
		//// tmp = getVBMetadata(fileName, names);
		//// mapDoc.putAll(tmp);
		////
		//// tmp = getNLNZResults(fileName, names);
		//// mapDoc.putAll(tmp);
		////
		//// tmp = getExifResults(fileName, names);
		//// mapDoc.putAll(tmp);
		//
		// tmp = getTika(fileName, names);
		// mapDoc.putAll(tmp);
		//
		// tmp = getUtils(fileName, names);
		// mapDoc.putAll(tmp);
		//
		//// if (header) {
		//// bw.write("Name\tElement\tValue");
		////// for (int i = 0; i < names.size(); i++) {
		////// bw.write("\t" + names.get(i));
		////// }
		//// header = false;
		//// }
		//// bw.write("\n");
		//// bw.write(fileName);
		// for (int i = 0; i < names.size(); i++) {
		// bw.write("\n" + fileName + "\t" + names.get(i) + "\t" +
		// mapDoc.get(names.get(i)));
		// }
		// mapDoc.clear();
		// names.clear();
		// }
		// bw.close();
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

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
			values.put("GTVB-pagecount", "NA");
			values.put("GTVB-paragraphcount", "NA");
			values.put("GTVB-wordcount", "NA");

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
			values.put("VBRES-pagecount", "NA");
			values.put("VBRES-paragraphcount", "NA");
			values.put("VBRES-wordcount", "NA");
			values.put("VBRES-tablecount", "NA");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	public Map<String, String> getNLNZResults(String file, List<String> names) {
		String pathNLNZ34Metadata = path + "NLNZMetadataExtractor34/metadata/";
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathNLNZ34Metadata + file + ".fits");
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);

			doc.getDocumentElement().normalize();
			String pC, wC;
			if (doc.getElementsByTagName("pageCount").getLength() == 0) {
				pC = "NA";
			} else {
				pC = doc.getElementsByTagName("pageCount").item(0).getTextContent();
			}
			if (doc.getElementsByTagName("wordCount").getLength() == 0) {
				wC = "NA";
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
			values.put("NLNZ34-pagecount", "NA");
			values.put("NLNZ34-wordcount", "NA");
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
		String pathExifResults = path + "EXIF/metadata/";
		Map<String, String> values = new HashMap<String, String>();
		File f = new File(pathExifResults + file + ".fits");
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);

			String pC, wC, parC;
			doc.getDocumentElement().normalize();
			if (doc.getElementsByTagName("pageCount").getLength() == 0) {
				pC = "NA";
			} else {
				pC = doc.getElementsByTagName("pageCount").item(0).getTextContent();
			}
			if (doc.getElementsByTagName("wordCount").getLength() == 0) {
				wC = "NA";
			} else {
				wC = doc.getElementsByTagName("wordCount").item(0).getTextContent();
			}
			if (doc.getElementsByTagName("paragraphCount").getLength() == 0) {
				parC = "NA";
			} else {
				parC = doc.getElementsByTagName("paragraphCount").item(0).getTextContent();
			}
			names.add("EXIF-pagecount");
			names.add("EXIF-wordcount");
			names.add("EXIF-paragraphcount");
			values.put("EXIF-pagecount", pC);
			values.put("EXIF-wordcount", wC);
			values.put("EXIF-paragraphcount", parC);

		} catch (FileNotFoundException e) {
			names.add("EXIF-pagecount");
			names.add("EXIF-wordcount");
			names.add("EXIF-paragraphcount");
			values.put("EXIF-pagecount", "NA");
			values.put("EXIF-wordcount", "NA");
			values.put("EXIF-paragraphcount", "NA");
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
			// getTikaMetadata(ver, f, values, names);
			f = new File(pathTikaText + file + "-wdiff.txt");
			// getTextDiff("TIKA_" + ver + "txt-diff", f, values, names);

			f = new File(pathTikaText + file + "-tika.txt");
			File fGT = new File(pathGroundTruth + file + "-groundtruthParagraphWords.txt");
			getParContrTxtBx("TIKA_" + ver + "_PARAGRAPH-present", fGT, f, values, names);

			fGT = new File(pathGroundTruth + file + "-groundtruthTextBoxWords.txt");
			getParContrTxtBx("TIKA_" + ver + "_TXTBX-present", fGT, f, values, names);

			fGT = new File(pathGroundTruth + file + "-groundtruthControlBoxWords.txt");
			getParContrTxtBx("TIKA_" + ver + "_CTBX-present", fGT, f, values, names);

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
			System.out.println(f.getName() + " not found");
			names.add("TIKA_" + version + "-pagecount");
			names.add("TIKA_" + version + "-wordcount");
			values.put("TIKA_" + version + "-pagecount", "NA");
			values.put("TIKA_" + version + "-wordcount", "NA");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map<String, String> getUtils(String file, List<String> names) {
		Map<String, String> values = new HashMap<String, String>();
		String pathGroundTruth = basePath + "GroundTruth/";
		String pathUtils = path + "TextUtil/text/";
		File f = new File(pathUtils + file + "-wdiff.txt");
		// getTextDiff("TEXTUTIL_txt-diff", f, values, names);

		f = new File(pathUtils + file + "-textutil.txt");
		File fGT = new File(pathGroundTruth + file + "-groundtruthParagraphWords.txt");
		getParContrTxtBx("TEXTUTIL_PARAGRAPH-present", fGT, f, values, names);

		fGT = new File(pathGroundTruth + file + "-groundtruthTextBoxWords.txt");
		getParContrTxtBx("TEXTUTIL_TXTBX-present", fGT, f, values, names);

		fGT = new File(pathGroundTruth + file + "-groundtruthControlBoxWords.txt");
		getParContrTxtBx("TEXTUTIL_CTBX-present", fGT, f, values, names);

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
			// if (num1 > num2) {
			// values.put(code, s2);
			// } else {
			// values.put(code, s1);
			// }
			values.put(code, s1);
		} catch (FileNotFoundException e) {
			System.out.println(f.getName() + " not exist");
			names.add(code);
			values.put(code, "NA");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			names.add(code);
			values.put(code, "NA");
		}
	}

	private void getParContrTxtBx(String code, File fGT, File f, Map<String, String> values, List<String> names) {
		if (fGT.exists()) {
			List<String> sGT = readFileToStringList(fGT);
			String tRes = readFileToString(f);
			names.add(code);
			// System.out.println("Code " + code + " Getting " + f.getName() + "
			// " + f.getPath());
			// System.out.println("Ground truth has " + sGT.size());
			// for (String s : sGT) {
			// System.out.println("box: " + s);
			// }
			if (sGT.size() == 0) {
				values.put(code, "1");
				return;
			} else if (sGT.size() > 0 && tRes == null) {
				values.put(code, "0");
				return;
			} else if (sGT.size() > 0) {
				tRes = tRes.trim();
				int count = 0;
				int pos = 0;
				for (String sg : sGT) {
					pos++;
					if (sg.indexOf(" ") == -1) {
						count++;
						continue;
					}
					sg = sg.substring(sg.indexOf(" ") + 1);
					sg = sg.trim();
					// if (tRes.contains(sg)) {
					if (checkStringInString(sg, tRes)) {
						count++;
					} else {
						System.out.println(f.getName() + " " + code + " " + pos + " wrong\n\n");
						// System.out.println(sg.substring(0, 20) + "\n " +
						// sg.substring(sg.length() - 20) + "\n");
					}
				}
				String res = new Double((double) count / sGT.size()).toString();
				values.put(code, res);
			}
		} else {
			names.add(code);
			values.put(code, "NA");
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
		String result = sb.toString().replaceAll("\\s+", " ").trim();
		result = result.replaceAll("(\\r|\\n|\\r\\n)+", " ");
		result = result.replaceAll("HYPERLINK", " ");
		result = result.replaceAll("\"http://www.google.com\"", " ");
		// result = result.replaceAll("[^A-Za-z0-9- ]", "");
		result = result.replaceAll("\\s+", " ").trim();
		return result;
	}

	private List<String> readFileToStringList(File f) {
		List<String> li = new ArrayList<String>();

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.length() > 0) {
					li.add(line.replaceAll("\\s+", " ").trim());
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			return li;
		} catch (IOException e) {
			return li;
		}
		return li;
	}

	private boolean checkStringInString(String s1, String s2) {
		boolean check = true;
		String[] splitWords = s1.split(" ");
		for (int i = 0; i < splitWords.length; i++) {
			if (!s2.contains(splitWords[i])) {
				System.out.println("does not contain " + splitWords[i]);
				check = false;
				break;
			}
		}
		return check;
	}
}
