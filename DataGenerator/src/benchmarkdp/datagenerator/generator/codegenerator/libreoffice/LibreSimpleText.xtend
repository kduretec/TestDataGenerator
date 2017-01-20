package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.model.PSMLibre.SimpleText
import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import org.eclipse.emf.ecore.EObject
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState

class LibreSimpleText extends AbstractElementCompiler {
	
	override compile(EObject object, CompilerState cState) {
		var t = object as SimpleText
		var temp = cState.getVariable("temp") as String
		var inTable = cState.getVariable("inTable") as Boolean
		if (!inTable) {
			temp = temp + '''
				oText.insertString(oText.getEnd(), " «t.value»", False)
			'''			
		} else {
			temp = temp +"\"" +  t.value + "\""
		}
		cState.setVariable("temp", temp) 
	}

}
