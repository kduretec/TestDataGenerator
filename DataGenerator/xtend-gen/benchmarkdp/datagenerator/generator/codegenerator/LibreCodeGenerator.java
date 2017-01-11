package benchmarkdp.datagenerator.generator.codegenerator;

import benchmarkdp.datagenerator.generator.LibreCode;
import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;
import benchmarkdp.datagenerator.generator.TestModel;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface;
import benchmarkdp.datagenerator.model.PSMLibre.Document;
import benchmarkdp.datagenerator.model.PSMLibre.Element;
import benchmarkdp.datagenerator.model.PSMLibre.Image;
import benchmarkdp.datagenerator.model.PSMLibre.Page;
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph;
import benchmarkdp.datagenerator.model.PSMLibre.SimpleText;
import benchmarkdp.datagenerator.model.PSMLibre.Table;
import benchmarkdp.datagenerator.model.PSMLibre.Text;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreCodeGenerator implements CodeGeneratorInterface {
  private ModelType modelType = ModelType.PSMLibre;
  
  private String documentName;
  
  private int documentNumber = 0;
  
  private int parag = 0;
  
  private int numCodeLines = 0;
  
  private LibreCode libreCode;
  
  private CodeGeneratorObserverInterface cGOb;
  
  public LibreCodeGenerator(final CodeGeneratorObserverInterface cO) {
    this.cGOb = cO;
  }
  
  @Override
  public ModelType getModelType() {
    return this.modelType;
  }
  
  @Override
  public void generateCode(final TestCase tC) {
    LibreCode _libreCode = new LibreCode(this.cGOb);
    this.libreCode = _libreCode;
    String _testCaseName = tC.getTestCaseName();
    this.documentName = _testCaseName;
    TestModel _testModel = tC.getTestModel();
    EList<EObject> _modelObjects = _testModel.getModelObjects();
    EObject _get = _modelObjects.get(0);
    Document d = ((Document) _get);
    this.numCodeLines = 0;
    this.compile(d);
    String _documentPlatform = d.getDocumentPlatform();
    this.libreCode.setPlatform(_documentPlatform);
    tC.setGeneratedCode(this.libreCode);
    this.libreCode = null;
  }
  
  public int compile(final Document d) {
    int _xblockexpression = (int) 0;
    {
      this.compileDocument(d);
      _xblockexpression = this.documentNumber++;
    }
    return _xblockexpression;
  }
  
  public String compileDocument(final Document d) {
    String _xblockexpression = null;
    {
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
      _builder.append(this.documentName, "\t");
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
      this.libreCode.addCodeElement(mainPart);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Url2 = \"file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Documents/");
      _builder_1.append(this.documentName, "");
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
      _builder_1.newLine();
      _builder_1.append("Sub getLines(numPar, file) ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("oTextCursor = ThisComponent.Text.createTextCursor()");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("oTextCursor.gotoStart(False)");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("oViewCursor = ThisComponent.CurrentController.getViewCursor()");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("num = 0");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Do ");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("num = num + 1");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("line = 0");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("oTextCursor.gotoStartOfParagraph(False)");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("oViewCursor.gotoRange(oTextCursor, False)");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("If numPar = num Then\t");
      _builder_1.newLine();
      _builder_1.append("        \t");
      _builder_1.append("Do While True ");
      _builder_1.newLine();
      _builder_1.append("            \t");
      _builder_1.append("oViewCursor.gotoEndOfLine(False)");
      _builder_1.newLine();
      _builder_1.append("            \t");
      _builder_1.append("oTextCursor.gotoRange(oViewCursor, True)");
      _builder_1.newLine();
      _builder_1.append("            \t");
      _builder_1.append("line = line + 1");
      _builder_1.newLine();
      _builder_1.append("            \t");
      _builder_1.append("s = numPar &amp; \":\" &amp; line &amp; \":\" &amp; oTextCursor.String");
      _builder_1.newLine();
      _builder_1.append("            \t");
      _builder_1.append("Print #file, s");
      _builder_1.newLine();
      _builder_1.append("            \t");
      _builder_1.append("REM MsgBox \"numparh=\" + num + \" numline=\" + line + \" text=\" + oTextCursor.String, 0, \"Lines\"");
      _builder_1.newLine();
      _builder_1.append("            \t");
      _builder_1.append("oTextCursor.collapseToEnd()");
      _builder_1.newLine();
      _builder_1.append("            \t");
      _builder_1.append("If oTextCursor.isEndOfParagraph() Then Exit Do ");
      _builder_1.newLine();
      _builder_1.append("        \t");
      _builder_1.append("Loop");
      _builder_1.newLine();
      _builder_1.append("        \t");
      _builder_1.append("Exit Do ");
      _builder_1.newLine();
      _builder_1.append("\t\t        \t");
      _builder_1.append("End If");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Loop While oTextCursor.gotoNextParagraph(False)  ");
      _builder_1.newLine();
      _builder_1.append("End Sub");
      _builder_1.newLine();
      String endPart = _builder_1.toString();
      this.libreCode.addCodeElement(endPart);
      _xblockexpression = this.compileDocumentElements(d);
    }
    return _xblockexpression;
  }
  
  public String compileDocumentElements(final Document d) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      String temp = _builder.toString();
      EList<Page> _pages = d.getPages();
      for (final Page p : _pages) {
        String _compilePage = this.compilePage(p, temp);
        temp = _compilePage;
      }
      String _xifexpression = null;
      int _length = temp.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        String _xblockexpression_1 = null;
        {
          this.libreCode.addCodeElement(temp);
          this.numCodeLines = 0;
          StringConcatenation _builder_1 = new StringConcatenation();
          _xblockexpression_1 = temp = _builder_1.toString();
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String compilePage(final Page p, final String t) {
    String temp = t;
    EList<Element> _elements = p.getElements();
    for (final Element e : _elements) {
      {
        String _switchResult = null;
        boolean _matched = false;
        if (e instanceof Paragraph) {
          _matched=true;
          _switchResult = this.compileParagraph(((Paragraph)e), false);
        }
        if (!_matched) {
          if (e instanceof Table) {
            _matched=true;
            _switchResult = this.compileTable(((Table)e));
          }
        }
        if (!_matched) {
          if (e instanceof Image) {
            _matched=true;
            _switchResult = this.compileImage(((Image)e));
          }
        }
        String _plus = (temp + _switchResult);
        temp = _plus;
        int _length = temp.length();
        boolean _greaterThan = (_length > 40000);
        if (_greaterThan) {
          this.libreCode.addCodeElement(temp);
          this.numCodeLines = 0;
          StringConcatenation _builder = new StringConcatenation();
          temp = _builder.toString();
        }
      }
    }
    return temp;
  }
  
  public String compileParagraph(final Paragraph par, final boolean inTable) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    if (((this.parag > 1) && (!inTable))) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)");
      _builder_1.newLine();
      String _plus = (temp + _builder_1);
      temp = _plus;
      this.numCodeLines++;
    }
    this.parag = (this.parag + 1);
    EList<Text> _words = par.getWords();
    for (final Text txt : _words) {
      String _switchResult = null;
      boolean _matched = false;
      if (txt instanceof SimpleText) {
        _matched=true;
        _switchResult = this.compileSimpleText(((SimpleText)txt));
      }
      String _plus_1 = (temp + _switchResult);
      temp = _plus_1;
    }
    if ((!inTable)) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("getLines(");
      _builder_2.append(this.parag, "");
      _builder_2.append(", file)");
      _builder_2.newLineIfNotEmpty();
      String _plus_2 = (temp + _builder_2);
      temp = _plus_2;
    }
    StringConcatenation _builder_3 = new StringConcatenation();
    String _plus_3 = (temp + _builder_3);
    temp = _plus_3;
    return temp;
  }
  
  public String compileTable(final Table t) {
    int numR = t.getNumRows();
    int numC = t.getNumCol();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("oTable = ThisComponent.createInstance( \"com.sun.star.text.TextTable\" )");
    _builder.newLine();
    _builder.append("oTable.initialize(");
    _builder.append(numR, "");
    _builder.append(", ");
    _builder.append(numC, "");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("oText.insertTextContent(oText.getEnd(), oTable, False)");
    _builder.newLine();
    String _compileTableElements = this.compileTableElements(t);
    _builder.append(_compileTableElements, "");
    _builder.newLineIfNotEmpty();
    String temp = _builder.toString();
    this.numCodeLines = (this.numCodeLines + 3);
    return temp;
  }
  
  public String compileTableElements(final Table t) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    for (int i = 1; (i <= t.getNumRows()); i++) {
      for (int j = 1; (j <= t.getNumCol()); j++) {
      }
    }
    return temp;
  }
  
  public String compileImage(final Image img) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    return temp;
  }
  
  public String compileSimpleText(final SimpleText t) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("oText.insertString(oText.getEnd(), \" ");
    String _value = t.getValue();
    _builder.append(_value, "");
    _builder.append("\", False)");
    _builder.newLineIfNotEmpty();
    String temp = _builder.toString();
    this.numCodeLines++;
    return temp;
  }
}
