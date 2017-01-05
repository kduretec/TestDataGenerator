package benchmarkdp.datagenerator.generator.ocl;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;

public interface OCLEvaluatorInterface {

	public ModelType getModelType();
	
	public void evaluateTestModel(TestCase tm);
	
}
