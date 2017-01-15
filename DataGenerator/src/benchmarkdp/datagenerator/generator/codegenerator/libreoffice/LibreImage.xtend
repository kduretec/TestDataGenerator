package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.model.PSMLibre.Image
import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import org.eclipse.emf.ecore.EObject
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState

class LibreImage extends AbstractElementCompiler{
	
	
	override compile(EObject object, CompilerState cState) {
		var img = object as Image
		var temp = ''''''
			// temp = temp + '''Set oImg = oSelection.InlineShapes.AddPicture("c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\Macro\Images\Desert.jpg")
			// oImg.Height = «img.height»
			// oImg.Width = «img.width»
			// '''
	}
	
}