package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.ModelType
import benchmarkdp.datagenerator.generator.TestCase
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.generator.codegenerator.ModelElementsCompiler
import benchmarkdp.datagenerator.model.PSMDocx.Color
import benchmarkdp.datagenerator.model.PSMDocx.ControlBox
import benchmarkdp.datagenerator.model.PSMDocx.Document
import benchmarkdp.datagenerator.model.PSMDocx.Element
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink
import benchmarkdp.datagenerator.model.PSMDocx.Image
import benchmarkdp.datagenerator.model.PSMDocx.Page
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText
import benchmarkdp.datagenerator.model.PSMDocx.Table
import benchmarkdp.datagenerator.model.PSMDocx.Text
import benchmarkdp.datagenerator.model.PSMDocx.TextBox

class DocxCodeGenerator implements CodeGeneratorInterface {

	ModelType modelType = ModelType::PSMDocx;
	
	ModelElementsCompiler compiler;
	CompilerState compilerState;
	
	new() {
		compilerState = new CompilerState();
		compiler = new ModelElementsCompiler(compilerState);
	}

	override getModelType() {
		return modelType;
	}

	override generateCode(TestCase tC) {
		var d = tC.getTestModel().getModelObjects.get(0) as Document
		
		compilerState.setVariable("documentName", tC.testCaseName)
		compilerState.setVariable("parag", new Integer(0))
		var sCode = new MSWordGeneratedCode("vbs", d.documentPlatform)
		compilerState.setVariable("temp", new String(""));
		
		compiler.compile("Document", d);
		var s = compilerState.getVariable("temp") as String
		sCode.generatedCode = s
		tC.generatedCode = sCode;
	}
	
	
	def compileHyperLink(HyperLink h) {
		var temp = '''
			Set oRange = oSelection.Range
			oDoc.Hyperlinks.Add oRange, "«h.url»", , , " «h.value»"
		'''
		return temp
	}

	def compileColor(Color c) {
		var temp = '''RGB('''
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
		temp = temp + ''')'''
	}
	
}
