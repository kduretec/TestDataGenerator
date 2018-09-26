package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph
import benchmarkdp.datagenerator.model.PSMLibre.Text
import org.eclipse.emf.ecore.EObject

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

		/*if (parag > 1 && !inTable) {
		 * 	temp = temp + '''
		 * 			oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)
		 * 		'''
		 }*/
		if (!inTable) {
			var tempBack = temp
			temp = ""
			cState.setVariable("temp", temp)
			compiler.compile("Color", par.backgroundColor)
			var col = cState.getVariable("temp") as String
			temp = ""
			cState.setVariable("temp", temp)
			compiler.compile("FontFamily", par.fontFamily)
			var font = cState.getVariable("temp") as String
			temp = tempBack + ''' 
				oCur = ThisComponent.CurrentController.getViewCursor()
				oCur.ParaStyleName  = getParagraphStyleName(«col»,«font»)
			'''
		}
		cState.setVariable("temp", temp)
		if (!inTable) {
			parag = parag + 1
		}
		cState.setVariable("parag", new Integer(parag))
		var counter = 0;
		for (Text txt : par.text) {
			if (inTable && counter > 0) {
				temp = cState.getVariable("temp") as String
				temp = temp + " + "
				cState.setVariable("temp", temp)
			}
			switch txt {
				Text: compiler.compile("SimpleText", txt)
			}
			// make sure that paragraph is not bigger than 64kB
			var tempF = cState.getVariable("temp") as String
			if (tempF.length > 40000) {
				var lC = cState.getVariable("libreCode") as LibreGeneratedCode
				lC.addCodeElement(tempF);
				cState.setVariable("temp", "")
			}

			counter = counter + 1
		}
		var cl = cState.getVariable("calcLayout") as Boolean
		if (!inTable) {
			if (cl) {
				temp = cState.getVariable("temp") as String
				temp = temp + '''
					getLines(«parag», "«par.ID»", file, oText.createTextCursorByRange(oText.getEnd()))
					oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)
				'''
				cState.setVariable("temp", temp)
			}
		}
	}

}
