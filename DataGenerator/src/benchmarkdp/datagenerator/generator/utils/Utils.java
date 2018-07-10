package benchmarkdp.datagenerator.generator.utils;

import java.io.File;

public class Utils {

	public static String experimentName = "ExperimentNewTest";
	public static String basePath = "/Users/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/INFSOF/experiments/Generated/"
			+ experimentName + "/";

	public static String windowsBasePath = "c:\\Users\\Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\publications\\INFSOF\\experiments\\Generated\\"
			+ experimentName + "\\";

	public static String windowsDocPath = windowsBasePath + "Documents\\";

	public static String windowsGroundTruthPath = windowsBasePath + "GroundTruth\\";

	public static String windowsGeneratedMetadataPath = windowsGroundTruthPath + "GeneratedMetadata\\";

	public static String windowsGeneratedTextPath = windowsGroundTruthPath + "GeneratedText\\";

	public static String linuxBasePath = "/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/INFSOF/experiments/Generated/"
			+ experimentName + "/";
	
	public static String linuxDocsPath = linuxBasePath + "Documents/";
	
	public static String linuxGroundTruthPath = linuxBasePath + "GroundTruth/";
	
	public static String linuxGeneratedMetadataPath = linuxGroundTruthPath + "GeneratedMetadata/";
	
	public static String linuxGeneratedTextPath = linuxGroundTruthPath + "GeneratedText/";

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

	public static String modelMetadataPath = groundTruthPath + "ModelMetadata/";

	public static String generatedMetadataPath = groundTruthPath + "GeneratedMetadata/";

	public static String textPath = groundTruthPath + "Text/";

	public static String modelTextPath = groundTruthPath + "ModelText/";

	public static String generatedTextPath = groundTruthPath + "GeneratedText/";

	public static String pimTransformation = "file://Users/kresimir/Projects/TestDataGenerator/TestDataGenerator/MutationOperators/transforms/PIM/";

	public static String pim2psmTransformation = "file://Users/kresimir/Projects/TestDataGenerator/TestDataGenerator/MutationOperators/transforms/PIM2PSM/";

	public static String psmDocxTransformation = "file://Users/kresimir/Projects/TestDataGenerator/TestDataGenerator/MutationOperators/transforms/PSMDocx/";

	public static String psmLibreTransformation = "file://Users/kresimir/Projects/TestDataGenerator/TestDataGenerator/MutationOperators/transforms/PSMLibre/";

	public static String getFileName(File f) {
		int pos = f.getName().lastIndexOf(".");
		String fileName = f.getName().substring(0, pos);
		return fileName;
	}

	public static void initializeFolderStructure() {

		File bDir = new File(basePath);
		if (bDir.exists()) {
			deleteDirectory(bDir);
		}
		bDir.mkdir();
		File f = new File(docsPath);
		f.mkdir();
		f = new File(resultsPath);
		f.mkdir();
		f = new File(fitsPath);
		f.mkdir();
		f = new File(toolOutputPath);
		f.mkdir();
		f = new File(groundTruthPath);
		f.mkdir();
		f = new File(metadataPath);
		f.mkdir();
		f = new File(modelMetadataPath);
		f.mkdir();
		f = new File(generatedMetadataPath);
		f.mkdir();
		f = new File(textPath);
		f.mkdir();
		f = new File(modelTextPath);
		f.mkdir();
		f = new File(generatedTextPath);
		f.mkdir();
		f = new File(modelsPath);
		f.mkdir();
		f = new File(macroPath);
		f.mkdir();
	}

	private static void deleteDirectory(File d) {
		File[] files = d.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				deleteDirectory(f);
			}
			f.delete();
		}
	}
}
