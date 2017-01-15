package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreGeneratedCode;
import benchmarkdp.datagenerator.model.PSMLibre.Document;
import benchmarkdp.datagenerator.model.PSMLibre.Page;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreDocument extends AbstractElementCompiler {
  private CompilerState cS;
  
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Document d = ((Document) object);
    this.cS = cState;
    this.cS.setVariable("temp", "");
    Boolean _boolean = new Boolean(false);
    this.cS.setVariable("inTable", _boolean);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("REM ***** BASIC *****");
    _builder.newLine();
    _builder.append("Sub Main ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Dim Dummy()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Dim Url As String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Dim oDoc As Object");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Url = \"private:factory/swriter\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("file = FreeFile()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Open \"file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/GroundTruth/LibreOffice/");
    Object _variable = this.cS.getVariable("documentName");
    _builder.append(_variable, "\t");
    _builder.append("-libregroundtruth.txt\" For Output As #file ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("oDoc = StarDesktop.loadComponentFromURL(Url, \"_blank\", 0, Array())");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oText = oDoc.getText()");
    _builder.newLine();
    String mainPart = _builder.toString();
    Object _variable_1 = this.cS.getVariable("libreCode");
    LibreGeneratedCode lC = ((LibreGeneratedCode) _variable_1);
    lC.addCodeElement(mainPart);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Url2 = \"file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Documents/");
    Object _variable_2 = cState.getVariable("documentName");
    _builder_1.append(_variable_2, "");
    _builder_1.append(".");
    String _documentFormat = d.getDocumentFormat();
    _builder_1.append(_documentFormat, "");
    _builder_1.append("\"");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("oDoc.storeAsURL(Url2, Dummy())");
    _builder_1.newLine();
    _builder_1.append("Close #file");
    _builder_1.newLine();
    _builder_1.append("oDoc.close(true)");
    _builder_1.newLine();
    _builder_1.append("End Sub");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.newLine();
    String endPart = _builder_1.toString();
    lC.addCodeElement(endPart);
    this.cS.setVariable("libreCode", lC);
    this.compileDocumentElements(d);
  }
  
  public void compileDocumentElements(final Document d) {
    EList<Page> _pages = d.getPages();
    for (final Page p : _pages) {
      this.compiler.compile("Page", p);
    }
    Object _variable = this.cS.getVariable("temp");
    String temp = ((String) _variable);
    int _length = temp.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      Object _variable_1 = this.cS.getVariable("libreCode");
      LibreGeneratedCode lC = ((LibreGeneratedCode) _variable_1);
      lC.addCodeElement(temp);
      this.cS.setVariable("temp", "");
      this.cS.setVariable("libreCode", lC);
    }
  }
}
