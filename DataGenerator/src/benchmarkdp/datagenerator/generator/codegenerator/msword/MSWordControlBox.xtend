package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.ControlBox
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText
import benchmarkdp.datagenerator.model.PSMDocx.Text
import org.eclipse.emf.ecore.EObject

class MSWordControlBox extends AbstractElementCompiler {

	override compile(EObject object, CompilerState cState) {

		var cb = object as ControlBox
		var temp = cState.getVariable("temp") as String

		temp = temp + '''
		cBox = cBox +1
		oSelection.TypeParagraph()
		Set oRange = oSelection.Range
		oDoc.ContentControls.Add 0, oRange
		Set oControl = oDoc.ContentControls(cBox)
		oControl.Range.Text = " '''
		cState.setVariable("temp", temp)
		var paragNum = cState.getVariable("parag") as Integer
		var parag = paragNum.intValue
		parag = parag + 1
		cState.setVariable("parag", new Integer(parag))
		for (Text txt : cb.text) {
			switch txt {
				SimpleText: compileSimpleText(txt, cState)
				HyperLink: compiler.compile("HyperLink", txt)
			}
		}

		temp = cState.getVariable("temp") as String
		temp = temp + "\"\n"
		var cl = cState.getVariable("calcLayout") as Boolean
		var inTable = cState.getVariable("inTable") as Boolean
		if (!inTable) {
			if (cl) {
				temp = temp + '''
					Call selLines(oControl, "«cb.ID»", objWord, objFile)		
				'''
			}
		}
		temp = temp + "oSelection.Start = oControl.Range.End + 1 \n oSelection.TypeParagraph() \n"
		cState.setVariable("temp", temp)
	}

	def compileSimpleText(SimpleText txt, CompilerState cState) {

		var temp = cState.getVariable("temp") as String
		temp = temp + " " + txt.value
		cState.setVariable("temp", temp)

	}
}
