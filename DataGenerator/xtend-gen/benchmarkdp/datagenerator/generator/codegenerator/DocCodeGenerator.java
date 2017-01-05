package benchmarkdp.datagenerator.generator.codegenerator;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestFeature;
import benchmarkdp.datagenerator.generator.TestModel;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface;
import benchmarkdp.datagenerator.model.PSMDoc.Cell;
import benchmarkdp.datagenerator.model.PSMDoc.Color;
import benchmarkdp.datagenerator.model.PSMDoc.Document;
import benchmarkdp.datagenerator.model.PSMDoc.Element;
import benchmarkdp.datagenerator.model.PSMDoc.HyperLink;
import benchmarkdp.datagenerator.model.PSMDoc.Image;
import benchmarkdp.datagenerator.model.PSMDoc.Page;
import benchmarkdp.datagenerator.model.PSMDoc.Paragraph;
import benchmarkdp.datagenerator.model.PSMDoc.Row;
import benchmarkdp.datagenerator.model.PSMDoc.SimpleText;
import benchmarkdp.datagenerator.model.PSMDoc.Table;
import benchmarkdp.datagenerator.model.PSMDoc.Text;
import benchmarkdp.datagenerator.model.PSMDoc.TextBox;
import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class DocCodeGenerator implements CodeGeneratorInterface {
  private ModelType modelType = ModelType.PSMDoc;
  
  private int parag = 1;
  
  private int documentNumber = 0;
  
  private String documentName;
  
  public DocCodeGenerator() {
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
    _builder.append("oDoc.SaveAs \"c:\\Users\\Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\benchmarking\\publications\\JSS\\Generated\\Documents\\");
    _builder.append(this.documentName, "");
    _builder.append("_");
    _builder.append(this.modelType, "");
    _builder.append("_");
    String _documentFormat = d.getDocumentFormat();
    _builder.append(_documentFormat, "");
    _builder.append("_");
    String _documentPlatform = d.getDocumentPlatform();
    _builder.append(_documentPlatform, "");
    _builder.append(".");
    String _documentFormat_1 = d.getDocumentFormat();
    _builder.append(_documentFormat_1, "");
    _builder.append("\", ");
    String _documentFormatCode = d.getDocumentFormatCode();
    _builder.append(_documentFormatCode, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("grFile = \"c:\\Users\\Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\benchmarking\\publications\\JSS\\Generated\\GroundTruth\\");
    _builder.append(this.documentName, "");
    _builder.append("_");
    _builder.append(this.modelType, "");
    _builder.append("_");
    String _documentFormat_2 = d.getDocumentFormat();
    _builder.append(_documentFormat_2, "");
    _builder.append("_");
    String _documentPlatform_1 = d.getDocumentPlatform();
    _builder.append(_documentPlatform_1, "");
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
        _switchResult = this.compileParagraph(((Paragraph)e), false);
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
        _switchResult = this.compileSimpleText(((SimpleText)txt));
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
    String _compileTableElements = this.compileTableElements(t);
    _builder.append(_compileTableElements, "");
    _builder.newLineIfNotEmpty();
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
  
  public String compileTableElements(final Table t) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    for (int i = 1; (i <= t.getNumRows()); i++) {
      for (int j = 1; (j <= t.getNumCol()); j++) {
        {
          temp = (((((temp + "objTable.Cell(") + Integer.valueOf(i)) + ",") + Integer.valueOf(j)) + ").Select\n");
          EList<Row> _row = t.getRow();
          Row _get = _row.get((i - 1));
          EList<Cell> _cell = _get.getCell();
          Cell _get_1 = _cell.get((j - 1));
          EList<Element> _elements = _get_1.getElements();
          for (final Element e : _elements) {
            String _switchResult = null;
            boolean _matched = false;
            if (e instanceof Paragraph) {
              _matched=true;
              _switchResult = this.compileParagraph(((Paragraph)e), true);
            }
            String _plus = (temp + _switchResult);
            temp = _plus;
          }
        }
      }
    }
    return temp;
  }
  
  public String compileImage(final Image img) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      String temp = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Set oImg = oSelection.InlineShapes.AddPicture(\"c:\\Users\\Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\benchmarking\\publications\\JSS\\Generated\\Macro\\Images\\Desert.jpg\")");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("oImg.Height = ");
      int _height = img.getHeight();
      _builder_1.append(_height, "\t\t");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t\t");
      _builder_1.append("oImg.Width = ");
      int _width = img.getWidth();
      _builder_1.append(_width, "\t\t");
      _builder_1.newLineIfNotEmpty();
      String _plus = (temp + _builder_1);
      _xblockexpression = temp = _plus;
    }
    return _xblockexpression;
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
  
  public String compileSimpleText(final SimpleText t) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("oSelection.Font.Color = ");
    Color _color = t.getColor();
    String _compileColor = this.compileColor(_color);
    _builder.append(_compileColor, "");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("oSelection.Shading.BackgroundPatternColor =");
    Color _background = t.getBackground();
    String _compileColor_1 = this.compileColor(_background);
    _builder.append(_compileColor_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("oSelection.Font.Size = ");
    int _size = t.getSize();
    _builder.append(_size, "");
    _builder.newLineIfNotEmpty();
    _builder.append("oSelection.TypeText(\" ");
    String _value = t.getValue();
    _builder.append(_value, "");
    _builder.append(" \")");
    _builder.newLineIfNotEmpty();
    String temp = _builder.toString();
    return temp;
  }
  
  public String compileColor(final Color c) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("RGB(");
      String temp = _builder.toString();
      boolean _equals = Objects.equal(c, Color.BLACK);
      if (_equals) {
        temp = (temp + "0,0,0");
      }
      boolean _equals_1 = Objects.equal(c, Color.WHITE);
      if (_equals_1) {
        temp = (temp + "255,255,255");
      }
      boolean _equals_2 = Objects.equal(c, Color.RED);
      if (_equals_2) {
        temp = (temp + "255,0,0");
      }
      boolean _equals_3 = Objects.equal(c, Color.BLUE);
      if (_equals_3) {
        temp = (temp + "0,0,255");
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(")");
      String _plus = (temp + _builder_1);
      _xblockexpression = temp = _plus;
    }
    return _xblockexpression;
  }
}
