package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText;
import benchmarkdp.datagenerator.model.PSMDocx.TableType;
import com.google.common.base.Objects;
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
      Object _variable_3 = cState.getVariable("tableType");
      TableType tableType = ((TableType) _variable_3);
      if ((Objects.equal(tableType, TableType.SMALLNUMBERTABLE) || Objects.equal(tableType, TableType.BIGNUMBERTABLE))) {
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
        _builder_1.append("oSelection.TypeText(\" ");
        String _value_1 = t.getValue();
        _builder_1.append(_value_1, "");
        _builder_1.append(" \")");
        _builder_1.newLineIfNotEmpty();
        String _plus_1 = (temp + _builder_1);
        temp = _plus_1;
      }
    } else {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("oSelection.Font.Size = ");
      _builder_2.append(11, "");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("oSelection.TypeText(\" ");
      String _value_2 = t.getValue();
      _builder_2.append(_value_2, "");
      _builder_2.append(" \")");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("REM oRange.insertAfter(\" ");
      String _value_3 = t.getValue();
      _builder_2.append(_value_3, "");
      _builder_2.append(" \")");
      _builder_2.newLineIfNotEmpty();
      String _plus_2 = (temp + _builder_2);
      temp = _plus_2;
    }
    cState.setVariable("temp", temp);
  }
}
