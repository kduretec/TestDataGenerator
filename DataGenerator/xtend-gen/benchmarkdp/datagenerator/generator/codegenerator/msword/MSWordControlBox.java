package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class MSWordControlBox extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field words is undefined for the type ControlBox");
  }
  
  public void compileSimpleText(final SimpleText txt, final CompilerState cState) {
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    String _value = txt.getValue();
    String _plus = ((temp + " ") + _value);
    temp = _plus;
    cState.setVariable("temp", temp);
  }
}
