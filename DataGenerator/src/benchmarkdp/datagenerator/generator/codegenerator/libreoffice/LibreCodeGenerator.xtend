package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.generator.codegenerator.ModelElementsCompiler
import benchmarkdp.datagenerator.model.PSMLibre.Document
import benchmarkdp.datagenerator.testcase.ModelType
import benchmarkdp.datagenerator.testcase.TestCase
 
class LibreCodeGenerator implements CodeGeneratorInterface {

	ModelType modelType = ModelType::PSMLibre;

	CodeGeneratorObserverInterface cGOb;
	ModelElementsCompiler compiler;
	CompilerState compilerState;

	new() {
		compilerState = new CompilerState();
		compiler = new ModelElementsCompiler(compilerState);
		
		compiler.addCompiler("Document", new LibreDocument())
		compiler.addCompiler("Page", new LibrePage())
		compiler.addCompiler("Paragraph", new LibreParagraph())
		compiler.addCompiler("Table", new LibreTable())
		compiler.addCompiler("Image", new LibreImage())
		compiler.addCompiler("SimpleText", new LibreSimpleText())
		compiler.addCompiler("Color", new LibreColor())
		compiler.addCompiler("FontFamily", new LibreFontFamily())
		
	}

	override getModelType() {
		return modelType;
	}

	override addCodeGeneratorObserver(CodeGeneratorObserverInterface cgo) {
		cGOb = cgo;
	}
	
	override generateCode(TestCase tC) {

		var d = tC.getTestModel().getModelObjects.get(0) as Document

		var libreCode = new LibreGeneratedCode(cGOb);
		libreCode.software = d.software
		libreCode.operatingSystem = d.operatingSystem
		compilerState.setVariable("libreCode", libreCode)
		compilerState.setVariable("documentName", tC.testCaseName)
		compilerState.setVariable("numCodeLines", new Integer(0))
		compilerState.setVariable("parag", new Integer(0));

		compiler.compile("Document", d);

		libreCode.addHelperFunction(helper())
		libreCode.addHelperFunction(helper2())
		tC.generatedCode = libreCode

	}

	// This is a helper function used to get the content of each line in a paragraph
	def helper() {
		var fun = '''
			Sub getLines(numPar, parID, file, textCursor) 
			    oTextCursor = textCursor
			    oViewCursor = ThisComponent.CurrentController.getViewCursor()
			    line = 0
			    oTextCursor.gotoStartOfParagraph(False)
			    oViewCursor.gotoRange(oTextCursor, False)	
			        Do While True 
			        	oViewCursor.gotoEndOfLine(False)
			        	oTextCursor.gotoRange(oViewCursor, True)
		       			line = line + 1
		        	   	s = parID &amp; ":" &amp; line &amp; ":" &amp; oTextCursor.String
		        	   	Print #file, s
		        	   	REM MsgBox "numparh=" + num + " numline=" + line + " text=" + oTextCursor.String, 0, "Lines"
		        	   	oTextCursor.collapseToEnd()
		        	   	If oTextCursor.isEndOfParagraph() Then Exit Do 
		        	Loop  
			End Sub
			
		'''
		return fun
	}
	
	/* *
	// This is a helper function used to get the content of each line in a paragraph
	def helper() {
		var fun = '''
			Sub getLines(numPar, parID, file) 
				oTextCursor = ThisComponent.Text.createTextCursor()
			    oTextCursor.gotoStart(False)
			    oViewCursor = ThisComponent.CurrentController.getViewCursor()
			    num = numPar
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
			        	   	s = parID &amp; ":" &amp; line &amp; ":" &amp; oTextCursor.String
			        	   	Print #file, s
			        	   	MsgBox "numparh=" + num + " numline=" + line + " text=" + oTextCursor.String, 0, "Lines"
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
	*/
	
	// This is a helper function used to return paragraph style for a paragraph  
	def helper2() {
		var fun = '''
			Function getParagraphStyleName(colorCode, fontName) as String
				Dim stName As String
				stName = "PAR_BACK_" &amp; colorCode &amp; "_" &amp; fontName  
				oStyleFamilies = ThisComponent.getStyleFamilies()
				oParagraphStyles = oStyleFamilies.getByName("ParagraphStyles")
				If (NOT oParagraphStyles.HasByName(stName))  Then
					oStyle = ThisComponent.createInstance("com.sun.star.style.ParagraphStyle")
					oStyle.ParaBackColor = 	colorCode
					oStyle.CharFontName = fontName
					oParagraphStyles.insertByName(stName, oStyle)
				End If 
				getParagraphStyleName = stName
			End Function 
		
		'''
		return fun
	}
	
}
	