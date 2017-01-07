package benchmarkdp.datagenerator.generator.codegenerator

import benchmarkdp.datagenerator.generator.LibreCode
import benchmarkdp.datagenerator.generator.ModelType
import benchmarkdp.datagenerator.generator.TestCase
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
		compile(d)
		libreCode.platform = d.documentPlatform
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
				oDoc = StarDesktop.loadComponentFromURL(Url, "_blank", 0, Array())
				
				oText = oDoc.getText()
		'''
		libreCode.addCodeElement(mainPart)

		var endPart = '''
			Url2 = "file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Documents/«documentName».«d.documentFormat»"
			oDoc.storeAsURL(Url2, Dummy())
			oDoc.close(true)
			End Sub
			'''
		libreCode.addCodeElement(endPart)

		compileDocumentElements(d)

	}

	def compileDocumentElements(Document d) {
		for (Page p : d.pages) {
			compilePage(p)
		}
	}

	def compilePage(Page p) {
		var temp = ''''''
		for (Element e : p.elements) {
			temp = temp + switch e {
				Paragraph: compileParagraph(e, false)
				Table: compileTable(e)
				Image: compileImage(e)
			}
			if (numCodeLines > 0) {
				libreCode.addCodeElement(temp);
				numCodeLines = 0;
				temp = ''''''
			}
		}
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

	}
	