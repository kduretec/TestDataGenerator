package benchmarkdp.datagenerator.generator.codegenerator;

import benchmarkdp.datagenerator.testcase.ModelType;
import benchmarkdp.datagenerator.testcase.TestCase;

public interface CodeGeneratorInterface {
	
	public ModelType getModelType();
	
	public void generateCode(TestCase tm);
	
	public void addCodeGeneratorObserver(CodeGeneratorObserverInterface cgo);
}
