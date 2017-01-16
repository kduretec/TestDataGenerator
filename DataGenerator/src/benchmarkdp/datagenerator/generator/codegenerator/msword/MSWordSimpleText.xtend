package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText
import org.eclipse.emf.ecore.EObject

class MSWordSimpleText extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		
		var t = object as SimpleText
		var temp = cState.getVariable("temp") as String 
		
		temp = temp + "oSelection.Font.Color = "
		cState.setVariable("temp", temp)
		compiler.compile("Color", t.color)
		temp = cState.getVariable("temp") as String 
		temp = temp + "\noSelection.Shading.BackgroundPatternColor = "
		cState.setVariable("temp", temp)
		compiler.compile("Color", t.background)
		temp = cState.getVariable("temp") as String
		temp = temp + "\n";
		temp = temp + '''
			oSelection.Font.Size = «t.size»
			oSelection.TypeText(" «t.value» ")
		'''
	
		cState.setVariable("temp", temp)
		
	}
	
}