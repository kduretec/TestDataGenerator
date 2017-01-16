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
		compiler.addCompiler("Document", new MSWordDocument())
		compiler.addCompiler("Page", new MSWordPage())
		compiler.addCompiler("Paragraph", new MSWordParagraph())
		compiler.addCompiler("TextBox", new MSWordTextBox())
		compiler.addCompiler("ControlBox", new MSWordControlBox())
		compiler.addCompiler("Table", new MSWordTable())
		compiler.addCompiler("Image", new MSWordImage())
		compiler.addCompiler("SimpleText", new MSWordSimpleText())
		compiler.addCompiler("HyperLink", new MSWordHyperLink())
		compiler.addCompiler("Color", new MSWordColor())
		
	}

	override getModelType() {
		return modelType;
	}

	override generateCode(TestCase tC) {
		var d = tC.getTestModel().getModelObjects.get(0) as Document
		
		compilerState.setVariable("documentName", tC.testCaseName)
		compilerState.setVariable("parag", new Integer(0))
		compilerState.setVariable("inTable", new Boolean(false))
		var sCode = new MSWordGeneratedCode("vbs", d.documentPlatform)
		compilerState.setVariable("temp", new String(""));
		
		compiler.compile("Document", d);
		var s = compilerState.getVariable("temp") as String
		sCode.generatedCode = s
		tC.generatedCode = sCode;
	}

	
}
