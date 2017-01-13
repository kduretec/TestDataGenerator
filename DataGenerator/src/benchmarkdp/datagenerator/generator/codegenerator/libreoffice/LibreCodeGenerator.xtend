package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.generator.ModelType
import benchmarkdp.datagenerator.generator.TestCase
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface
import benchmarkdp.datagenerator.model.PSMLibre.Document
import benchmarkdp.datagenerator.model.PSMLibre.Element
import benchmarkdp.datagenerator.model.PSMLibre.Image
import benchmarkdp.datagenerator.model.PSMLibre.Page
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph
import benchmarkdp.datagenerator.model.PSMLibre.SimpleText
import benchmarkdp.datagenerator.model.PSMLibre.Table
import benchmarkdp.datagenerator.model.PSMLibre.Text

class LibreCodeGenerator implements CodeGeneratorInterface {

	ModelType modelType = ModelType::PSMLibre;
	String documentName;
	int documentNumber = 0;
	int parag = 0;

	int numCodeLines = 0;
	LibreCode libreCode;
	CodeGeneratorObserverInterface cGOb;

	new(CodeGeneratorObserverInterface cO) {
		cGOb = cO;
	}

	override getModelType() {
		return modelType;
	}

	override generateCode(TestCase tC) {
		libreCode = new LibreCode(cGOb)
		documentName = tC.testCaseName
		var d = tC.getTestModel().getModelObjects.get(0) as Document
		numCodeLines = 0
		parag = 0;
		compile(d)
		libreCode.platform = d.documentPlatform
		libreCode.addHelperFunction(helper())
		tC.generatedCode = libreCode
		libreCode = null
	}

	def compile(Document d) {
		compileDocument(d)
		documentNumber++
	}

	def compileDocument(Document d) {

		var mainPart = '''
			REM ***** BASIC *****
			Sub Main 
				Dim Dummy()
				Dim Url As String
				Dim oDoc As Object
				
				Url = "private:factory/swriter"
				file = FreeFile()
				Open "file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/GroundTruth/LibreOffice/«documentName»-libregroundtruth.txt" For Output As #file 
				oDoc = StarDesktop.loadComponentFromURL(Url, "_blank", 0, Array())
				
				oText = oDoc.getText()
		'''
		libreCode.addCodeElement(mainPart)

		var endPart = '''
			Url2 = "file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Documents/«documentName».«d.documentFormat»"
			oDoc.storeAsURL(Url2, Dummy())
			Close #file
			oDoc.close(true)
			End Sub
						
			'''
		libreCode.addCodeElement(endPart)

		compileDocumentElements(d)

	}

	def compileDocumentElements(Document d) {
		var temp = ''''''
		for (Page p : d.pages) {
			temp = compilePage(p, temp)
		}
		if (temp.length > 0) {
			libreCode.addCodeElement(temp);
			numCodeLines = 0;
			temp = ''''''
		}
	}

	def compilePage(Page p, String t) {
		var temp = t
		for (Element e : p.elements) {
			temp = temp + switch e {
				Paragraph: compileParagraph(e, false)
				Table: compileTable(e)
				Image: compileImage(e)
			}
			if (temp.length > 40000) {
				libreCode.addCodeElement(temp);
				numCodeLines = 0;
				temp = ''''''
			}
		}
		return temp
		
	
	}

	def compileParagraph(Paragraph par, boolean inTable) {
		var temp = '''
			'''
		if (parag > 1 && !inTable) {
			temp = temp + '''
					oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)
				'''
			numCodeLines++
		}
		parag = parag + 1
		for (Text txt : par.words) {
			temp = temp + switch txt {
				SimpleText: compileSimpleText(txt)
			}
		}
		if (!inTable) {
			temp = temp + '''
				getLines(«parag», file)
			'''			
		}
		temp = temp + '''
		'''
		return temp
	}

	def compileTable(Table t) {
		var numR = t.numRows
		var numC = t.numCol

		var temp = '''
			oTable = ThisComponent.createInstance( "com.sun.star.text.TextTable" )
			oTable.initialize(«numR», «numC»)
			oText.insertTextContent(oText.getEnd(), oTable, False)
			«compileTableElements(t)»
		'''
		numCodeLines = numCodeLines + 3;
		return temp
	}

	def compileTableElements(Table t) {
		var temp = ''''''
		for (var i = 1; i <= t.numRows; i++) {
			for (var j = 1; j <= t.numCol; j++) {
					// temp = temp + "objTable.Cell(" + i +"," + j +").Select\n"
					// for (Element e: t.row.get(i-1).cell.get(j-1).elements) {
					// temp = temp + switch e {
					// Paragraph : compileParagraph(e, true)
					// }
					// }
			}
		}
		return temp
	}

	def compileImage(Image img) {
		var temp = ''''''
			// temp = temp + '''Set oImg = oSelection.InlineShapes.AddPicture("c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\Macro\Images\Desert.jpg")
			// oImg.Height = «img.height»
			// oImg.Width = «img.width»
			// '''
		return temp
	}

	def compileSimpleText(SimpleText t) {
		var temp = '''
			oText.insertString(oText.getEnd(), " «t.value»", False)
			'''
		numCodeLines++;
		return temp
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
	