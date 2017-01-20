package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.Element
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph
import benchmarkdp.datagenerator.model.PSMDocx.Table
import benchmarkdp.datagenerator.model.PSMDocx.WordTable
import org.eclipse.emf.ecore.EObject

class MSWordTable extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		
		var t = object as WordTable
		
		var numR = t.numRows
		var numC = t.numCol
		var temp = cState.getVariable("temp") as String 
		cState.setVariable("inTable", new Boolean(true))
		temp = temp + '''
			oSelection.TypeParagraph()
			Set oRange = oSelection.Range
			oDoc.Tables.Add oRange, «numR», «numC»
			Set objTable = oDoc.Tables(tableIndex)
			objTable.AutoFormat(16)
		'''
		cState.setVariable("temp", temp)
		compileTableElements(t, cState)
		temp = cState.getVariable("temp") as String	
		temp = temp + '''
			tableIndex = tableIndex + 1
			oSelection.EndKey END_OF_STORY
			oSelection.TypeParagraph()
			i= i + 1
		'''
		cState.setVariable("temp", temp)
		cState.setVariable("inTable", new Boolean(false))
	}
	
	def compileTableElements(Table t, CompilerState cState) {
		
		for (var i = 1; i <= t.numRows; i++) {
			for (var j = 1; j <= t.numCol; j++) {
				var temp = cState.getVariable("temp") as String
				temp = temp + "objTable.Cell(" + i +"," + j +").Select\n"
				cState.setVariable("temp", temp)
				for (Element e: t.row.get(i-1).cell.get(j-1).elements) {
					switch e {
							Paragraph : compiler.compile("Paragraph", e)
					}
				}
				
			}
		}
	}
	
}