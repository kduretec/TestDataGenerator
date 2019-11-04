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
    Object _variable = cState.getVariable("calcLayout");
    Boolean cl = ((Boolean) _variable);
    boolean _booleanValue = cl.booleanValue();
    if (_booleanValue) {
      this.compileParagSmallDoc(par, cState);
    } else {
      this.compileParagBigDoc(par, cState);
    }
  }
  
  public void compileParagSmallDoc(final Paragraph par, final CompilerState cState) {
    Object _variable = cState.getVariable("parag");
    Integer paragNum = ((Integer) _variable);
    int parag = paragNum.intValue();
    Object _variable_1 = cState.getVariable("inTable");
    Boolean inTable = ((Boolean) _variable_1);
    Boolean _boolean = new Boolean(false);
    cState.setVariable("oneTextEl", _boolean);
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
      _builder_1.append("oDoc.Paragraphs(oDoc.Paragraphs.Count).Range.Select");
      _builder_1.newLine();
      _builder_1.append("oDoc.Paragraphs.Last.Range.Select");
      _builder_1.newLine();
      _builder_1.append("REM Set oRange = oDoc.Paragraphs.Last.Range");
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
    }
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
    if ((!(inTable).booleanValue())) {
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Call selLines(oSelection.Paragraphs.Last, \"");
      String _iD = par.getID();
      _builder_4.append(_iD, "");
      _builder_4.append("\", objWord, objFile)");
      _builder_4.newLineIfNotEmpty();
      String _plus_4 = (temp + _builder_4);
      temp = _plus_4;
    }
    cState.setVariable("temp", temp);
  }
  
  public void compileParagBigDoc(final Paragraph par, final CompilerState cState) {
    Object _variable = cState.getVariable("parag");
    Integer paragNum = ((Integer) _variable);
    int parag = paragNum.intValue();
    Object _variable_1 = cState.getVariable("inTable");
    Boolean inTable = ((Boolean) _variable_1);
    Boolean _boolean = new Boolean(false);
    cState.setVariable("oneTextEl", _boolean);
    Object _variable_2 = cState.getVariable("temp");
    String temp = ((String) _variable_2);
    if (((parag > 0) && (!(inTable).booleanValue()))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("oSelection.TypeParagraph()");
      _builder.newLine();
      _builder.append("REM oDoc.Paragraphs.Add");
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
      _builder_1.append("REM oDoc.Paragraphs.Last.Range.Select");
      _builder_1.newLine();
      _builder_1.append("Set oRange = oDoc.Paragraphs.Last.Range");
      _builder_1.newLine();
      _builder_1.append("REM oSelection.ParagraphFormat.Shading.BackgroundPatternColor = ");
      String _plus_1 = (temp + _builder_1);
      temp = _plus_1;
      cState.setVariable("temp", temp);
      Color _backgroundColor = par.getBackgroundColor();
      this.compiler.compile("Color", _backgroundColor);
      Object _variable_3 = cState.getVariable("temp");
      temp = ((String) _variable_3);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("REM oSelection.Font.Color = ");
      String _plus_2 = (temp + _builder_2);
      temp = _plus_2;
      cState.setVariable("temp", temp);
      Color _fontColor = par.getFontColor();
      this.compiler.compile("Color", _fontColor);
      Object _variable_4 = cState.getVariable("temp");
      temp = ((String) _variable_4);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("REM oSelection.Font.Name = ");
      String _plus_3 = (temp + _builder_3);
      temp = _plus_3;
      cState.setVariable("temp", temp);
      FontFamily _fontFamily = par.getFontFamily();
      this.compiler.compile("FontFamily", _fontFamily);
      Object _variable_5 = cState.getVariable("temp");
      temp = ((String) _variable_5);
    }
    Integer _integer = new Integer(parag);
    cState.setVariable("parag", _integer);
    EList<Text> _text = par.getText();
    int _size = _text.size();
    boolean _equals = (_size == 1);
    if (_equals) {
      Boolean _boolean_1 = new Boolean(true);
      cState.setVariable("oneTextEl", _boolean_1);
    }
    EList<Text> _text_1 = par.getText();
    for (final Text txt : _text_1) {
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
    Boolean _boolean_2 = new Boolean(false);
    cState.setVariable("oneTextEl", _boolean_2);
  }
}
