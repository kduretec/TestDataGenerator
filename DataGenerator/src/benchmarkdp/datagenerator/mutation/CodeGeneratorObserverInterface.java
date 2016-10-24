package benchmarkdp.datagenerator.mutation;

public interface CodeGeneratorObserverInterface {

	public void notify(String name);
	public void afterGeneration(String path);
}
