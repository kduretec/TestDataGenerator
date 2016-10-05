package benchmarkdp.datagenerator.datacollector;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import benchmarkdp.datagenerator.utils.Utils;

public class DataCollector {

	private String resultsFileName = "rawResults.tsv";
	
	private List<CollectorOperatorInterface> operators;

	public DataCollector() {
		operators = new ArrayList<CollectorOperatorInterface>();
		operators.add(new SizeCollector());
		operators.add(new GroundTruthCollector());
		operators.add(new TextExtractionCollector());
		operators.add(new FitsCollector());
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

	}	

}
