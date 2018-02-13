package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.msword.MSWordGeneratedCode;
import benchmarkdp.datagenerator.model.PSMDocx.ControlBox;
import benchmarkdp.datagenerator.model.PSMDocx.Element;
import benchmarkdp.datagenerator.model.PSMDocx.EmbeddedExcel;
import benchmarkdp.datagenerator.model.PSMDocx.Image;
import benchmarkdp.datagenerator.model.PSMDocx.Page;
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph;
import benchmarkdp.datagenerator.model.PSMDocx.TextBox;
import benchmarkdp.datagenerator.model.PSMDocx.WordTable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class MSWordPage extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Page p = ((Page) object);
    EList<Element> _elements = p.getElements();
    for (final Element e : _elements) {
      boolean _matched = false;
      if (e instanceof Paragraph) {
        _matched=true;
        this.compiler.compile("Paragraph", e);
      }
      if (!_matched) {
        if (e instanceof ControlBox) {
          _matched=true;
          this.compiler.compile("ControlBox", e);
        }
      }
      if (!_matched) {
        if (e instanceof TextBox) {
          _matched=true;
          this.compiler.compile("TextBox", e);
        }
      }
      if (!_matched) {
        if (e instanceof WordTable) {
          _matched=true;
          this.compiler.compile("Table", e);
        }
      }
      if (!_matched) {
        if (e instanceof EmbeddedExcel) {
          _matched=true;
          this.compiler.compile("EmbeddedExcel", e);
        }
      }
      if (!_matched) {
        if (e instanceof Image) {
          _matched=true;
          this.compiler.compile("Image", e);
        }
      }
    }
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    int _length = temp.length();
    boolean _greaterThan = (_length > 40000);
    if (_greaterThan) {
      Object _variable_1 = cState.getVariable("msWordCode");
      MSWordGeneratedCode mC = ((MSWordGeneratedCode) _variable_1);
      mC.addGeneratedCode(temp);
      cState.setVariable("temp", "");
    }
  }
}
