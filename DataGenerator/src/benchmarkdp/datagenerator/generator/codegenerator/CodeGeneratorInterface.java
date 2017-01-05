package benchmarkdp.datagenerator.generator.codegenerator;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestModel;
import benchmarkdp.datagenerator.model.PSMDoc.Document;

public interface CodeGeneratorInterface {
	
	public ModelType getModelType();
	
	public void generateCode(TestModel tm);
	
}
