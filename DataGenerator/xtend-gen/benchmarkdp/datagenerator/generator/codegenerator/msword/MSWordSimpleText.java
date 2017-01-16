package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.Color;
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
    temp = (temp + " oSelection.Font.Color = ");
    cState.setVariable("temp", temp);
    Color _color = t.getColor();
    this.compiler.compile("Color", _color);
    Object _variable_1 = cState.getVariable("temp");
    temp = ((String) _variable_1);
    temp = (temp + "\noSelection.Shading.BackgroundPatternColor = ");
    cState.setVariable("temp", temp);
    Color _background = t.getBackground();
    this.compiler.compile("Color", _background);
    Object _variable_2 = cState.getVariable("temp");
    temp = ((String) _variable_2);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\\noSelection.Font.Size = ");
    int _size = t.getSize();
    _builder.append(_size, "");
    _builder.newLineIfNotEmpty();
    _builder.append("oSelection.TypeText(\" ");
    String _value = t.getValue();
    _builder.append(_value, "");
    _builder.append(" \")\t\t");
    _builder.newLineIfNotEmpty();
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
  }
}
