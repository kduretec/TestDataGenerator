package benchmarkdp.datagenerator.mutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.m2m.qvt.oml.TransformationExecutor;

public class MutationOperatorHolder implements MutationOperatorInterface{

	private String name;
	
	List<MutationOperator> operators;
	List<Double> percentages;
	
	public MutationOperatorHolder(String n) {
		name = n;
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
		// TODO Auto-generated method stub
		return name;
	}

}
