package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.ControlBox;
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink;
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText;
import benchmarkdp.datagenerator.model.PSMDocx.Text;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MSWordControlBox extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    ControlBox cb = ((ControlBox) object);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("cBox = cBox +1");
    _builder.newLine();
    _builder.append("oSelection.TypeParagraph()");
    _builder.newLine();
    _builder.append("Set oRange = oSelection.Range");
    _builder.newLine();
    _builder.append("oDoc.ContentControls.Add 0, oRange");
    _builder.newLine();
    _builder.append("Set oControl = oDoc.ContentControls(cBox)");
    _builder.newLine();
    _builder.append("oControl.Range.Text = \"");
    _builder.newLine();
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
    EList<Text> _words = cb.getWords();
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
    temp = (temp + "oSelection.Start = oControl.Range.End + 1 \n oSelection.TypeParagraph() \n");
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
