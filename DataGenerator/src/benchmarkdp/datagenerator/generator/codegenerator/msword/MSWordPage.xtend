package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.ControlBox
import benchmarkdp.datagenerator.model.PSMDocx.Element
import benchmarkdp.datagenerator.model.PSMDocx.EmbeddedExcel
import benchmarkdp.datagenerator.model.PSMDocx.Image
import benchmarkdp.datagenerator.model.PSMDocx.Page
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph
import benchmarkdp.datagenerator.model.PSMDocx.TextBox
import benchmarkdp.datagenerator.model.PSMDocx.WordTable
import org.eclipse.emf.ecore.EObject

class MSWordPage extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		var p = object as Page
		//var i = 0; 
		//var size = p.elements.size
		for (Element e : p.elements) {
			//i = i + 1;
			//println("Compiling object " + i + "/" + size)
			switch e {
				Paragraph: compiler.compile("Paragraph",e)
				ControlBox : compiler.compile("ControlBox",e)
				TextBox: compiler.compile("TextBox", e)
				WordTable: compiler.compile("Table", e)
				EmbeddedExcel: compiler.compile("EmbeddedExcel", e)
				Image: compiler.compile("Image", e)
			}
		}
		
		var temp = cState.getVariable("temp") as String
			if (temp.length > 40000) {
				var mC = cState.getVariable("msWordCode") as MSWordGeneratedCode
				mC.addGeneratedCode(temp);
				cState.setVariable("temp", "")
			}
	}
}