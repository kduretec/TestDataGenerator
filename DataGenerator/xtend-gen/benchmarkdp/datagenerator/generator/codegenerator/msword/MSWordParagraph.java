package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink;
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph;
import benchmarkdp.datagenerator.model.PSMDocx.SimpleText;
import benchmarkdp.datagenerator.model.PSMDocx.Text;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MSWordParagraph extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Paragraph par = ((Paragraph) object);
    Object _variable = cState.getVariable("parag");
    Integer paragNum = ((Integer) _variable);
    int parag = paragNum.intValue();
    Object _variable_1 = cState.getVariable("inTable");
    Boolean inTable = ((Boolean) _variable_1);
    Object _variable_2 = cState.getVariable("temp");
    String temp = ((String) _variable_2);
    if (((parag > 0) && (!(inTable).booleanValue()))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("oSelection.TypeParagraph()");
      _builder.newLine();
      String _plus = (temp + _builder);
      temp = _plus;
      cState.setVariable("temp", temp);
    }
    parag = (parag + 1);
    Integer _integer = new Integer(parag);
    cState.setVariable("parag", _integer);
    EList<Text> _text = par.getText();
    for (final Text txt : _text) {
      boolean _matched = false;
      if (txt instanceof SimpleText) {
        _matched=true;
        this.compiler.compile("SimpleText", txt);
      }
      if (!_matched) {
        if (txt instanceof HyperLink) {
          _matched=true;
          this.compiler.compile("HyperLink", txt);
        }
      }
    }
    Object _variable_3 = cState.getVariable("temp");
    temp = ((String) _variable_3);
    if ((!(inTable).booleanValue())) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Call selLines(oDoc.Paragraphs(oDoc.Paragraphs.Count), \"");
      String _iD = par.getID();
      _builder_1.append(_iD, "");
      _builder_1.append("\", objWord, objFile)");
      _builder_1.newLineIfNotEmpty();
      String _plus_1 = (temp + _builder_1);
      temp = _plus_1;
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("i = i + 1");
    _builder_2.newLine();
    String _plus_2 = (temp + _builder_2);
    temp = _plus_2;
    cState.setVariable("temp", temp);
  }
}
