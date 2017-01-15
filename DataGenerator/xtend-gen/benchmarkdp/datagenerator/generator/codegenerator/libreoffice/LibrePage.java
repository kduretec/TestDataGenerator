package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreGeneratedCode;
import benchmarkdp.datagenerator.model.PSMLibre.Element;
import benchmarkdp.datagenerator.model.PSMLibre.Image;
import benchmarkdp.datagenerator.model.PSMLibre.Page;
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph;
import benchmarkdp.datagenerator.model.PSMLibre.Table;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class LibrePage extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Page p = ((Page) object);
    EList<Element> _elements = p.getElements();
    for (final Element e : _elements) {
      {
        boolean _matched = false;
        if (e instanceof Paragraph) {
          _matched=true;
          this.compiler.compile("Paragraph", e);
        }
        if (!_matched) {
          if (e instanceof Table) {
            _matched=true;
            this.compiler.compile("Table", e);
          }
        }
        if (!_matched) {
          if (e instanceof Image) {
            _matched=true;
            this.compiler.compile("Image", e);
          }
        }
        Object _variable = cState.getVariable("temp");
        String temp = ((String) _variable);
        int _length = temp.length();
        boolean _greaterThan = (_length > 40000);
        if (_greaterThan) {
          Object _variable_1 = cState.getVariable("libreCode");
          LibreGeneratedCode lC = ((LibreGeneratedCode) _variable_1);
          lC.addCodeElement(temp);
          cState.setVariable("temp", "");
        }
      }
    }
  }
}
