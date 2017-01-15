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
				Open "file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/GroundTruth/LibreOffice/«cS.getVariable("documentName")»-libregroundtruth.txt" For Output As #file 
				oDoc = StarDesktop.loadComponentFromURL(Url, "_blank", 0, Array())
				
				oText = oDoc.getText()
		'''
		var lC = cS.getVariable("libreCode") as LibreGeneratedCode
		lC.addCodeElement(mainPart)

		var endPart = '''
				Url2 = "file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Documents/«cState.getVariable("documentName")».«d.documentFormat»"
				oDoc.storeAsURL(Url2, Dummy())
				Close #file
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
	