package benchmarkdp.datagenerator.generator.ocl;

import benchmarkdp.datagenerator.core.ModelType;
import benchmarkdp.datagenerator.core.TestCase;

public interface OCLEvaluatorInterface {

	public ModelType getModelType();
	
	public void evaluateTestModel(TestCase tm);
	
}
