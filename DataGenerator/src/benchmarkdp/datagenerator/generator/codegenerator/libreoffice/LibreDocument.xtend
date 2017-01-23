package benchmarkdp.datagenerator.generator.codegenerator.libreoffice

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState
import benchmarkdp.datagenerator.model.PSMLibre.Document
import benchmarkdp.datagenerator.model.PSMLibre.Page
import org.eclipse.emf.ecore.EObject

class LibreDocument extends AbstractElementCompiler {

	CompilerState cS;
	override compile(EObject object, CompilerState cState) {
		var d = object as Document
		cS = cState;
		cS.setVariable("temp", "")
		cS.setVariable("inTable", new Boolean(false))
		var mainPart = '''
			REM ***** BASIC *****
			Sub Main 
				Dim Dummy()
				Dim Url As String
				Dim oDoc As Object
				
				Url = "private:factory/swriter"
				file = FreeFile()
				Open "file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/GroundTruth/GeneratedText/«cS.getVariable("documentName")».txt" For Output As #file
				fileMetadata = FreeFile()
				Open "file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/GroundTruth/GeneratedMetadata/«cS.getVariable("documentName")».txt" For Output As #fileMetadata  
				oDoc = StarDesktop.loadComponentFromURL(Url, "_blank", 0, Array())
				
				oText = oDoc.getText()
		'''
		var lC = cS.getVariable("libreCode") as LibreGeneratedCode
		lC.addCodeElement(mainPart)

		var endPart = '''
				Url2 = "file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Documents/«cState.getVariable("documentName")».«d.documentFormat»"
				Dim args(0) as new com.sun.star.beans.PropertyValue
				args(0).Name = "FilterName"
				args(0).Value = "«d.documentFilter»"
				oDoc.storeToURL(Url2, args())
				Close #file
				Close #fileMetadata
				oDoc.close(true)
				End Sub
							
			'''
		lC.addCodeElement(endPart)
		cS.setVariable("libreCode", lC)
		compileDocumentElements(d)

		}

		def compileDocumentElements(Document d) {
			for (Page p : d.pages) {
				compiler.compile("Page", p)
			}
			var temp = cS.getVariable("temp") as String
			if (temp.length > 0) {
				var lC = cS.getVariable("libreCode") as LibreGeneratedCode
				lC.addCodeElement(temp);
				cS.setVariable("temp", "")
				cS.setVariable("libreCode", lC)
			}
		}

	}
	