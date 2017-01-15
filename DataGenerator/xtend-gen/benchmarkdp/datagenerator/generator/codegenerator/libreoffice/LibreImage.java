package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMLibre.Image;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreImage extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Image img = ((Image) object);
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
  }
}
