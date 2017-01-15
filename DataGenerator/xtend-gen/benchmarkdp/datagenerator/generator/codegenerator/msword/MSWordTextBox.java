package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink;
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText;
import benchmarkdp.datagenerator.model.PSMDocx.Text;
import benchmarkdp.datagenerator.model.PSMDocx.TextBox;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MSWordTextBox extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    TextBox tb = ((TextBox) object);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("tBox = tBox + 1");
    _builder.newLine();
    _builder.append("oDoc.Shapes.AddTextbox 1, 80, 100, 500, 32");
    _builder.newLine();
    _builder.append("Set textBox = oDoc.Shapes(tBox)");
    _builder.newLine();
    String _plus = (temp + _builder);
    temp = _plus;
    temp = (temp + "\ntextBox.TextFrame.TextRange.Text = \"");
    cState.setVariable("temp", temp);
    EList<Text> _words = tb.getWords();
    for (final Text txt : _words) {
      boolean _matched = false;
      if (txt instanceof SimpleText) {
        _matched=true;
        this.compileSimpleText(((SimpleText)txt), cState);
      }
      if (!_matched) {
        if (txt instanceof HyperLink) {
          _matched=true;
          this.compiler.compile("HyperLink", txt);
        }
      }
    }
    Object _variable_1 = cState.getVariable("temp");
    temp = ((String) _variable_1);
    temp = (temp + "\"\n");
    cState.setVariable("temp", temp);
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
