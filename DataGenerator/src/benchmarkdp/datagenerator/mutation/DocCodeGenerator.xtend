package benchmarkdp.datagenerator.mutation

import benchmarkdp.datagenerator.model.PSMDoc.Document
import benchmarkdp.datagenerator.model.PSMDoc.Element
import benchmarkdp.datagenerator.model.PSMDoc.HyperLink
import benchmarkdp.datagenerator.model.PSMDoc.Page
import benchmarkdp.datagenerator.model.PSMDoc.Paragraph
import benchmarkdp.datagenerator.model.PSMDoc.SimpleText
import benchmarkdp.datagenerator.model.PSMDoc.Table
import benchmarkdp.datagenerator.model.PSMDoc.Text
import benchmarkdp.datagenerator.model.PSMDoc.TextBox
import benchmarkdp.datagenerator.model.PSMDoc.Color

class DocCodeGenerator implements CodeGeneratorInterface {

	
	ModelType modelType = ModelType::PSMDoc;
	int parag = 1;
	int documentNumber = 0;
	String documentName;
	
	new() {
	}

	override getModelType() {
		return modelType;
	}

	override generateCode(TestModel tm) {
		documentName = tm.testFeature.name
		var d = tm.modelObjects.get(0) as Document;
		var s = compile(d);
		tm.generatedCode = s;
	}

	def String compile(Document d) {
		var String co = compileDocument(d).toString()
		documentNumber++
		return co;
	}

	def compileDocument(
		Document d) '''
		
		Const END_OF_STORY = 6 
		Set objWord = CreateObject("Word.Application") 
		objWord.Visible = True 
		Set oDoc = objWord.Documents.Add()
		oDoc.PageSetup.TextColumns.SetCount(«d.numColum») 
		Set oSelection = objWord.Selection 
		
		i = 1 
		tableIndex = 1
		tBox = 0
		«compileDocumentElements(d)»
		oDoc.SaveAs "c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\Documents\«documentName»_«d.documentFormat»_«d.documentPlatform».«d.documentFormat»", «d.documentFormatCode»
		
		grFile = "c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\GroundTruth\«documentName»_«d.documentFormat»_«d.documentPlatform»-wordgroundtruth.txt" 
		
		Set objFSO = CreateObject("Scripting.FileSystemObject")
		Set objFile = objFSO.CreateTextFile(grFile, True)
		objFile.Write "pagecount " & oDoc.ComputeStatistics(2) & vbCrLf
		objFile.Write "wordcount " & oDoc.ComputeStatistics(0) & vbCrLf
		objFile.Write "paragraphcount " & oDoc.ComputeStatistics(4)
		oDoc.Saved = TRUE
		objFile.Close()
		objWord.Quit
	'''

	def compileDocumentElements(Document d) {
		var temp = ''''''
		var check = false
		for (Page p : d.pages) {
			if (check) {
				temp = temp + "oSelection.InsertBreak(7)\n"
			}
			temp = temp + compilePage(p)
			check = true
		}
		return temp
	}

	def compilePage(Page p) {
		var temp = ''''''
		for (Element e : p.elements) {
			temp = temp + switch e {
				Paragraph: compileParagraph(e)
				TextBox: compileTextBox(e)
				Table: compileTable(e)
			}

		}

		return temp

	}

	def compileParagraph(Paragraph par) {
		var temp = '''
		'''
		if (parag > 1) {
			temp = temp + '''
				oSelection.TypeParagraph()
			'''
		}
		parag = parag + 1
		for (Text txt : par.words) {
			temp = temp + switch txt {
				SimpleText: compileSimpleText(txt)
				HyperLink: compileHyperLink(txt)
			}

		}
		temp = temp + '''
			i = i + 1
		'''
		return temp
	}

	def compileTextBox(TextBox tb) {

		var temp = '''
		tBox = tBox + 1
		oDoc.Shapes.AddTextbox 1, 80, 100, 500, 32
		Set textBox = oDoc.Shapes(tBox)'''
		temp = temp + "\ntextBox.TextFrame.TextRange.Text = \""

		for (Text txt : tb.words) {
			temp = temp + switch txt {
				SimpleText: " " + txt.value
				HyperLink: compileHyperLink(txt)
			}

		}

		temp = temp + "\"\n"
		return temp
	}

	def compileTable(Table t) {
		var numR = t.numRows
		var numC = t.numCol

		var temp = '''
			oSelection.TypeParagraph()
			Set oRange = oSelection.Range
			oDoc.Tables.Add oRange, «numR», «numC»
			Set objTable = oDoc.Tables(tableIndex)
			objTable.AutoFormat(16)
			tableIndex = tableIndex + 1
			oSelection.EndKey END_OF_STORY
			oSelection.TypeParagraph()
			i= i + 1
		'''
		return temp
	}

	def compileHyperLink(HyperLink h) {
		var temp = '''
			Set oRange = oSelection.Range
			oDoc.Hyperlinks.Add oRange, "«h.url»", , , " «h.value»"
		'''
		return temp
	}
	
	def compileSimpleText(SimpleText t) {
		var temp = '''
			oSelection.Font.Color = «compileColor(t.color)» 
			oSelection.Shading.BackgroundPatternColor =«compileColor(t.background)»
			oSelection.Font.Size = «t.size»
			oSelection.TypeText(" «t.value» ")
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
