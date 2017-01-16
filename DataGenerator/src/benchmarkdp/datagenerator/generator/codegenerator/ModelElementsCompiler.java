package benchmarkdp.datagenerator.generator.codegenerator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;

public class ModelElementsCompiler {

	private CompilerState cState;
	
	private Map<String, IElementCompiler> compilers;
	
	public ModelElementsCompiler(CompilerState c) {
		cState = c;
		compilers = new HashMap<String, IElementCompiler>();
	}
	
	public void addCompiler(String name, IElementCompiler compiler) {
		compilers.put(name, compiler);
		compiler.setModelElementsCompiler(this);
	}
	
	public void compile(String name, EObject object) {
		IElementCompiler iec = compilers.get(name);
		iec.compile(object, cState);
	}
	
	public void compile(String name, Enumerator en) {
		IEnumCompiler iec = (IEnumCompiler) compilers.get(name);
		iec.compile(en, cState);
	}
	
}
