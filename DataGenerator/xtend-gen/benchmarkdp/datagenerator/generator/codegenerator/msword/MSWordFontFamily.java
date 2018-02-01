package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.IEnumCompiler;
import benchmarkdp.datagenerator.model.PSMDocx.FontFamily;
import com.google.common.base.Objects;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class MSWordFontFamily extends AbstractElementCompiler implements IEnumCompiler {
  @Override
  public void compile(final Enumerator en, final CompilerState cState) {
    FontFamily f = ((FontFamily) en);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    boolean _equals = Objects.equal(f, FontFamily.TIMESNEWROMAN);
    if (_equals) {
      temp = (temp + "Times New Roman");
    }
    boolean _equals_1 = Objects.equal(f, FontFamily.ARIAL);
    if (_equals_1) {
      temp = (temp + "Arial");
    }
    cState.setVariable("temp", temp);
  }
  
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
