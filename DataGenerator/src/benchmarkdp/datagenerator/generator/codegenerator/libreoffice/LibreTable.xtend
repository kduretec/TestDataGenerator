package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMLibre.Element
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph
import benchmarkdp.datagenerator.model.PSMLibre.Table
import org.eclipse.emf.ecore.EObject
import benchmarkdp.datagenerator.model.PSMLibre.TableType

class LibreTable extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		var t = object as Table
		var numR = t.numRows
		var numC = t.numCol
		var numPar = cState.getVariable("parag") as Integer;
		var parag = numPar.intValue
		parag = parag + 1
		cState.setVariable("parag", new Integer(parag)) 
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
		//System.out.println("Adding table");
		cState.setVariable("tableType", t.type);
		if (t.type==TableType::BIGNUMBERTABLE || t.type==TableType::SMALLNUMBERTABLE) {
			compileNumberTableElements(t, cState);	
		}else {
			//System.out.println("Adding text table");
			compileTextTableElements(t, cState);
		}
		
	}
	
	def compileNumberTableElements(Table t, CompilerState cState) {
		
		for (var i = 1; i <= t.numRows; i++) {
			for (var j = 1; j <= t.numCol; j++) {				
				if (t.row.get(i-1).cell.get(j-1).elements.size > 0) {					
				var temp = cState.getVariable("temp") as String
					temp = temp + "Set oCell = oTable.getCellByPosition(" + (j-1) + "," + (i-1) +")\n"
					temp = temp + "oCell.setString( \""
					cState.setVariable("temp", temp)
					for (Element e: t.row.get(i-1).cell.get(j-1).elements) {
						switch e {
								Paragraph : compiler.compile("Paragraph", e)
						}
					}
					temp = cState.getVariable("temp") as String
					temp = temp + "\") \n"
					cState.setVariable("temp", temp)
					
					var tempF = cState.getVariable("temp") as String
					if (tempF.length > 40000) {
						var lC = cState.getVariable("libreCode") as LibreGeneratedCode
						lC.addCodeElement(tempF);
						cState.setVariable("temp", "");
					}
				
				}
			}
		}
		
	}
	
	def compileTextTableElements(Table t, CompilerState cState) {
		
		for (var i = 1; i <= t.numRows; i++) {
			for (var j = 1; j <= t.numCol; j++) {				
				if (t.row.get(i-1).cell.get(j-1).elements.size > 0) {					
					//var temp = cState.getVariable("temp") as String
					cState.setVariable("iTablePos", new Integer(i-1));
					cState.setVariable("jTablePos", new Integer(j-1));
					//temp = temp + "Set oCell = oTable.getCellByPosition(" + (j-1) + "," + (i-1) +")\n"
					//temp = temp + "oCell.setString( \""
					//cState.setVariable("temp", temp)
					for (Element e: t.row.get(i-1).cell.get(j-1).elements) {
						switch e {
								Paragraph : compiler.compile("Paragraph", e)
						}
					}
					//temp = cState.getVariable("temp") as String
					//temp = temp + "\") \n"	
					//cState.setVariable("temp", temp)
					
					var tempF = cState.getVariable("temp") as String
					if (tempF.length > 40000) {
						var lC = cState.getVariable("libreCode") as LibreGeneratedCode
						lC.addCodeElement(tempF);
						cState.setVariable("temp", "");
					}
				
				}
			}
		}
		
	}
	
}