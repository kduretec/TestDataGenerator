package benchmarkdp.datagenerator.utils;

import java.io.File;

public class Utils {

	public static String basePath = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/";
	
	public static String docsPath = basePath + "Documents/";
	
	public static String resultsPath = basePath + "Results/";
	
	public static String groundTruthPath = basePath + "GroundTruth/"; 
	
	public static String toolOutputPath = basePath + "ToolOutput/";
	
	public static String groundTruthFileEnding = "-groundtruthAll.txt";
	
	public static String groundTruthVBFileEnding = "-wordgroundtruth.txt";
	
	public static String groundTruthParagraphEnding = "-groundtruthParagraphWords.txt";
	
	public static String getFileName(File f) {
		int pos = f.getName().lastIndexOf(".");
		String fileName = f.getName().substring(0, pos);
		return fileName;
	}
	
}
