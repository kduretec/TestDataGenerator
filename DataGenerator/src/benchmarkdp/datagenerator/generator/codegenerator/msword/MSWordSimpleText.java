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
    Object _variable_2 = cState.getVariable("calcLayout");
    Boolean cl = ((Boolean) _variable_2);
    Object _variable_3 = cState.getVariable("temp");
    temp = ((String) _variable_3);
    temp = (temp + "\n");
    if ((inTable).booleanValue()) {
      Object _variable_4 = cState.getVariable("tableType");
      TableType tableType = ((TableType) _variable_4);
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
      boolean _booleanValue = cl.booleanValue();
      if (_booleanValue) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("REM oSelection.Font.Size = ");
        _builder_2.append(11, "");
        _builder_2.newLineIfNotEmpty();
        _builder_2.append("oSelection.TypeText(\" ");
        String _value_2 = t.getValue();
        _builder_2.append(_value_2, "");
        _builder_2.append(" \")");
        _builder_2.newLineIfNotEmpty();
        String _plus_2 = (temp + _builder_2);
        temp = _plus_2;
      } else {
        Object _variable_5 = cState.getVariable("oneTextEl");
        Boolean oneTexEl = ((Boolean) _variable_5);
        boolean _booleanValue_1 = oneTexEl.booleanValue();
        if (_booleanValue_1) {
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("REM oSelection.Font.Size = ");
          _builder_3.append(11, "");
          _builder_3.newLineIfNotEmpty();
          _builder_3.append("REM oSelection.TypeText(\" ");
          String _value_3 = t.getValue();
          _builder_3.append(_value_3, "");
          _builder_3.append(" \")");
          _builder_3.newLineIfNotEmpty();
          _builder_3.append("oRange.Text = \" ");
          String _value_4 = t.getValue();
          _builder_3.append(_value_4, "");
          _builder_3.append(" \"");
          _builder_3.newLineIfNotEmpty();
          String _plus_3 = (temp + _builder_3);
          temp = _plus_3;
        } else {
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("oSelection.Font.Size = ");
          _builder_4.append(11, "");
          _builder_4.newLineIfNotEmpty();
          _builder_4.append("REM oSelection.TypeText(\" ");
          String _value_5 = t.getValue();
          _builder_4.append(_value_5, "");
          _builder_4.append(" \")");
          _builder_4.newLineIfNotEmpty();
          _builder_4.append("oRange.insertAfter(\" ");
          String _value_6 = t.getValue();
          _builder_4.append(_value_6, "");
          _builder_4.append(" \")");
          _builder_4.newLineIfNotEmpty();
          String _plus_4 = (temp + _builder_4);
          temp = _plus_4;
        }
      }
    }
    cState.setVariable("temp", temp);
  }
}
