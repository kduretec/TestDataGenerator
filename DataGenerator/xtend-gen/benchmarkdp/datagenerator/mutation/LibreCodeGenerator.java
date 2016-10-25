package benchmarkdp.datagenerator.mutation;

import benchmarkdp.datagenerator.model.PSMLibre.Document;
import benchmarkdp.datagenerator.model.PSMLibre.Element;
import benchmarkdp.datagenerator.model.PSMLibre.Image;
import benchmarkdp.datagenerator.model.PSMLibre.Page;
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph;
import benchmarkdp.datagenerator.model.PSMLibre.SimpleText;
import benchmarkdp.datagenerator.model.PSMLibre.Table;
import benchmarkdp.datagenerator.model.PSMLibre.Text;
import benchmarkdp.datagenerator.mutation.CodeGeneratorInterface;
import benchmarkdp.datagenerator.mutation.CodeGeneratorObserverInterface;
import benchmarkdp.datagenerator.mutation.ModelType;
import benchmarkdp.datagenerator.mutation.TestFeature;
import benchmarkdp.datagenerator.mutation.TestModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreCodeGenerator implements CodeGeneratorInterface {
  private ModelType modelType = ModelType.PSMLibre;
  
  private String documentName;
  
  private int documentNumber = 0;
  
  private int parag = 0;
  
  private CodeGeneratorObserverInterface cGOb;
  
  public LibreCodeGenerator(final CodeGeneratorObserverInterface cO) {
    this.cGOb = cO;
  }
  
  @Override
  public ModelType getModelType() {
    return this.modelType;
  }
  
  @Override
  public void generateCode(final TestModel tm) {
    TestFeature _testFeature = tm.getTestFeature();
    String _name = _testFeature.getName();
    this.documentName = _name;
    EList<EObject> _modelObjects = tm.getModelObjects();
    EObject _get = _modelObjects.get(0);
    Document d = ((Document) _get);
    String s = this.compile(d);
    tm.setGeneratedCode(s);
    this.cGOb.notify(this.documentName);
  }
  
  public String compile(final Document d) {
    CharSequence _compileDocument = this.compileDocument(d);
    String co = _compileDocument.toString();
    this.documentNumber++;
    return co;
  }
  
  public CharSequence compileDocument(final Document d) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<!DOCTYPE library:libraries PUBLIC \"-//OpenOffice.org//DTD OfficeDocument 1.0//EN\" \"module.dtd\">");
    _builder.newLine();
    _builder.append("<script:module xmlns:script=\"http://openoffice.org/2000/script\" script:name=\"");
    _builder.append(this.documentName, "");
    _builder.append("\" script:language=\"StarBasic\">");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("REM ***** BASIC *****");
    _builder.newLine();
    _builder.append("Sub Main ");
    _builder.newLine();
    _builder.append("Dim Dummy()");
    _builder.newLine();
    _builder.append("Dim Url As String");
    _builder.newLine();
    _builder.append("Dim Doc As Object");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Url = \"private:factory/swriter\"");
    _builder.newLine();
    _builder.append("Doc = StarDesktop.loadComponentFromURL(Url, \"_blank\", 0, Dummy())");
    _builder.newLine();
    _builder.newLine();
    _builder.append("oDoc = ThisComponent");
    _builder.newLine();
    _builder.append("oText = oDoc.getText()");
    _builder.newLine();
    String _compileDocumentElements = this.compileDocumentElements(d);
    _builder.append(_compileDocumentElements, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("Url2 = \"file:///home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Documents/");
    _builder.append(this.documentName, "");
    _builder.append(".odt\"");
    _builder.newLineIfNotEmpty();
    _builder.append("Doc.storeAsURL(Url2, Dummy())");
    _builder.newLine();
    _builder.append("Doc.close(true)");
    _builder.newLine();
    _builder.append("End Sub");
    _builder.newLine();
    _builder.newLine();
    _builder.append("</script:module>");
    _builder.newLine();
    return _builder;
  }
  
  public String compileDocumentElements(final Document d) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    boolean check = false;
    EList<Page> _pages = d.getPages();
    for (final Page p : _pages) {
      {
        if (check) {
          temp = (temp + "");
        }
        String _compilePage = this.compilePage(p);
        String _plus = (temp + _compilePage);
        temp = _plus;
        check = true;
      }
    }
    return temp;
  }
  
  public String compilePage(final Page p) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    EList<Element> _elements = p.getElements();
    for (final Element e : _elements) {
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
    }
    return temp;
  }
  
  public String compileParagraph(final Paragraph par, final boolean inTable) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    if (((this.parag > 1) && (!inTable))) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("oText.InsertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)");
      _builder_1.newLine();
      String _plus = (temp + _builder_1);
      temp = _plus;
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
    _builder.append("\t");
    _builder.newLine();
    _builder.append("oText.insertTextContent(oText.getEnd(), oTable, False)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    String _compileTableElements = this.compileTableElements(t);
    _builder.append(_compileTableElements, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String temp = _builder.toString();
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
    _builder.append("oText.insertString(oText.getStart(), \" ");
    String _value = t.getValue();
    _builder.append(_value, "");
    _builder.append("\", False)");
    _builder.newLineIfNotEmpty();
    String temp = _builder.toString();
    return temp;
  }
}
