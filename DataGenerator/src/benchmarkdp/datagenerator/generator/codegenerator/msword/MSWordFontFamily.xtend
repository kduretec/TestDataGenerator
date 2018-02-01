package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.generator.codegenerator.IEnumCompiler
import benchmarkdp.datagenerator.model.PSMDocx.FontFamily
import org.eclipse.emf.common.util.Enumerator
import org.eclipse.emf.ecore.EObject

class MSWordFontFamily extends AbstractElementCompiler implements IEnumCompiler {
	
	override compile(Enumerator en, CompilerState cState) {
		
		var f = en as FontFamily
		var temp = cState.getVariable("temp") as String
		if (f == FontFamily::TIMESNEWROMAN) {
			temp = temp + "Times New Roman"
		}
		if (f == FontFamily::ARIAL) {
			temp = temp + "Arial"
		}
		
		cState.setVariable("temp", temp)
		
	}
	
	override compile(EObject object, CompilerState cState) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}