package benchmarkdp.datagenerator.mutation;

import benchmarkdp.datagenerator.model.PSMDoc.Document;

public interface CodeGeneratorInterface {
	
	public ModelType getModelType();
	
	public void generateCode(TestModel tm);
	
}
