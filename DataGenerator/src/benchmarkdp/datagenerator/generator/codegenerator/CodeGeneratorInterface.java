package benchmarkdp.datagenerator.generator.codegenerator;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;

public interface CodeGeneratorInterface {
	
	public ModelType getModelType();
	
	public void generateCode(TestCase tm);
	
}
