package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink
import org.eclipse.emf.ecore.EObject

class MSWordHyperLink extends AbstractElementCompiler {
	
	override compile(EObject object, CompilerState cState) {
		
		var h = object as HyperLink
		var temp = cState.getVariable("temp") as String 
		temp = temp + "\n";
		temp = temp + '''
			Set oRange = oSelection.Range
			oDoc.Hyperlinks.Add oRange, "«h.url»", , , " «h.value»"
		'''
		cState.setVariable("temp", temp)
		
	}
	
}