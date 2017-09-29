package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText
import benchmarkdp.datagenerator.model.PSMDocx.Text
import benchmarkdp.datagenerator.model.PSMDocx.TextBox
import org.eclipse.emf.ecore.EObject

class MSWordTextBox extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		var tb = object as TextBox
		
		var temp = cState.getVariable("temp") as String
		temp = temp + '''
			oSelection.TypeParagraph()
			tBox = tBox + 1
			x = oSelection.Information(5)
			y = oSelection.Information(6)  
			oDoc.Shapes.AddTextbox 1, x, y, 500, 100
			Set textBox = oDoc.Shapes(tBox)
			textBox.WrapFormat.Type = 7
			textBox.TextFrame.AutoSize = True
		'''
		temp = temp + "\ntextBox.TextFrame.TextRange.Text = \""
		cState.setVariable("temp", temp)

		for (Text txt : tb.text) {
			switch txt {
				SimpleText: compileSimpleText(txt, cState)
				HyperLink: compiler.compile("HyperLink", txt)
			}
		}

		temp = cState.getVariable("temp") as String
		temp = temp + "\"\n"
		temp = temp + "oSelection.Move 5, 2\n";
		cState.setVariable("temp", temp)
		
	}
	
	def compileSimpleText(SimpleText txt, CompilerState cState) {
		
		var temp = cState.getVariable("temp") as String
		temp = temp + " " + txt.value
		cState.setVariable("temp", temp)
	
	}
}