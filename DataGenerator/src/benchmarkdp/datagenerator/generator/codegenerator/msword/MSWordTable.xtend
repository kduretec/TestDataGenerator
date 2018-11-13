package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.Element
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph
import benchmarkdp.datagenerator.model.PSMDocx.WordTable
import org.eclipse.emf.ecore.EObject
import benchmarkdp.datagenerator.model.PSMDocx.TableType

class MSWordTable extends AbstractElementCompiler {

	override compile(EObject object, CompilerState cState) {

		var t = object as WordTable
		var numR = t.numRows
		var numC = t.numCol
		var temp = cState.getVariable("temp") as String
		cState.setVariable("inTable", new Boolean(true))
		cState.setVariable("tableType", t.type)
		temp = temp + '''
			oSelection.TypeParagraph()
			Set oRange = oSelection.Range
			oDoc.Tables.Add oRange, «numR», «numC»
			Set objTable = oDoc.Tables(tableIndex)
			objTable.AutoFormat(16)
			objTable.Range.Font.Size = «10»
		'''
		cState.setVariable("temp", temp)
		compileTableElements(t, cState)
		temp = cState.getVariable("temp") as String
		temp = temp + '''
			tableIndex = tableIndex + 1
			oSelection.EndKey END_OF_STORY
			oSelection.TypeParagraph()
			REM i= i + 1
		'''
		cState.setVariable("temp", temp)
		cState.setVariable("inTable", new Boolean(false))
		cState.setVariable("tableType", null)
	}

	def compileTableElements(WordTable t, CompilerState cState) {

		for (var j = 1; j <= t.numCol; j++) {
			for (var i = 1; i <= t.numRows; i++) {
				var temp = cState.getVariable("temp") as String
				if (t.type == TableType::ONECOLUMNTABLE || t.type == TableType::TEXTTABLE) {
					temp = temp + "objTable.Cell(" + i +"," + j +").Select\n"
				} else {
					temp = temp + "Set oRange = objTable.Cell(" + i + "," + j + ").Range\n"					
				}
				cState.setVariable("temp", temp)
				for (Element e : t.row.get(i - 1).cell.get(j - 1).elements) {
					switch e {
						Paragraph: compiler.compile("Paragraph", e)
					}
				}
			}
		}
	}

}
