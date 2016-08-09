package benchmarkdp.datagenerator.mutation;

import benchmarkdp.datagenerator.model.PIM.Document;

public class CodeGenerator {

	private VBCodeGenerator codeGenerator;
	
	
	public CodeGenerator() {
		codeGenerator = new VBCodeGenerator();
		
	}
	
	public void generateCode(DocumentHolder dH) {
		Document d = (Document)dH.getDocumentObjects().get(0);
		String s = codeGenerator.compile(d);
		dH.setGeneratedCode(s);
	}
}
