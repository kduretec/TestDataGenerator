package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MSWordSimpleText extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    SimpleText t = ((SimpleText) object);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    Object _variable_1 = cState.getVariable("temp");
    temp = ((String) _variable_1);
    temp = (temp + "\n");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("REM oSelection.Font.Size = ");
    _builder.append(12, "");
    _builder.newLineIfNotEmpty();
    _builder.append("REM oSelection.TypeText(\" ");
    String _value = t.getValue();
    _builder.append(_value, "");
    _builder.append(" \")");
    _builder.newLineIfNotEmpty();
    _builder.append("oRange.Text =  \" ");
    String _value_1 = t.getValue();
    _builder.append(_value_1, "");
    _builder.append(" \"");
    _builder.newLineIfNotEmpty();
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
  }
}
