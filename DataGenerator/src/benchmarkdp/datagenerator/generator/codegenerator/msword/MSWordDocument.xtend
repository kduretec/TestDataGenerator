package benchmarkdp.datagenerator.generator.codegenerator.msword

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMDocx.Document
import org.eclipse.emf.ecore.EObject
import benchmarkdp.datagenerator.model.PSMDocx.Page

class MSWordDocument extends AbstractElementCompiler {
	
	override compile(EObject object, CompilerState cState) {
		var d = object as Document
		var temp = cState.getVariable("temp") as String
		
		temp = temp + '''
			Const END_OF_STORY = 6 
			Set objWord = CreateObject("Word.Application") 
			objWord.Visible = True 
			grFile = "c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\GroundTruth\GeneratedText\«cState.getVariable("documentName")».txt" 				
			grFileMetadata = "c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\GroundTruth\GeneratedMetadata\«cState.getVariable("documentName")».txt"
			Set objFSO = CreateObject("Scripting.FileSystemObject")
			Set objFile = objFSO.CreateTextFile(grFile, True)
			Set objFileMetadata = objFSO.CreateTextFile(grFileMetadata, True)
			Set oDoc = objWord.Documents.Add()
			oDoc.PageSetup.TextColumns.SetCount(«d.numColum») 
			Set oSelection = objWord.Selection 
			
			i = 1 
			tableIndex = 1
			tBox = 0
			cBox = 0
		'''
		cState.setVariable("temp", temp)
		
		compileDocumentElements(d, cState)
		
		temp = cState.getVariable("temp") as String 
		temp = temp + '''
			oDoc.SaveAs "c:\Users\Kresimir Duretec\Dropbox\Work\Projects\BenchmarkDP\benchmarking\publications\JSS\Generated\Documents\«cState.getVariable("documentName")».«d.documentFormat»", «d.documentFormatCode»
					
			objFileMetadata.Write "pagecount " & oDoc.ComputeStatistics(2) & vbCrLf
			objFileMetadata.Write "wordcount " & oDoc.ComputeStatistics(0) & vbCrLf
			objFileMetadata.Write "paragraphcount " & oDoc.ComputeStatistics(4)
			oDoc.Saved = TRUE
			objFile.Close()
			objFileMetadata.Close()
			objWord.Quit
			
			Sub selLines(p, id, o, outFile) 
			    p.Range.Select
			    counter = 1
			    
			    Do While True
			        o.Selection.Collapse(1)
			        Call o.Selection.EndKey(5,1)
			        outFile.Write(id & ":" & counter & ":" & o.Selection.Text & vbCrLf)
			        maxEnd = o.Selection.End
			        o.Selection.Collapse(0)
			        If maxEnd >= p.Range.End Then
			            Exit Do
			        End If
			        counter = counter + 1 
			    Loop
			    o.Selection.EndKey END_OF_STORY
			End Sub
		'''
		cState.setVariable("temp", temp)
	}
	
	def compileDocumentElements(Document d, CompilerState cState) {
		var check = false
		for (Page p : d.pages) {
			if (check) {
				var temp = cState.getVariable("temp") as String 
				temp = temp + "oSelection.InsertBreak(7)\n"
				cState.setVariable("temp", temp)
			}
			compiler.compile("Page", p)
			check = true
		}
	}
	
}