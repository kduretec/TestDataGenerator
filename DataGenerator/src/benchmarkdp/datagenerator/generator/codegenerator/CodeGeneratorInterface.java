package benchmarkdp.datagenerator.generator.codegenerator;

import benchmarkdp.datagenerator.core.ModelType;
import benchmarkdp.datagenerator.core.TestCase;

public interface CodeGeneratorInterface {
	
	public ModelType getModelType();
	
	public void generateCode(TestCase tm);
	
	public void addCodeGeneratorObserver(CodeGeneratorObserverInterface cgo);
}
