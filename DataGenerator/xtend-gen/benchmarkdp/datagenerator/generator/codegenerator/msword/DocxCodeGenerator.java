package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;
import benchmarkdp.datagenerator.generator.TestModel;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.ModelElementsCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.msword.MSWordGeneratedCode;
import benchmarkdp.datagenerator.model.PSMDocx.Color;
import benchmarkdp.datagenerator.model.PSMDocx.Document;
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink;
import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

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
    String _documentPlatform = d.getDocumentPlatform();
    MSWordGeneratedCode sCode = new MSWordGeneratedCode("vbs", _documentPlatform);
    String _string = new String("");
    this.compilerState.setVariable("temp", _string);
    this.compiler.compile("Document", d);
    Object _variable = this.compilerState.getVariable("temp");
    String s = ((String) _variable);
    sCode.generatedCode = s;
    tC.setGeneratedCode(sCode);
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
