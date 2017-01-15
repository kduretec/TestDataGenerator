package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.Image
import org.eclipse.emf.ecore.EObject

class MSWordImage extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		
		var img = object as Image
		var temp = cState.getVariable("temp") as String 
		temp = temp + '''
			Set oImg = oSelection.InlineShapes.AddPicture("c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\Macro\Images\Desert.jpg")
			oImg.Height = «img.height»
			oImg.Width = «img.width»
		'''
		cState.setVariable("temp", temp)
		
	}
	
}