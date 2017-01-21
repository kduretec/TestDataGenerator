package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;
import benchmarkdp.datagenerator.generator.TestModel;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.ModelElementsCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreDocument;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreGeneratedCode;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreImage;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibrePage;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreParagraph;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreSimpleText;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreTable;
import benchmarkdp.datagenerator.model.PSMLibre.Document;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreCodeGenerator implements CodeGeneratorInterface {
  private ModelType modelType = ModelType.PSMLibre;
  
  private CodeGeneratorObserverInterface cGOb;
  
  private ModelElementsCompiler compiler;
  
  private CompilerState compilerState;
  
  public LibreCodeGenerator(final CodeGeneratorObserverInterface cO) {
    this.cGOb = cO;
    CompilerState _compilerState = new CompilerState();
    this.compilerState = _compilerState;
    ModelElementsCompiler _modelElementsCompiler = new ModelElementsCompiler(this.compilerState);
    this.compiler = _modelElementsCompiler;
    LibreDocument _libreDocument = new LibreDocument();
    this.compiler.addCompiler("Document", _libreDocument);
    LibrePage _librePage = new LibrePage();
    this.compiler.addCompiler("Page", _librePage);
    LibreParagraph _libreParagraph = new LibreParagraph();
    this.compiler.addCompiler("Paragraph", _libreParagraph);
    LibreTable _libreTable = new LibreTable();
    this.compiler.addCompiler("Table", _libreTable);
    LibreImage _libreImage = new LibreImage();
    this.compiler.addCompiler("Image", _libreImage);
    LibreSimpleText _libreSimpleText = new LibreSimpleText();
    this.compiler.addCompiler("SimpleText", _libreSimpleText);
  }
  
  @Override
  public ModelType getModelType() {
    return this.modelType;
  }
  
  @Override
  public void generateCode(final TestCase tC) {
    TestModel _testModel = tC.getTestModel();
    EList<EObject> _modelObjects = _testModel.getModelObjects();
    EObject _get = _modelObjects.get(0);
    Document d = ((Document) _get);
    LibreGeneratedCode libreCode = new LibreGeneratedCode(this.cGOb);
    String _documentPlatform = d.getDocumentPlatform();
    libreCode.platform = _documentPlatform;
    this.compilerState.setVariable("libreCode", libreCode);
    String _testCaseName = tC.getTestCaseName();
    this.compilerState.setVariable("documentName", _testCaseName);
    Integer _integer = new Integer(0);
    this.compilerState.setVariable("numCodeLines", _integer);
    Integer _integer_1 = new Integer(0);
    this.compilerState.setVariable("parag", _integer_1);
    this.compiler.compile("Document", d);
    String _helper = this.helper();
    libreCode.addHelperFunction(_helper);
    tC.setGeneratedCode(libreCode);
  }
  
  public String helper() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Sub getLines(numPar, parID, file) ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oTextCursor = ThisComponent.Text.createTextCursor()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("oTextCursor.gotoStart(False)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("oViewCursor = ThisComponent.CurrentController.getViewCursor()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("num = 0");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Do ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("num = num + 1");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("line = 0");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("oTextCursor.gotoStartOfParagraph(False)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("oViewCursor.gotoRange(oTextCursor, False)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("If numPar = num Then\t");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("Do While True ");
    _builder.newLine();
    _builder.append("        \t   \t");
    _builder.append("oViewCursor.gotoEndOfLine(False)");
    _builder.newLine();
    _builder.append("        \t   \t");
    _builder.append("oTextCursor.gotoRange(oViewCursor, True)");
    _builder.newLine();
    _builder.append("        \t   \t");
    _builder.append("line = line + 1");
    _builder.newLine();
    _builder.append("        \t   \t");
    _builder.append("s = parID &amp; \":\" &amp; line &amp; \":\" &amp; oTextCursor.String");
    _builder.newLine();
    _builder.append("        \t   \t");
    _builder.append("Print #file, s");
    _builder.newLine();
    _builder.append("        \t   \t");
    _builder.append("REM MsgBox \"numparh=\" + num + \" numline=\" + line + \" text=\" + oTextCursor.String, 0, \"Lines\"");
    _builder.newLine();
    _builder.append("        \t   \t");
    _builder.append("oTextCursor.collapseToEnd()");
    _builder.newLine();
    _builder.append("        \t   \t");
    _builder.append("If oTextCursor.isEndOfParagraph() Then Exit Do ");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("Loop");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("Exit Do ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("End If");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Loop While oTextCursor.gotoNextParagraph(False)  ");
    _builder.newLine();
    _builder.append("End Sub");
    _builder.newLine();
    String fun = _builder.toString();
    return fun;
  }
}
