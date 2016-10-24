package benchmarkdp.datagenerator.mutation

import benchmarkdp.datagenerator.model.PSMLibre.Document

class LibreCodeGenerator implements CodeGeneratorInterface {
	
	ModelType modelType = ModelType::PSMLibre;
	String documentName;
	int documentNumber = 0;
	CodeGeneratorObserverInterface cGOb;
	
	new(CodeGeneratorObserverInterface cO) {
		cGOb = cO;
	}
	
	override getModelType() {
		return modelType;
	}
	
	override generateCode(TestModel tm) {
		documentName = tm.testFeature.name
		var d = tm.modelObjects.get(0) as Document;
		var s = compile(d);
		tm.generatedCode = s;
		cGOb.notify(documentName);
	}
	
	
	def compile(Document d) {
		var String co = compileDocument(d).toString()
		documentNumber++
		return co;
	}
	
	def compileDocument(Document d) '''
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE library:libraries PUBLIC "-//OpenOffice.org//DTD OfficeDocument 1.0//EN" "module.dtd">
	<script:module xmlns:script="http://openoffice.org/2000/script" script:name="«documentName»" script:language="StarBasic">
	
	REM ***** BASIC *****
	Sub Main 
	Dim Dummy()
	Dim Url As String
	Dim Doc As Object
	
	Url = "private:factory/swriter"
	Doc = StarDesktop.loadComponentFromURL(Url, "_blank", 0, Dummy())
	
	Url2 = "file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Documents/«documentName».odt"
	Doc.storeAsURL(Url2, Dummy())
	Doc.close(true)
	End Sub
	
	</script:module>
	'''
}