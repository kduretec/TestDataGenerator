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
    _builder.append("oControl.Range.Text = \" ");
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
    Object _variable_1 = cState.getVariable("parag");
    Integer paragNum = ((Integer) _variable_1);
    int parag = paragNum.intValue();
    parag = (parag + 1);
    Integer _integer = new Integer(parag);
    cState.setVariable("parag", _integer);
    EList<Text> _text = cb.getText();
    for (final Text txt : _text) {
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
    Object _variable_2 = cState.getVariable("temp");
    temp = ((String) _variable_2);
    temp = (temp + "\"\n");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Call selLines(oControl, \"");
    String _iD = cb.getID();
    _builder_1.append(_iD, "");
    _builder_1.append("\", objWord, objFile)\t\t");
    _builder_1.newLineIfNotEmpty();
    String _plus_1 = (temp + _builder_1);
    temp = _plus_1;
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
