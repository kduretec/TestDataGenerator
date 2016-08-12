package benchmarkdp.datagenerator.mutation;

import org.eclipse.m2m.qvt.oml.TransformationExecutor;

public interface MutationOperatorInterface {

	public TransformationExecutor getTransformationExecutor();
	
	public String getName();
	
	public ModelType getSourceModel();
	
	public ModelType getDestinationModel();
}
