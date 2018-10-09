package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.model.PSMLibre.Image
import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import org.eclipse.emf.ecore.EObject
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState

class LibreImage extends AbstractElementCompiler{
	
	
	override compile(EObject object, CompilerState cState) {
		var img = object as Image
		var temp = cState.getVariable("temp") as String
		temp = temp + '''
			oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)
			Set oGraph = oDoc.createInstance("com.sun.star.text.GraphicObject")
			
			'oGraph.GraphicURL = ConvertToURL("/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/INFSOF/experiments/Generated/Helpers/Images/Desert.jpg")
			oGraph.GraphicURL = LoadGraphicIntoDocument(oDoc, "file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/publications/INFSOF/experiments/Generated/Helpers/Images/Desert.jpg","«img.ID»")
			oGraph.AnchorType = com.sun.star.text.TextContentAnchorType.AS_CHARACTER
			oGraph.Width = TwipsPerPixelX() * «img.width» * 2540.0 / 1440 
			oGraph.Height = TwipsPerPixelY() * «img.height» * 2540.0 / 1440 
			oText.insertTextContent(oText.getEnd(), oGraph, False )
			oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)
		'''
		cState.setVariable("temp", temp)
	}
	
}