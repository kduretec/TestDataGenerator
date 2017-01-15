package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.ControlBox
import benchmarkdp.datagenerator.model.PSMDocx.Element
import benchmarkdp.datagenerator.model.PSMDocx.Image
import benchmarkdp.datagenerator.model.PSMDocx.Page
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph
import benchmarkdp.datagenerator.model.PSMDocx.Table
import benchmarkdp.datagenerator.model.PSMDocx.TextBox
import org.eclipse.emf.ecore.EObject

class MSWordPage extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		var p = object as Page
		for (Element e : p.elements) {
			switch e {
				Paragraph: compiler.compile("Paragraph",e)
				ControlBox : compiler.compile("ControlBox",e)
				TextBox: compiler.compile("TextBox", e)
				Table: compiler.compile("Table", e)
				Image: compiler.compile("Image", e)
			}
		}
	}
}