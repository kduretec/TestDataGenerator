package benchmarkdp.datagenerator.mutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.m2m.qvt.oml.TransformationExecutor;

public class MutationOperatorHolder implements MutationOperatorInterface{

	private String name;
	private String source; 
	private String destination;
	
	List<MutationOperator> operators;
	List<Double> percentages;
	
	public MutationOperatorHolder(String n, String so, String des) {
		name = n;
		source = so;
		destination = des;
		operators = new ArrayList<MutationOperator>();
		percentages = new ArrayList<Double>();
		
	}
	
	public void addMutationOperator(MutationOperator mOp, double perc) {
		double percPer = 0;
		if (percentages.size()>0) {
			percPer = percentages.get(percentages.size()-1).doubleValue();
		}
		operators.add(mOp);
		percentages.add(new Double(percPer + perc));
		
	}
	@Override
	public TransformationExecutor getTransformationExecutor() {
		Random rnd = new Random();
		double rN = rnd.nextDouble();
		for (int i=0; i<percentages.size(); i++) {
			if (rN <= percentages.get(i).doubleValue()) {
				return operators.get(i).getTransformationExecutor();
			}
		}
		return operators.get(operators.size()-1).getTransformationExecutor();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSourceModel() {
		return source;
	}

	@Override
	public String getDestinationModel() {
		return destination;
	}

}
