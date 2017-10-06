package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.IEnumCompiler;
import benchmarkdp.datagenerator.model.PSMLibre.Color;
import com.google.common.base.Objects;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class LibreColor extends AbstractElementCompiler implements IEnumCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void compile(final Enumerator en, final CompilerState cState) {
    Color c = ((Color) en);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    temp = (temp + "RGB(");
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
    temp = (temp + ")");
    cState.setVariable("temp", temp);
  }
}
