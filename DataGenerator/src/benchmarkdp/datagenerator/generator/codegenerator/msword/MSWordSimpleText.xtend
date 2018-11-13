package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText
import org.eclipse.emf.ecore.EObject
import benchmarkdp.datagenerator.model.PSMDocx.TableType

class MSWordSimpleText extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		
		var t = object as SimpleText
		var temp = cState.getVariable("temp") as String 
		var inTable = cState.getVariable("inTable") as Boolean
		//temp = temp + "'oSelection.Font.Color = "
		//cState.setVariable("temp", temp)
		//compiler.compile("Color", t.color)
		//temp = cState.getVariable("temp") as String 
		//temp = temp + "\n'oSelection.Shading.BackgroundPatternColor = "
		//cState.setVariable("temp", temp)
		//compiler.compile("Color", t.background)
		temp = cState.getVariable("temp") as String
		temp = temp + "\n";
		if (inTable) {
			var tableType = cState.getVariable("tableType") as TableType
			if (tableType==TableType::SMALLNUMBERTABLE || tableType==TableType::BIGNUMBERTABLE) {
				temp = temp + '''
				oRange.Text =  " «t.value» "
			'''				
			} else {
				temp = temp + '''
				oSelection.TypeText(" «t.value» ")
			'''
			}
		} else {
			temp = temp + '''
				oSelection.Font.Size = «11»
				oSelection.TypeText(" «t.value» ")
				REM oRange.insertAfter(" «t.value» ")
			'''
		}
	
		cState.setVariable("temp", temp)
		
	}
	
}