package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.model.PSMLibre.Paragraph
import benchmarkdp.datagenerator.model.PSMLibre.SimpleText
import benchmarkdp.datagenerator.model.PSMLibre.Text
import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import org.eclipse.emf.ecore.EObject
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import org.eclipse.xtend2.lib.StringConcatenation

class LibreParagraph extends AbstractElementCompiler {
	
	
	def compile(Paragraph par, boolean inTable) {
		var temp = '''
			'''
		
		return temp
	}
	
	override compile(EObject object, CompilerState cState) {
	
		var par = object as Paragraph 
		var numPar = cState.getVariable("parag") as Integer;
		var inTable = cState.getVariable("inTable") as Boolean;
		var parag = numPar.intValue 	
		var temp = cState.getVariable("temp") as String
		
		if (parag > 1 && !inTable) {
			temp = temp + '''
					oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)
				'''
		}
		cState.setVariable("temp", temp)
		if (!inTable) {
			parag = parag + 1			
		}
		cState.setVariable("parag", new Integer(parag))
		var counter = 0; 
		for (Text txt : par.words) {
			if (inTable && counter > 0) { 
				temp = cState.getVariable("temp") as String
				temp = temp + " + "
				cState.setVariable("temp", temp)
			}
			switch txt {
				SimpleText: compiler.compile("SimpleText", txt)
			}
			counter = counter + 1
		}			
		if (!inTable) {
			temp = cState.getVariable("temp") as String
			temp = temp + '''
				getLines(«parag», "«par.ID»", file)
			'''	
			cState.setVariable("temp", temp)		
		}
	}
	
}