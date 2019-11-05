package benchmarkdp.datagenerator.generator.mutation;

import org.eclipse.m2m.qvt.oml.TransformationExecutor;

import benchmarkdp.datagenerator.core.ModelType;
import benchmarkdp.datagenerator.core.TestCase;

public interface MutationOperatorInterface {

	public TransformationExecutor getTransformationExecutor();
	
	public String getName();
	
	public ModelType getSourceModel();
	
	public ModelType getDestinationModel();
	
	//public List<String> getFeatures();
	
	//public List<TestCase> mutateTestCase(TestCase tm);
	
	public void mutateTestCase(TestCase tm);
}
