package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText
import benchmarkdp.datagenerator.model.PSMDocx.Text
import org.eclipse.emf.ecore.EObject

class MSWordParagraph extends AbstractElementCompiler {

	override compile(EObject object, CompilerState cState) {
		var par = object as Paragraph;
		
		var cl = cState.getVariable("calcLayout") as Boolean
		
		if (cl.booleanValue) {
			compileParagSmallDoc(par, cState)
		} else {
			compileParagBigDoc(par, cState)
		}
		
	}

	def compileParagSmallDoc(Paragraph par, CompilerState cState) {
		var paragNum = cState.getVariable("parag") as Integer
		var parag = paragNum.intValue
		var inTable = cState.getVariable("inTable") as Boolean
		cState.setVariable("oneTextEl", new Boolean(false));
		var temp = cState.getVariable("temp") as String

		if (parag > 0 && !inTable) {
			temp = temp + '''
				oSelection.TypeParagraph()
			'''
			cState.setVariable("temp", temp)
		}

		parag = parag + 1
		if (!inTable) {
			temp = temp + ''' 
			oDoc.Paragraphs(oDoc.Paragraphs.Count).Range.Select
			oDoc.Paragraphs.Last.Range.Select
			REM Set oRange = oDoc.Paragraphs.Last.Range
			oSelection.ParagraphFormat.Shading.BackgroundPatternColor = '''
			cState.setVariable("temp", temp)
			compiler.compile("Color", par.backgroundColor)
			temp = cState.getVariable("temp") as String
			temp = temp + ''' 
			oSelection.Font.Color = '''
			cState.setVariable("temp", temp)
			compiler.compile("Color", par.fontColor)
			temp = cState.getVariable("temp") as String
			temp = temp + '''
			oSelection.Font.Name = '''
			cState.setVariable("temp", temp)
			compiler.compile("FontFamily", par.fontFamily)
			temp = cState.getVariable("temp") as String

		}

		cState.setVariable("parag", new Integer(parag))

		for (Text txt : par.text) {
			switch txt {
				SimpleText: compiler.compile("SimpleText", txt)
				HyperLink: compiler.compile("HyperLink", txt)
			}
		}

		temp = cState.getVariable("temp") as String
		if (!inTable) {
			temp = temp + ''' 
				Call selLines(oSelection.Paragraphs.Last, "«par.ID»", objWord, objFile)
			'''
		}
		cState.setVariable("temp", temp)
	}
	
	def compileParagBigDoc(Paragraph par, CompilerState cState) {
		var paragNum = cState.getVariable("parag") as Integer
		var parag = paragNum.intValue
		var inTable = cState.getVariable("inTable") as Boolean
		cState.setVariable("oneTextEl", new Boolean(false));
		var temp = cState.getVariable("temp") as String

		if (parag > 0 && !inTable) {
			temp = temp + '''
				oSelection.TypeParagraph()
				REM oDoc.Paragraphs.Add
			'''
			cState.setVariable("temp", temp)
		}

		parag = parag + 1
		if (!inTable) {
			temp = temp + ''' 
			REM oDoc.Paragraphs(oDoc.Paragraphs.Count).Range.Select
			REM oDoc.Paragraphs.Last.Range.Select
			Set oRange = oDoc.Paragraphs.Last.Range
			REM oSelection.ParagraphFormat.Shading.BackgroundPatternColor = '''
			cState.setVariable("temp", temp)
			compiler.compile("Color", par.backgroundColor)
			temp = cState.getVariable("temp") as String
			temp = temp + ''' 
			REM oSelection.Font.Color = '''
			cState.setVariable("temp", temp)
			compiler.compile("Color", par.fontColor)
			temp = cState.getVariable("temp") as String
			temp = temp + '''
			REM oSelection.Font.Name = '''
			cState.setVariable("temp", temp)
			compiler.compile("FontFamily", par.fontFamily)
			temp = cState.getVariable("temp") as String

		}


		cState.setVariable("parag", new Integer(parag))

		if (par.text.size == 1) {
			cState.setVariable("oneTextEl", new Boolean(true));
		}
		for (Text txt : par.text) {
			switch txt {
				SimpleText: compiler.compile("SimpleText", txt)
				HyperLink: compiler.compile("HyperLink", txt)
			}
		}
		cState.setVariable("oneTextEl", new Boolean(false));
	}
	
}
