package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.IEnumCompiler;
import benchmarkdp.datagenerator.model.PSMLibre.FontFamily;
import com.google.common.base.Objects;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class LibreFontFamily extends AbstractElementCompiler implements IEnumCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void compile(final Enumerator en, final CompilerState cState) {
    FontFamily f = ((FontFamily) en);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    boolean _equals = Objects.equal(f, FontFamily.LIBERATIONMONO);
    if (_equals) {
      temp = (temp + "\"Liberation Mono\"");
    }
    boolean _equals_1 = Objects.equal(f, FontFamily.LIBERATIONSERIF);
    if (_equals_1) {
      temp = (temp + "\"Liberation Serif\"");
    }
    cState.setVariable("temp", temp);
  }
}
