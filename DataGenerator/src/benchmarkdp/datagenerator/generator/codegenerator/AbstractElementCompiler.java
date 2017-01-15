package benchmarkdp.datagenerator.generator.codegenerator;

public abstract class AbstractElementCompiler implements IElementCompiler {

	protected ModelElementsCompiler compiler; 
	
	public void setModelElementsCompiler(ModelElementsCompiler mC) {
		compiler = mC;
	}
}
