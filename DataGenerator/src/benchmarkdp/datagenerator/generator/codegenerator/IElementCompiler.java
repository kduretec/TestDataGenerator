package benchmarkdp.datagenerator.generator.codegenerator;

import org.eclipse.emf.ecore.EObject;

public interface IElementCompiler {

	public void compile(EObject object, CompilerState cState); 
	
	public void setModelElementsCompiler(ModelElementsCompiler mC);
}
