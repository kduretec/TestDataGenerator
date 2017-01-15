package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMLibre.Element
import benchmarkdp.datagenerator.model.PSMLibre.Image
import benchmarkdp.datagenerator.model.PSMLibre.Page
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph
import benchmarkdp.datagenerator.model.PSMLibre.Table
import org.eclipse.emf.ecore.EObject

class LibrePage extends AbstractElementCompiler {
	
	override compile(EObject object, CompilerState cState) {
	
		var p = object as Page
		for (Element e : p.elements) {
				switch e {
					Paragraph: compiler.compile("Paragraph", e)
					Table: compiler.compile("Table", e)
					Image: compiler.compile("Image", e)
				}
				var temp = cState.getVariable("temp") as String
				if (temp.length > 40000) {
					var lC = cState.getVariable("libreCode") as LibreGeneratedCode
					lC.addCodeElement(temp);
					cState.setVariable("temp", "")
				}
		}
	}
}