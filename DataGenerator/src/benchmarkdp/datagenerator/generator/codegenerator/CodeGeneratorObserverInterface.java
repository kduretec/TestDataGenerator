package benchmarkdp.datagenerator.generator.codegenerator;

import benchmarkdp.datagenerator.generator.TestModel;

public interface CodeGeneratorObserverInterface {

	public void notify(TestModel tm);
	public void afterGeneration(String path);
}
