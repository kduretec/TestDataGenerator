package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.model.PSMLibre.SimpleText
import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import org.eclipse.emf.ecore.EObject
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState

class LibreSimpleText extends AbstractElementCompiler {

	def compileSimpleText(SimpleText t) {
		var temp = '''
			oText.insertString(oText.getEnd(), " «t.value»", False)
		'''
		return temp
	}
	
	override compile(EObject object, CompilerState cState) {
		var t = object as SimpleText
		var temp = cState.getVariable("temp") as String
		temp = temp + '''
			oText.insertString(oText.getEnd(), " «t.value»", False)
		'''
		cState.setVariable("temp", temp) 
	}

}
