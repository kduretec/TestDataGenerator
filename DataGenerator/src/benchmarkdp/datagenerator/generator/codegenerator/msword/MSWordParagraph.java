package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.Color;
import benchmarkdp.datagenerator.model.PSMDocx.FontFamily;
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
    if ((!(inTable).booleanValue())) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("REM oDoc.Paragraphs(oDoc.Paragraphs.Count).Range.Select");
      _builder_1.newLine();
      _builder_1.append("oDoc.Paragraphs.Last.Range.Select");
      _builder_1.newLine();
      _builder_1.append("oSelection.ParagraphFormat.Shading.BackgroundPatternColor = ");
      String _plus_1 = (temp + _builder_1);
      temp = _plus_1;
      cState.setVariable("temp", temp);
      Color _backgroundColor = par.getBackgroundColor();
      this.compiler.compile("Color", _backgroundColor);
      Object _variable_3 = cState.getVariable("temp");
      temp = ((String) _variable_3);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("oSelection.Font.Color = ");
      String _plus_2 = (temp + _builder_2);
      temp = _plus_2;
      cState.setVariable("temp", temp);
      Color _fontColor = par.getFontColor();
      this.compiler.compile("Color", _fontColor);
    }
    Object _variable_4 = cState.getVariable("temp");
    temp = ((String) _variable_4);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("oSelection.Font.Name = ");
    String _plus_3 = (temp + _builder_3);
    temp = _plus_3;
    cState.setVariable("temp", temp);
    FontFamily _fontFamily = par.getFontFamily();
    this.compiler.compile("FontFamily", _fontFamily);
    Object _variable_5 = cState.getVariable("temp");
    temp = ((String) _variable_5);
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
    Object _variable_6 = cState.getVariable("temp");
    temp = ((String) _variable_6);
    Object _variable_7 = cState.getVariable("calcLayout");
    Boolean cl = ((Boolean) _variable_7);
    if ((!(inTable).booleanValue())) {
      if ((cl).booleanValue()) {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("REM Call selLines(oDoc.Paragraphs(oDoc.Paragraphs.Count), \"");
        String _iD = par.getID();
        _builder_4.append(_iD, "");
        _builder_4.append("\", objWord, objFile)");
        _builder_4.newLineIfNotEmpty();
        _builder_4.append("Call selLines(oSelection.Paragraphs.Last, \"");
        String _iD_1 = par.getID();
        _builder_4.append(_iD_1, "");
        _builder_4.append("\", objWord, objFile)");
        _builder_4.newLineIfNotEmpty();
        String _plus_4 = (temp + _builder_4);
        temp = _plus_4;
      }
    }
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("i = i + 1");
    _builder_5.newLine();
    String _plus_5 = (temp + _builder_5);
    temp = _plus_5;
    cState.setVariable("temp", temp);
  }
}
