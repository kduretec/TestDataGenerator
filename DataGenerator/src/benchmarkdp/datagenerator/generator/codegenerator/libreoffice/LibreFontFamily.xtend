package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.generator.codegenerator.IEnumCompiler
import benchmarkdp.datagenerator.model.PSMLibre.FontFamily
import org.eclipse.emf.common.util.Enumerator
import org.eclipse.emf.ecore.EObject

class LibreFontFamily extends AbstractElementCompiler implements IEnumCompiler{


	override compile(EObject object, CompilerState cState) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")		
	}

	
	override compile(Enumerator en, CompilerState cState) {
		
		var f = en as FontFamily
		var temp = cState.getVariable("temp") as String
		if (f == FontFamily::LIBERATIONMONO) {
			temp = temp + "\"Liberation Mono\""
		}
		if (f == FontFamily::LIBERATIONSERIF) {
			temp = temp + "\"Liberation Serif\""
		}
				
		cState.setVariable("temp", temp)
				
		
	}

}