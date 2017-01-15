package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.generator.ModelType
import benchmarkdp.datagenerator.generator.TestCase
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.generator.codegenerator.ModelElementsCompiler
import benchmarkdp.datagenerator.model.PSMLibre.Document
import benchmarkdp.datagenerator.model.PSMLibre.Element
import benchmarkdp.datagenerator.model.PSMLibre.Image
import benchmarkdp.datagenerator.model.PSMLibre.Page
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph
import benchmarkdp.datagenerator.model.PSMLibre.Table

class LibreCodeGenerator implements CodeGeneratorInterface {

	ModelType modelType = ModelType::PSMLibre;

	CodeGeneratorObserverInterface cGOb;
	ModelElementsCompiler compiler;
	CompilerState compilerState;

	new(CodeGeneratorObserverInterface cO) {
		cGOb = cO;
		compilerState = new CompilerState();
		compiler = new ModelElementsCompiler(compilerState);
		
		compiler.addCompiler("Document", new LibreDocument())
		compiler.addCompiler("Page", new LibrePage())
		compiler.addCompiler("Paragraph", new LibreParagraph())
		compiler.addCompiler("Table", new LibreTable())
		compiler.addCompiler("Image", new LibreImage())
		compiler.addCompiler("SimpleText", new LibreSimpleText())
		
	}

	override getModelType() {
		return modelType;
	}

	override generateCode(TestCase tC) {

		var d = tC.getTestModel().getModelObjects.get(0) as Document

		var libreCode = new LibreGeneratedCode(cGOb);
		libreCode.platform = d.documentPlatform
		compilerState.setVariable("libreCode", libreCode)
		compilerState.setVariable("documentName", tC.testCaseName)
		compilerState.setVariable("numCodeLines", new Integer(0))
		compilerState.setVariable("parag", new Integer(0));

		compiler.compile("Document", d);

		libreCode.addHelperFunction(helper())
		tC.generatedCode = libreCode

	}

	def helper() {
		var fun = '''
			Sub getLines(numPar, file) 
				oTextCursor = ThisComponent.Text.createTextCursor()
			    oTextCursor.gotoStart(False)
			    oViewCursor = ThisComponent.CurrentController.getViewCursor()
			    num = 0
			    Do 
			        num = num + 1
			        line = 0
			        oTextCursor.gotoStartOfParagraph(False)
			        oViewCursor.gotoRange(oTextCursor, False)
			        If numPar = num Then	
			        	Do While True 
			        	   	oViewCursor.gotoEndOfLine(False)
			        	   	oTextCursor.gotoRange(oViewCursor, True)
			        	   	line = line + 1
			        	   	s = numPar &amp; ":" &amp; line &amp; ":" &amp; oTextCursor.String
			        	   	Print #file, s
			        	   	REM MsgBox "numparh=" + num + " numline=" + line + " text=" + oTextCursor.String, 0, "Lines"
			        	   	oTextCursor.collapseToEnd()
			        	   	If oTextCursor.isEndOfParagraph() Then Exit Do 
			        	Loop
			        	Exit Do 
			        End If
			    Loop While oTextCursor.gotoNextParagraph(False)  
			End Sub
		'''
		return fun
	}
}
	