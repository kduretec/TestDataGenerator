package benchmarkdp.datagenerator.generator.codegenerator;

import org.eclipse.emf.common.util.Enumerator;

public interface IEnumCompiler extends IElementCompiler {

	public void compile(Enumerator en, CompilerState cState);
	
}
