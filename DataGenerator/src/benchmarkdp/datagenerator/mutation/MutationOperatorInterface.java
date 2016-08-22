package benchmarkdp.datagenerator.mutation;

import java.util.List;

import org.eclipse.m2m.qvt.oml.TransformationExecutor;

public interface MutationOperatorInterface {

	public TransformationExecutor getTransformationExecutor();
	
	public String getName();
	
	public ModelType getSourceModel();
	
	public ModelType getDestinationModel();
	
	public List<String> getFeatures();
	
	public List<TestModel> mutateModel(TestModel tm);
}
