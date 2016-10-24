package benchmarkdp.datagenerator.mutation;

import benchmarkdp.datagenerator.model.PSMLibre.Document;
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
}
