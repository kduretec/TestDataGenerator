package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.Image
import org.eclipse.emf.ecore.EObject

class MSWordImage extends AbstractElementCompiler{
	
	override compile(EObject object, CompilerState cState) {
		
		var img = object as Image
		var temp = cState.getVariable("temp") as String 
		var	imgNum = cState.getVariable("inlineShape") as Integer
		var iN = imgNum.intValue
		iN = iN + 1
		cState.setVariable("inlineShape", new Integer(iN))
		temp = temp + '''
			Set oImg = oSelection.InlineShapes.AddPicture("c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\Macro\Images\Desert.jpg")
			oImg.Height = «img.height»
			oImg.Width = «img.width»
			oSelection.TypeParagraph()
		'''
		cState.setVariable("temp", temp)
		
	}
	
}