package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.ModelElementsCompiler;
import benchmarkdp.datagenerator.model.PSMDocx.Document;
import benchmarkdp.datagenerator.core.ModelType;
import benchmarkdp.datagenerator.core.TestCase;
import benchmarkdp.datagenerator.core.TestModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class DocxCodeGenerator implements CodeGeneratorInterface {
  private ModelType modelType = ModelType.PSMDocx;
  
  private ModelElementsCompiler compiler;
  
  private CompilerState compilerState;
  
  public DocxCodeGenerator() {
    CompilerState _compilerState = new CompilerState();
    this.compilerState = _compilerState;
    ModelElementsCompiler _modelElementsCompiler = new ModelElementsCompiler(this.compilerState);
    this.compiler = _modelElementsCompiler;
    MSWordDocument _mSWordDocument = new MSWordDocument();
    this.compiler.addCompiler("Document", _mSWordDocument);
    MSWordPage _mSWordPage = new MSWordPage();
    this.compiler.addCompiler("Page", _mSWordPage);
    MSWordParagraph _mSWordParagraph = new MSWordParagraph();
    this.compiler.addCompiler("Paragraph", _mSWordParagraph);
    MSWordTextBox _mSWordTextBox = new MSWordTextBox();
    this.compiler.addCompiler("TextBox", _mSWordTextBox);
    MSWordControlBox _mSWordControlBox = new MSWordControlBox();
    this.compiler.addCompiler("ControlBox", _mSWordControlBox);
    MSWordTable _mSWordTable = new MSWordTable();
    this.compiler.addCompiler("Table", _mSWordTable);
    MSWordImage _mSWordImage = new MSWordImage();
    this.compiler.addCompiler("Image", _mSWordImage);
    MSWordSimpleText _mSWordSimpleText = new MSWordSimpleText();
    this.compiler.addCompiler("SimpleText", _mSWordSimpleText);
    MSWordHyperLink _mSWordHyperLink = new MSWordHyperLink();
    this.compiler.addCompiler("HyperLink", _mSWordHyperLink);
    MSWordColor _mSWordColor = new MSWordColor();
    this.compiler.addCompiler("Color", _mSWordColor);
    MSWordEmbeddedExcel _mSWordEmbeddedExcel = new MSWordEmbeddedExcel();
    this.compiler.addCompiler("EmbeddedExcel", _mSWordEmbeddedExcel);
    MSWordFontFamily _mSWordFontFamily = new MSWordFontFamily();
    this.compiler.addCompiler("FontFamily", _mSWordFontFamily);
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
    String _testCaseName = tC.getTestCaseName();
    this.compilerState.setVariable("documentName", _testCaseName);
    Integer _integer = new Integer(0);
    this.compilerState.setVariable("parag", _integer);
    Boolean _boolean = new Boolean(false);
    this.compilerState.setVariable("inTable", _boolean);
    Integer _integer_1 = new Integer(0);
    this.compilerState.setVariable("inlineShape", _integer_1);
    String _operatingSystem = d.getOperatingSystem();
    String _software = d.getSoftware();
    MSWordGeneratedCode sCode = new MSWordGeneratedCode("vbs", _operatingSystem, _software);
    String _string = new String("");
    this.compilerState.setVariable("temp", _string);
    this.compilerState.setVariable("msWordCode", sCode);
    Boolean _boolean_1 = new Boolean(false);
    this.compilerState.setVariable("calcLayout", _boolean_1);
    this.compiler.compile("Document", d);
    Object _variable = this.compilerState.getVariable("temp");
    String s = ((String) _variable);
    sCode.addGeneratedCode(s);
    tC.setGeneratedCode(sCode);
  }
  
  @Override
  public void addCodeGeneratorObserver(final CodeGeneratorObserverInterface cgo) {
  }
}
