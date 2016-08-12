package benchmarkdp.datagenerator.mutation;

import benchmarkdp.datagenerator.model.PSMDoc.Document;

public class CodeGenerator {

	private VBCodeGenerator codeGenerator;
	
	
	public CodeGenerator() {
		codeGenerator = new VBCodeGenerator();
		
	}
	
	public void generateCode(DocumentHolder dH) {
		Document d = (Document)dH.getDocumentObjects("PSM").get(0);
		String s = codeGenerator.compile(d);
		dH.setGeneratedCode("PSM", s);
	}
}
