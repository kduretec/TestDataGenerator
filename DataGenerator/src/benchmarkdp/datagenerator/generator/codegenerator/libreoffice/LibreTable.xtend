package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMLibre.Element
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph
import benchmarkdp.datagenerator.model.PSMLibre.Table
import org.eclipse.emf.ecore.EObject

class LibreTable extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		var t = object as Table
		var numR = t.numRows
		var numC = t.numCol
		
		var temp = cState.getVariable("temp") as String
		cState.setVariable("inTable", new Boolean(true))
		temp = temp + '''
			oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)
			oTable = ThisComponent.createInstance( "com.sun.star.text.TextTable" )
			oTable.initialize(«numR», «numC»)
			oText.insertTextContent(oText.getEnd(), oTable, False)
		'''
		cState.setVariable("temp", temp)
		compileTableElements(t, cState)
		
		
		cState.setVariable("inTable", new Boolean(false))
		
	}
	
	def compileTableElements(Table t, CompilerState cState) {
		
		for (var i = 1; i <= t.numRows; i++) {
			for (var j = 1; j <= t.numCol; j++) {				
				if (t.row.get(i-1).cell.get(j-1).elements.size > 0) {					
				var temp = cState.getVariable("temp") as String
					temp = temp + "Set oCell = oTable.getCellByPosition(" + (j-1) +"," + (i-1) +")\n"
					temp = temp + "oCell.setString( "
					cState.setVariable("temp", temp)
					for (Element e: t.row.get(i-1).cell.get(j-1).elements) {
						switch e {
								Paragraph : compiler.compile("Paragraph", e)
						}
					}
					temp = cState.getVariable("temp") as String
					temp = temp + " ) \n"
					cState.setVariable("temp", temp)
				}
			}
		}
	}
	
	
}