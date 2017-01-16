package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText
import benchmarkdp.datagenerator.model.PSMDocx.Text
import org.eclipse.emf.ecore.EObject

class MSWordParagraph extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		var par = object as Paragraph;
		var paragNum = cState.getVariable("parag") as Integer
		var parag = paragNum.intValue
		var inTable = cState.getVariable("inTable") as Boolean 
		
		var temp = cState.getVariable("temp") as String
		
	
		if (parag > 0 && !inTable) {
			temp = temp + '''
				oSelection.TypeParagraph()
			'''
			cState.setVariable("temp", temp)
		}
		
		parag = parag + 1
		cState.setVariable("parag", new Integer(parag))
		
		for (Text txt : par.words) {
			switch txt {
				SimpleText: compiler.compile("SimpleText", txt)
				HyperLink: compiler.compile("HyperLink", txt)
			}
		}
		
		temp = cState.getVariable("temp") as String
		if (!inTable) { 
			temp = temp + ''' 
				Call selLines(oDoc.Paragraphs(oDoc.Paragraphs.Count), "«par.ID»", objWord, objFile)
			'''			
		}
		
		temp = temp + '''
			i = i + 1
		'''
		cState.setVariable("temp", temp)
	}
	
}