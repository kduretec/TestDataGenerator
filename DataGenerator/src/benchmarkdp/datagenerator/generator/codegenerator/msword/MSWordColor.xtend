package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.generator.codegenerator.IEnumCompiler
import benchmarkdp.datagenerator.model.PSMDocx.Color
import org.eclipse.emf.common.util.Enumerator
import org.eclipse.emf.ecore.EObject

class MSWordColor extends AbstractElementCompiler implements IEnumCompiler {
	
	override compile(Enumerator en, CompilerState cState) {
		
		var c = en as Color 
		var temp = cState.getVariable("temp") as String
		temp =  temp + "RGB("
		if (c == Color::BLACK) {
			temp = temp + "0,0,0"
		}
		if (c == Color::WHITE) {
			temp = temp + "255,255,255"
		}
		if (c == Color::RED) {
			temp = temp + "255,0,0"
		}
		if (c == Color::BLUE) {
			temp = temp + "0,0,255"
		}
		temp = temp + ")\n"
		
		cState.setVariable("temp", temp)
		
	}
	
	override compile(EObject object, CompilerState cState) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}