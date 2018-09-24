package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.generator.codegenerator.ModelElementsCompiler
import benchmarkdp.datagenerator.model.PSMDocx.Document
import benchmarkdp.datagenerator.testcase.ModelType
import benchmarkdp.datagenerator.testcase.TestCase
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface

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
		compiler.addCompiler("EmbeddedExcel", new MSWordEmbeddedExcel())
		compiler.addCompiler("FontFamily", new MSWordFontFamily())
	}

	override getModelType() {
		return modelType;
	}

	override generateCode(TestCase tC) {
		var d = tC.getTestModel().getModelObjects.get(0) as Document
		
		compilerState.setVariable("documentName", tC.testCaseName)
		compilerState.setVariable("parag", new Integer(0))
		compilerState.setVariable("inTable", new Boolean(false))
		compilerState.setVariable("inlineShape", new Integer(0))
		var sCode = new MSWordGeneratedCode("vbs", d.operatingSystem, d.software)
		compilerState.setVariable("temp", new String(""));
		compilerState.setVariable("msWordCode", sCode);
		compilerState.setVariable("calcLayout", new Boolean(false));
		
		compiler.compile("Document", d);
		var s = compilerState.getVariable("temp") as String
		//sCode.generatedCode = s
		sCode.addGeneratedCode(s)
		tC.generatedCode = sCode;
	}
	
	override addCodeGeneratorObserver(CodeGeneratorObserverInterface cgo) {
	}

	
}
