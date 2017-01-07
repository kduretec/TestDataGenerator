package benchmarkdp.datagenerator.generator.codegenerator;

import benchmarkdp.datagenerator.generator.LibreCode;
import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;
import benchmarkdp.datagenerator.generator.TestFeature;
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
    TestFeature _testFeature = tC.getTestFeature();
    String _name = _testFeature.getName();
    this.documentName = _name;
    TestModel _testModel = tC.getTestModel();
    EList<EObject> _modelObjects = _testModel.getModelObjects();
    EObject _get = _modelObjects.get(0);
    Document d = ((Document) _get);
    this.numCodeLines = 0;
    this.compile(d);
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
  
  public void compileDocument(final Document d) {
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
    _builder_1.append("_");
    _builder_1.append(this.modelType, "");
    _builder_1.append("_");
    String _documentFormat = d.getDocumentFormat();
    _builder_1.append(_documentFormat, "");
    _builder_1.append("_");
    String _documentPlatform = d.getDocumentPlatform();
    _builder_1.append(_documentPlatform, "");
    _builder_1.append(".");
    String _documentFormat_1 = d.getDocumentFormat();
    _builder_1.append(_documentFormat_1, "");
    _builder_1.append("\"");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("oDoc.storeAsURL(Url2, Dummy())");
    _builder_1.newLine();
    _builder_1.append("oDoc.close(true)");
    _builder_1.newLine();
    _builder_1.append("End Sub");
    _builder_1.newLine();
    String endPart = _builder_1.toString();
    this.libreCode.addCodeElement(endPart);
    this.compileDocumentElements(d);
  }
  
  public void compileDocumentElements(final Document d) {
    EList<Page> _pages = d.getPages();
    for (final Page p : _pages) {
      this.compilePage(p);
    }
  }
  
  public void compilePage(final Page p) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
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
        if ((this.numCodeLines > 0)) {
          this.libreCode.addCodeElement(temp);
          this.numCodeLines = 0;
          StringConcatenation _builder_1 = new StringConcatenation();
          temp = _builder_1.toString();
        }
      }
    }
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
    StringConcatenation _builder_2 = new StringConcatenation();
    String _plus_2 = (temp + _builder_2);
    temp = _plus_2;
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
