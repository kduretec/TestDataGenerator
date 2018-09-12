package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreGeneratedCode;
import benchmarkdp.datagenerator.model.PSMLibre.Color;
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
    Color _documentBackground = d.getDocumentBackground();
    this.compiler.compile("Color", _documentBackground);
    Object _variable = cState.getVariable("temp");
    String colorStr = ((String) _variable);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("REM ***** BASIC *****");
    _builder.newLine();
    _builder.append("Sub Main(docFolder, metadataFolder, textFolder) ");
    _builder.newLine();
    _builder.append("Dim Dummy()");
    _builder.newLine();
    _builder.append("Dim Url As String");
    _builder.newLine();
    _builder.append("Dim oDoc As Object");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Url = \"private:factory/swriter\"");
    _builder.newLine();
    _builder.append("file = FreeFile()");
    _builder.newLine();
    _builder.append("Open \"file://\" &amp; textFolder &amp; \"");
    Object _variable_1 = this.cS.getVariable("documentName");
    _builder.append(_variable_1, "");
    _builder.append(".txt\" For Output As #file");
    _builder.newLineIfNotEmpty();
    _builder.append("fileMetadata = FreeFile()");
    _builder.newLine();
    _builder.append("Open \"file://\" &amp; metadataFolder &amp; \"");
    Object _variable_2 = this.cS.getVariable("documentName");
    _builder.append(_variable_2, "");
    _builder.append(".txt\" For Output As #fileMetadata  ");
    _builder.newLineIfNotEmpty();
    _builder.append("oDoc = StarDesktop.loadComponentFromURL(Url, \"_blank\", 0, Array())");
    _builder.newLine();
    _builder.append("oStyleFamilies = ThisComponent.getStyleFamilies()");
    _builder.newLine();
    _builder.append("oPageStyle = oStyleFamilies.getByName(\"PageStyles\")");
    _builder.newLine();
    _builder.append("oMyPageStyle = oPageStyle.getByName(\"Default Style\")");
    _builder.newLine();
    _builder.append("oMyPageStyle.BackColor = ");
    _builder.append(colorStr, "");
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("oText = oDoc.getText()");
    _builder.newLine();
    String mainPart = _builder.toString();
    this.cS.setVariable("temp", "");
    Object _variable_3 = this.cS.getVariable("libreCode");
    LibreGeneratedCode lC = ((LibreGeneratedCode) _variable_3);
    lC.addCodeElement(mainPart);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Url2 = \"file://\" &amp; docFolder &amp; \"");
    Object _variable_4 = cState.getVariable("documentName");
    _builder_1.append(_variable_4, "");
    _builder_1.append(".");
    String _documentFormat = d.getDocumentFormat();
    _builder_1.append(_documentFormat, "");
    _builder_1.append("\"");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("pageCount = oDoc.getCurrentController().getPropertyValue(\"PageCount\")");
    _builder_1.newLine();
    _builder_1.append("REM paragraphCount = oDoc.getDocumentProperties().DocumentStatistics(4).Value");
    _builder_1.newLine();
    _builder_1.append("REM wordCount = oDoc.getDocumentProperties().DocumentStatistics(5).Value");
    _builder_1.newLine();
    _builder_1.append("Print #fileMetadata \"pagecount \" &amp; pageCount");
    _builder_1.newLine();
    _builder_1.append("REM Print #fileMetadata \"paragraphcount \" &amp; wordCount");
    _builder_1.newLine();
    _builder_1.append("REM Print #fileMetadata \"wordcount \" &amp; wordCount");
    _builder_1.newLine();
    _builder_1.append("Dim args(0) as new com.sun.star.beans.PropertyValue");
    _builder_1.newLine();
    _builder_1.append("args(0).Name = \"FilterName\"");
    _builder_1.newLine();
    _builder_1.append("args(0).Value = \"");
    String _documentFilter = d.getDocumentFilter();
    _builder_1.append(_documentFilter, "");
    _builder_1.append("\"");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("oDoc.storeToURL(Url2, args())");
    _builder_1.newLine();
    _builder_1.append("Close #file");
    _builder_1.newLine();
    _builder_1.append("Close #fileMetadata");
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
