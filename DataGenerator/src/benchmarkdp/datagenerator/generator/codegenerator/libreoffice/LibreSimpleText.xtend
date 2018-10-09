package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMLibre.Text
import org.eclipse.emf.ecore.EObject

class LibreSimpleText extends AbstractElementCompiler {
	
	override compile(EObject object, CompilerState cState) {
		var t = object as Text
		var temp = cState.getVariable("temp") as String
		var inTable = cState.getVariable("inTable") as Boolean
		if (!inTable) {
			temp = temp + '''
				oText.insertString(oText.getEnd(), " «t.value»", False)
			'''			
		} else {
			temp = temp +   t.value 
		}
		cState.setVariable("temp", temp) 
	}

}
