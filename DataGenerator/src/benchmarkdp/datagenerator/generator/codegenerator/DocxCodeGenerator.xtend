package benchmarkdp.datagenerator.generator.codegenerator

import benchmarkdp.datagenerator.generator.ModelType
import benchmarkdp.datagenerator.generator.SingleFileCode
import benchmarkdp.datagenerator.generator.TestCase
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
	int parag = 0;
	int documentNumber = 0;
	String documentName;
	
	new() {
	}

	override getModelType() {
		return modelType;
	}

	override generateCode(TestCase tC) {
		documentName = tC.testCaseName
		var d = tC.getTestModel().getModelObjects.get(0) as Document
		var sCode = new SingleFileCode("vbs", d.documentPlatform)
		var s = compile(d);
		sCode.generatedCode = s
		tC.generatedCode = sCode;
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
		grFile = "c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\GroundTruth\MSWordOutput\«documentName»-wordgroundtruth.txt" 				
		Set objFSO = CreateObject("Scripting.FileSystemObject")
		Set objFile = objFSO.CreateTextFile(grFile, True)
		Set oDoc = objWord.Documents.Add()
		oDoc.PageSetup.TextColumns.SetCount(«d.numColum») 
		Set oSelection = objWord.Selection 
		
		i = 1 
		tableIndex = 1
		tBox = 0
		cBox = 0
		«compileDocumentElements(d)»
		oDoc.SaveAs "c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\Documents\«documentName».«d.documentFormat»", «d.documentFormatCode»
				
		objFile.Write "pagecount " & oDoc.ComputeStatistics(2) & vbCrLf
		objFile.Write "wordcount " & oDoc.ComputeStatistics(0) & vbCrLf
		objFile.Write "paragraphcount " & oDoc.ComputeStatistics(4)
		oDoc.Saved = TRUE
		objFile.Close()
		objWord.Quit
		
		Sub selLines(p, id, o, outFile) 
		    p.Range.Select
		    counter = 1
		    Do While True
		        o.Selection.Collapse(1)
		        Call o.Selection.EndKey(5,1)
		        outFile.Write("id:counter:" & o.Selection.Text & vbCrLf)
		        maxEnd = o.Selection.End
		        o.Selection.Collapse(0)
		        If maxEnd = p.Range.End Then
		            Exit Do
		        End If
		        counter = counter + 1 
		    Loop
		End Sub
		
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
				Paragraph: compileParagraph(e, false)
				ControlBox : compileControlBox(e)
				TextBox: compileTextBox(e)
				Table: compileTable(e)
				Image: compileImage(e)
			}

		}

		return temp

	}

	def compileParagraph(Paragraph par, boolean inTable) {
		var temp = '''
		'''
		if (parag > 0 && !inTable) {
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
		Call selLines(oDoc.Paragraphs(«parag»), «parag», objWord, objFile)
		'''
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

	def compileControlBox(ControlBox cb) {
		System.out.println("Content control is compiled")
		var temp = '''
		cBox = cBox +1
		oSelection.TypeParagraph()
		Set oRange = oSelection.Range
		oDoc.ContentControls.Add 0, oRange
		Set oControl = oDoc.ContentControls(cBox)
		oControl.Range.Text = "'''
		  
		for (Text txt : cb.words) {
			temp = temp + switch txt {
				SimpleText : "" + txt.value
				HyperLink : compileHyperLink(txt)
			}
		}
		
		temp = temp + "\"\n"
		temp = temp + "oSelection.Start = oControl.Range.End + 1 \n oSelection.TypeParagraph() \n"
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
			«compileTableElements(t)»
			tableIndex = tableIndex + 1
			oSelection.EndKey END_OF_STORY
			oSelection.TypeParagraph()
			i= i + 1
		'''
		return temp
	}

	def compileTableElements(Table t) {
		var temp = ''''''
		for (var i = 1; i <= t.numRows; i++) {
			for (var j = 1; j <= t.numCol; j++) {
				temp = temp + "objTable.Cell(" + i +"," + j +").Select\n"
				for (Element e: t.row.get(i-1).cell.get(j-1).elements) {
					temp = temp + switch e {
							Paragraph : compileParagraph(e, true)
						}
				}
				
			}
		}
		return temp
	}
	
	
	def compileImage(Image img) {
		var temp = ''''''
		temp = temp + '''Set oImg = oSelection.InlineShapes.AddPicture("c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\Macro\Images\Desert.jpg")
		oImg.Height = «img.height»
		oImg.Width = «img.width»
		'''
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
