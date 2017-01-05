package benchmarkdp.datagenerator.generator.utils;

import java.io.File;

public class Utils {

	public static String basePath = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/";
	
	public static String docsPath = basePath + "Documents/";
	
	public static String resultsPath = basePath + "Results/";
	
	public static String groundTruthPath = basePath + "GroundTruth/";
	
	public static String modelsPath = basePath + "Models/";
	
	public static String macroPath = basePath + "Macro/"; 
	
	public static String toolOutputPath = basePath + "ToolOutput/";
	
	public static String fitsPath = basePath + "Fits/";
	
	public static String groundTruthFileEnding = "-groundtruthAll.txt";
	
	public static String groundTruthVBFileEnding = "-wordgroundtruth.txt";
	
	public static String groundTruthParagraphEnding = "-groundtruthParagraphWords.txt";
	
	public static String metadataPath = groundTruthPath + "Metadata/";
	
	public static String textPath = groundTruthPath + "Text/";
	
	public static String pimTransformation = "file://Users/kresimir/Projects/TestDataGenerator/TestDataGenerator/MutationOperators/transforms/PIM/";
	
	public static String pim2psmTransformation = "file://Users/kresimir/Projects/TestDataGenerator/TestDataGenerator/MutationOperators/transforms/PIM2PSM/";
	
	public static String psmDocTransformation = "file://Users/kresimir/Projects/TestDataGenerator/TestDataGenerator/MutationOperators/transforms/PSMDoc/";
	
	public static String psmDocxTransformation = "file://Users/kresimir/Projects/TestDataGenerator/TestDataGenerator/MutationOperators/transforms/PSMDocx/";
	
	
	
	public static String getFileName(File f) {
		int pos = f.getName().lastIndexOf(".");
		String fileName = f.getName().substring(0, pos);
		return fileName;
	}
	
}
