package benchmarkdp.datagenerator.generator.groundtruth;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestModel;

public interface OCLEvaluatorInterface {

	public ModelType getModelType();
	
	public void evaluateTestModel(TestModel tm);
	
}
