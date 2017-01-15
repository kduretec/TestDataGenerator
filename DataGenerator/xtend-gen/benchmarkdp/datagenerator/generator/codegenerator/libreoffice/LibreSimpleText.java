package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMLibre.SimpleText;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreSimpleText extends AbstractElementCompiler {
  public String compileSimpleText(final SimpleText t) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("oText.insertString(oText.getEnd(), \" ");
    String _value = t.getValue();
    _builder.append(_value, "");
    _builder.append("\", False)");
    _builder.newLineIfNotEmpty();
    String temp = _builder.toString();
    return temp;
  }
  
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    SimpleText t = ((SimpleText) object);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("oText.insertString(oText.getEnd(), \" ");
    String _value = t.getValue();
    _builder.append(_value, "");
    _builder.append("\", False)");
    _builder.newLineIfNotEmpty();
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
  }
}
