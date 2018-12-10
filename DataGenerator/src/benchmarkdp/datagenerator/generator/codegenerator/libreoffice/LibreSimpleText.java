package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMLibre.TableType;
import benchmarkdp.datagenerator.model.PSMLibre.Text;
import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreSimpleText extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Text t = ((Text) object);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    Object _variable_1 = cState.getVariable("inTable");
    Boolean inTable = ((Boolean) _variable_1);
    Object _variable_2 = cState.getVariable("tableType");
    TableType tableType = ((TableType) _variable_2);
    if ((!(inTable).booleanValue())) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("oText.insertString(oText.getEnd(), \" ");
      String _value = t.getValue();
      _builder.append(_value, "");
      _builder.append("\", False)");
      _builder.newLineIfNotEmpty();
      String _plus = (temp + _builder);
      temp = _plus;
    } else {
      if (((inTable).booleanValue() && (Objects.equal(tableType, TableType.ONECOLUMNTABLE) || Objects.equal(tableType, TableType.TEXTTABLE)))) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("oTextTable.insertString(oTextTable.getEnd(), \" ");
        String _value_1 = t.getValue();
        _builder_1.append(_value_1, "");
        _builder_1.append("\", False)");
        _builder_1.newLineIfNotEmpty();
        String _plus_1 = (temp + _builder_1);
        temp = _plus_1;
      } else {
        String _value_2 = t.getValue();
        String _plus_2 = (temp + _value_2);
        temp = _plus_2;
      }
    }
    cState.setVariable("temp", temp);
  }
}
