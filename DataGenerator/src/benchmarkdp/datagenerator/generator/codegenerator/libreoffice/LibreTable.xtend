package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.model.PSMLibre.Table
import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import org.eclipse.emf.ecore.EObject
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState

class LibreTable extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		var t = object as Table
		var numR = t.numRows
		var numC = t.numCol
		
		var temp = cState.getVariable("temp") as String
		cState.setVariable("inTable", new Boolean(true))
		temp = temp + '''
			oTable = ThisComponent.createInstance( "com.sun.star.text.TextTable" )
			oTable.initialize(«numR», «numC»)
			oText.insertTextContent(oText.getEnd(), oTable, False)
		'''
		temp = temp + compileTableElements(t)
		cState.setVariable("temp", temp)
		cState.setVariable("inTable", new Boolean(false))
		
	}
	
	def compileTableElements(Table t) {
		var temp = ''''''
		for (var i = 1; i <= t.numRows; i++) {
			for (var j = 1; j <= t.numCol; j++) {
					// temp = temp + "objTable.Cell(" + i +"," + j +").Select\n"
					// for (Element e: t.row.get(i-1).cell.get(j-1).elements) {
					// temp = temp + switch e {
					// Paragraph : compileParagraph(e, true)
					// }
					// }
			}
		}
		return temp
	}
	
	
}