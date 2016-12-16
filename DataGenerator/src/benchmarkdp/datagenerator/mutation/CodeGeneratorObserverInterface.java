package benchmarkdp.datagenerator.mutation;

public interface CodeGeneratorObserverInterface {

	public void notify(TestModel tm);
	public void afterGeneration(String path);
}
