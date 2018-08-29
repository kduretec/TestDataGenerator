package benchmarkdp.datagenerator.generator.ocl;

import benchmarkdp.datagenerator.testcase.ModelType;
import benchmarkdp.datagenerator.testcase.TestCase;

public interface OCLEvaluatorInterface {

	public ModelType getModelType();
	
	public void evaluateTestModel(TestCase tm);
	
}
