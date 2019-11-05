package benchmarkdp.datagenerator.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.core.TestCase;

public class LinuxExecutor extends AbstractVMExecutor {

	public LinuxExecutor(int numbProc, long timeout, boolean visible) {
		super(numbProc, timeout, visible);
		log = LoggerFactory.getLogger(LinuxExecutor.class);

		dropbPathIn = "/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/"
				+ "INFSOF/experiments/ComunicationFolder/ToVM/";
		dropbPathOut = "/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/"
				+ "INFSOF/experiments/ComunicationFolder/FromVM/";

		tmpFolder = "/home/kresimir/Desktop/temp/";

	}

	@Override
	protected void initializeExecution(ExperimentProperties ep, String platform, String experiment) {

		String folderScriptXLC = "/home/kresimir/.config/libreoffice/4/user/basic";
		
		String xlcFile = folderScriptXLC + File.separator
				+ "script.xlc";
		
		String xlbFile = ep.getFullFolderPath() + ep.getMacroFolder() + File.separator + platform + File.separator
				+ "script.xlb";
		//log.info("Creating script.xlc file");
		//log.info(xlcFile);
		//log.info(xlbFile);
		saveScriptXLC(xlcFile, xlbFile);

	}

	@Override
	protected Runnable getRunnable(ExperimentProperties ep, TestCase tc, long timeout, boolean visible) {
		return new LinuxVMProc(ep, tc, timeout, visible);
	}
	
	private void saveScriptXLC(String xlcFile, String xlbFile) {

		StringBuilder sb = new StringBuilder();
		//String linuxPath = path.replaceFirst("Users", "home"); // quick hack for adapting to the linux path
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<!DOCTYPE library:libraries PUBLIC \"-//OpenOffice.org//DTD OfficeDocument 1.0//EN\" \"libraries.dtd\">\n");
		sb.append("<library:libraries xmlns:library=\"http://openoffice.org/2000/library\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n");
		sb.append("<library:library library:name=\"Standard\" xlink:href=\"$(USER)/basic/Standard/script.xlb/\" xlink:type=\"simple\" library:link=\"false\"/>\n");
		sb.append("<library:library library:name=\"Experiment\" xlink:href=\"file://"+ xlbFile +"\" xlink:type=\"simple\" library:link=\"true\" library:readonly=\"false\"/>\n");
		sb.append("</library:libraries>\n");
		
		try {
			//String file = path + "script.xlc";
			//System.out.println(path);
			File f = new File(xlcFile);
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(sb.toString());
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
