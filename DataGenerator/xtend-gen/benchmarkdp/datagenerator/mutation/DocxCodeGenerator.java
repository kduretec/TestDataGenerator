package benchmarkdp.datagenerator.mutation;

import benchmarkdp.datagenerator.model.PSMDocx.Document;
import benchmarkdp.datagenerator.model.PSMDocx.Element;
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink;
import benchmarkdp.datagenerator.model.PSMDocx.Page;
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph;
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText;
import benchmarkdp.datagenerator.model.PSMDocx.Table;
import benchmarkdp.datagenerator.model.PSMDocx.Text;
import benchmarkdp.datagenerator.model.PSMDocx.TextBox;
import benchmarkdp.datagenerator.mutation.CodeGeneratorInterface;
import benchmarkdp.datagenerator.mutation.ModelType;
import benchmarkdp.datagenerator.mutation.TestModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class DocxCodeGenerator implements CodeGeneratorInterface {
  private ModelType modelType = ModelType.PSMDocx;
  
  private int parag = 1;
  
  private int documentNumber = 0;
  
  public DocxCodeGenerator() {
  }
  
  @Override
  public ModelType getModelType() {
    return this.modelType;
  }
  
  @Override
  public void generateCode(final TestModel tm) {
    EList<EObject> _modelObjects = tm.getModelObjects();
    EObject _get = _modelObjects.get(0);
    Document d = ((Document) _get);
    String s = this.compile(d);
    tm.setGeneratedCode(s);
  }
  
  public String compile(final Document d) {
    CharSequence _compileDocument = this.compileDocument(d);
    String co = _compileDocument.toString();
    this.documentNumber++;
    return co;
  }
  
  public CharSequence compileDocument(final Document d) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("Const END_OF_STORY = 6 ");
    _builder.newLine();
    _builder.append("Set objWord = CreateObject(\"Word.Application\") ");
    _builder.newLine();
    _builder.append("objWord.Visible = True ");
    _builder.newLine();
    _builder.append("Set oDoc = objWord.Documents.Add()");
    _builder.newLine();
    _builder.append("oDoc.PageSetup.TextColumns.SetCount(");
    int _numColum = d.getNumColum();
    _builder.append(_numColum, "");
    _builder.append(") ");
    _builder.newLineIfNotEmpty();
    _builder.append("Set oSelection = objWord.Selection ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("i = 1 ");
    _builder.newLine();
    _builder.append("tableIndex = 1");
    _builder.newLine();
    _builder.append("tBox = 0");
    _builder.newLine();
    String _compileDocumentElements = this.compileDocumentElements(d);
    _builder.append(_compileDocumentElements, "");
    _builder.newLineIfNotEmpty();
    _builder.append("oDoc.SaveAs \"c:\\Users\\Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\benchmarking\\publications\\JSS\\Generated\\Documents\\Document");
    _builder.append(this.documentNumber, "");
    _builder.append(".");
    String _format = d.getFormat();
    _builder.append(_format, "");
    _builder.append("\", ");
    String _formatCode = d.getFormatCode();
    _builder.append(_formatCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("grFile = \"c:\\Users\\Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\benchmarking\\publications\\JSS\\Generated\\GroundTruth\\Document");
    _builder.append(this.documentNumber, "");
    _builder.append("-wordgroundtruth.txt\" ");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("Set objFSO = CreateObject(\"Scripting.FileSystemObject\")");
    _builder.newLine();
    _builder.append("Set objFile = objFSO.CreateTextFile(grFile, True)");
    _builder.newLine();
    _builder.append("objFile.Write \"pagecount \" & oDoc.ComputeStatistics(2) & vbCrLf");
    _builder.newLine();
    _builder.append("objFile.Write \"wordcount \" & oDoc.ComputeStatistics(0) & vbCrLf");
    _builder.newLine();
    _builder.append("objFile.Write \"paragraphcount \" & oDoc.ComputeStatistics(4)");
    _builder.newLine();
    _builder.append("oDoc.Saved = TRUE");
    _builder.newLine();
    _builder.append("objFile.Close()");
    _builder.newLine();
    _builder.append("objWord.Quit");
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
          temp = (temp + "oSelection.InsertBreak(7)\n");
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
        _switchResult = this.compileParagraph(((Paragraph)e));
      }
      if (!_matched) {
        if (e instanceof TextBox) {
          _matched=true;
          _switchResult = this.compileTextBox(((TextBox)e));
        }
      }
      if (!_matched) {
        if (e instanceof Table) {
          _matched=true;
          _switchResult = this.compileTable(((Table)e));
        }
      }
      String _plus = (temp + _switchResult);
      temp = _plus;
    }
    return temp;
  }
  
  public String compileParagraph(final Paragraph par) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    if ((this.parag > 1)) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("oSelection.TypeParagraph()");
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
        String _value = ((SimpleText)txt).getValue();
        String _plus_1 = (" oSelection.TypeText(\" " + _value);
        _switchResult = (_plus_1 + "\")\n");
      }
      if (!_matched) {
        if (txt instanceof HyperLink) {
          _matched=true;
          _switchResult = this.compileHyperLink(((HyperLink)txt));
        }
      }
      String _plus_1 = (temp + _switchResult);
      temp = _plus_1;
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("i = i + 1");
    _builder_2.newLine();
    String _plus_2 = (temp + _builder_2);
    temp = _plus_2;
    return temp;
  }
  
  public String compileTextBox(final TextBox tb) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("tBox = tBox + 1");
    _builder.newLine();
    _builder.append("oDoc.Shapes.AddTextbox 1, 80, 100, 500, 32");
    _builder.newLine();
    _builder.append("Set textBox = oDoc.Shapes(tBox)");
    String temp = _builder.toString();
    temp = (temp + "\ntextBox.TextFrame.TextRange.Text = \"");
    EList<Text> _words = tb.getWords();
    for (final Text txt : _words) {
      String _switchResult = null;
      boolean _matched = false;
      if (txt instanceof SimpleText) {
        _matched=true;
        String _value = ((SimpleText)txt).getValue();
        _switchResult = (" " + _value);
      }
      if (!_matched) {
        if (txt instanceof HyperLink) {
          _matched=true;
          _switchResult = this.compileHyperLink(((HyperLink)txt));
        }
      }
      String _plus = (temp + _switchResult);
      temp = _plus;
    }
    temp = (temp + "\"\n");
    return temp;
  }
  
  public String compileTable(final Table t) {
    int numR = t.getNumRows();
    int numC = t.getNumCol();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("oSelection.TypeParagraph()");
    _builder.newLine();
    _builder.append("Set oRange = oSelection.Range");
    _builder.newLine();
    _builder.append("oDoc.Tables.Add oRange, ");
    _builder.append(numR, "");
    _builder.append(", ");
    _builder.append(numC, "");
    _builder.newLineIfNotEmpty();
    _builder.append("Set objTable = oDoc.Tables(tableIndex)");
    _builder.newLine();
    _builder.append("objTable.AutoFormat(16)");
    _builder.newLine();
    _builder.append("tableIndex = tableIndex + 1");
    _builder.newLine();
    _builder.append("oSelection.EndKey END_OF_STORY");
    _builder.newLine();
    _builder.append("oSelection.TypeParagraph()");
    _builder.newLine();
    _builder.append("i= i + 1");
    _builder.newLine();
    String temp = _builder.toString();
    return temp;
  }
  
  public String compileHyperLink(final HyperLink h) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set oRange = oSelection.Range");
    _builder.newLine();
    _builder.append("oDoc.Hyperlinks.Add oRange, \"");
    String _url = h.getUrl();
    _builder.append(_url, "");
    _builder.append("\", , , \" ");
    String _value = h.getValue();
    _builder.append(_value, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    String temp = _builder.toString();
    return temp;
  }
}
