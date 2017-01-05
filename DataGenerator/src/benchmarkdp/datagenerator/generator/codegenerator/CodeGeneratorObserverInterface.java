package benchmarkdp.datagenerator.generator.codegenerator;

import benchmarkdp.datagenerator.generator.TestCase;

public interface CodeGeneratorObserverInterface {

	public void notify(TestCase tm);
	public void afterGeneration(String path);
}
