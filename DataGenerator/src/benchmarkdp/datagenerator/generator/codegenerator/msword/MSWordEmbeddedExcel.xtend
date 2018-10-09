package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.Element
import benchmarkdp.datagenerator.model.PSMDocx.EmbeddedExcel
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph
import org.eclipse.emf.ecore.EObject

class MSWordEmbeddedExcel extends AbstractElementCompiler {
	
	override compile(EObject object, CompilerState cState) {
		
		var t = object as EmbeddedExcel
		var tabNum = cState.getVariable("inlineShape") as Integer
		var tN = tabNum.intValue
		tN = tN + 1
		cState.setVariable("inlineShape", new Integer(tN))
		
		var numR = t.numRows
		var numC = t.numCol
		var temp = cState.getVariable("temp") as String 
		cState.setVariable("inTable", new Boolean(true))
		temp = temp + '''
			oSelection.TypeParagraph()
			Set oRange = oSelection.Range
			oDoc.InlineShapes.AddOLEObject "Excel.Sheet", , , , , , , oRange
			Set oExcel = oDoc.InlineShapes(«tN»).OLEFormat.Object
			Set oSheet = oExcel.Worksheets("Sheet1")
		'''
		cState.setVariable("temp", temp)
		compileTableElements(t, cState)
		temp = cState.getVariable("temp") as String	
		temp = temp + '''
			oSheet.UsedRange.Borders.LineStyle = 1
			
			oSheet.Range(oSheet.Cells(«t.numRows + 1»,1), oSheet.Cells(oSheet.Rows.Count,oSheet.Columns.Count)).EntireRow.Hidden = True
			oSheet.Range(oSheet.Cells(1,«t.numCol + 1»), oSheet.Cells(oSheet.Rows.Count,oSheet.Columns.Count)).EntireColumn.Hidden = True
			
			REM oSelection.EndKey END_OF_STORY
			Set oExcel = oDoc.InlineShapes(«tN»)
			oSelection.Start = oExcel.Range.End + 1
			oSelection.TypeParagraph()
			i= i + 1
		'''
		cState.setVariable("temp", temp)
		cState.setVariable("inTable", new Boolean(false))
	}
	
	def compileTableElements(EmbeddedExcel t, CompilerState cState) {
		
		for (var i = 1; i <= t.numRows; i++) {
			for (var j = 1; j <= t.numCol; j++) {
				var temp = cState.getVariable("temp") as String
				temp = temp + "oSheet.Cells(" + i +"," + j +") = \" "
				for (Element e: t.row.get(i-1).cell.get(j-1).elements) {
					temp = temp + switch e {
							Paragraph : compileParagraph(e)
					}	
				}
				temp = temp + "\"\n"
				cState.setVariable("temp", temp)
			}
		}
	}
	
	def compileParagraph(Paragraph p) {
		var temp = ''''''
		if (p.text.size > 0) {
			temp = temp + p.text.get(0).value			
		}
		return temp
	}
	
	
}