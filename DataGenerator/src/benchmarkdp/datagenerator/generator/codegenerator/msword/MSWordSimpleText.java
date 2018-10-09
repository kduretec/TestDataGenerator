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
    Object _variable_1 = cState.getVariable("inTable");
    Boolean inTable = ((Boolean) _variable_1);
    Object _variable_2 = cState.getVariable("temp");
    temp = ((String) _variable_2);
    temp = (temp + "\n");
    if ((inTable).booleanValue()) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("oRange.Text =  \" ");
      String _value = t.getValue();
      _builder.append(_value, "");
      _builder.append(" \"");
      _builder.newLineIfNotEmpty();
      String _plus = (temp + _builder);
      temp = _plus;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("oSelection.Font.Size = ");
      _builder_1.append(12, "");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("oSelection.TypeText(\" ");
      String _value_1 = t.getValue();
      _builder_1.append(_value_1, "");
      _builder_1.append(" \")");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("REM oRange.insertAfter(\" ");
      String _value_2 = t.getValue();
      _builder_1.append(_value_2, "");
      _builder_1.append(" \")");
      _builder_1.newLineIfNotEmpty();
      String _plus_1 = (temp + _builder_1);
      temp = _plus_1;
    }
    cState.setVariable("temp", temp);
  }
}
