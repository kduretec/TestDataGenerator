package benchmarkdp.datagenerator.generator.codegenerator;

import benchmarkdp.datagenerator.testcase.TestCase;

public interface CodeGeneratorObserverInterface {

	public void notify(TestCase tm);
	public void notify(String path, String scriptName);
	public void afterGeneration();
}
