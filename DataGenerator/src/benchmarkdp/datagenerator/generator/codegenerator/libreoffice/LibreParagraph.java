package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreGeneratedCode;
import benchmarkdp.datagenerator.model.PSMLibre.Color;
import benchmarkdp.datagenerator.model.PSMLibre.FontFamily;
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph;
import benchmarkdp.datagenerator.model.PSMLibre.TableType;
import benchmarkdp.datagenerator.model.PSMLibre.Text;
import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreParagraph extends AbstractElementCompiler {
  public String compile(final Paragraph par, final boolean inTable) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    return temp;
  }
  
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Paragraph par = ((Paragraph) object);
    Object _variable = cState.getVariable("parag");
    Integer numPar = ((Integer) _variable);
    Object _variable_1 = cState.getVariable("inTable");
    Boolean inTable = ((Boolean) _variable_1);
    int parag = numPar.intValue();
    Object _variable_2 = cState.getVariable("temp");
    String temp = ((String) _variable_2);
    Object _variable_3 = cState.getVariable("tableType");
    TableType tableType = ((TableType) _variable_3);
    if ((!(inTable).booleanValue())) {
      String tempBack = temp;
      temp = "";
      cState.setVariable("temp", temp);
      Color _backgroundColor = par.getBackgroundColor();
      this.compiler.compile("Color", _backgroundColor);
      Object _variable_4 = cState.getVariable("temp");
      String col = ((String) _variable_4);
      temp = "";
      cState.setVariable("temp", temp);
      FontFamily _fontFamily = par.getFontFamily();
      this.compiler.compile("FontFamily", _fontFamily);
      Object _variable_5 = cState.getVariable("temp");
      String font = ((String) _variable_5);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("oCur = ThisComponent.CurrentController.getViewCursor()");
      _builder.newLine();
      _builder.append("oCur.ParaStyleName  = getParagraphStyleName(");
      _builder.append(col, "");
      _builder.append(",");
      _builder.append(font, "");
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      String _plus = (tempBack + _builder);
      temp = _plus;
    }
    cState.setVariable("temp", temp);
    if ((!(inTable).booleanValue())) {
      parag = (parag + 1);
    }
    if (((inTable).booleanValue() && (Objects.equal(tableType, TableType.ONECOLUMNTABLE) || Objects.equal(tableType, TableType.TEXTTABLE)))) {
      Object _variable_6 = cState.getVariable("temp");
      temp = ((String) _variable_6);
      Object _variable_7 = cState.getVariable("iTablePos");
      Integer iN = ((Integer) _variable_7);
      Object _variable_8 = cState.getVariable("jTablePos");
      Integer jN = ((Integer) _variable_8);
      int i = iN.intValue();
      int j = jN.intValue();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Set oCell = oTable.getCellByPosition(");
      _builder_1.append(j, "");
      _builder_1.append(",");
      _builder_1.append(i, "");
      _builder_1.append(")\\n");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t\t\t\t\t\t");
      _builder_1.append("Set oTextTable = oCell.getText() ");
      _builder_1.newLine();
      String _plus_1 = (temp + _builder_1);
      temp = _plus_1;
      cState.setVariable("temp", temp);
    }
    Integer _integer = new Integer(parag);
    cState.setVariable("parag", _integer);
    int counter = 0;
    EList<Text> _text = par.getText();
    for (final Text txt : _text) {
      {
        if ((((inTable).booleanValue() && (counter > 0)) && (!(Objects.equal(tableType, TableType.ONECOLUMNTABLE) || Objects.equal(tableType, TableType.TEXTTABLE))))) {
          Object _variable_9 = cState.getVariable("temp");
          temp = ((String) _variable_9);
          temp = (temp + " + ");
          cState.setVariable("temp", temp);
        }
        boolean _matched = false;
        if (txt instanceof Text) {
          _matched=true;
          this.compiler.compile("SimpleText", txt);
        }
        Object _variable_10 = cState.getVariable("temp");
        String tempF = ((String) _variable_10);
        int _length = tempF.length();
        boolean _greaterThan = (_length > 40000);
        if (_greaterThan) {
          Object _variable_11 = cState.getVariable("libreCode");
          LibreGeneratedCode lC = ((LibreGeneratedCode) _variable_11);
          lC.addCodeElement(tempF);
          cState.setVariable("temp", "");
          if (((inTable).booleanValue() && (Objects.equal(tableType, TableType.ONECOLUMNTABLE) || Objects.equal(tableType, TableType.TEXTTABLE)))) {
            Object _variable_12 = cState.getVariable("temp");
            temp = ((String) _variable_12);
            Object _variable_13 = cState.getVariable("iTablePos");
            Integer iN_1 = ((Integer) _variable_13);
            Object _variable_14 = cState.getVariable("jTablePos");
            Integer jN_1 = ((Integer) _variable_14);
            int i_1 = iN_1.intValue();
            int j_1 = jN_1.intValue();
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("Set oCell = oTable.getCellByPosition(");
            _builder_2.append(j_1, "");
            _builder_2.append(",");
            _builder_2.append(i_1, "");
            _builder_2.append(")\\n");
            _builder_2.newLineIfNotEmpty();
            _builder_2.append("\t\t\t\t\t\t");
            _builder_2.append("Set oTextTable = oCell.getText() ");
            _builder_2.newLine();
            String _plus_2 = (temp + _builder_2);
            temp = _plus_2;
            cState.setVariable("temp", temp);
          }
        }
        counter = (counter + 1);
      }
    }
    Object _variable_9 = cState.getVariable("calcLayout");
    Boolean cl = ((Boolean) _variable_9);
    if ((!(inTable).booleanValue())) {
      if ((cl).booleanValue()) {
        Object _variable_10 = cState.getVariable("temp");
        temp = ((String) _variable_10);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("getLines(");
        _builder_2.append(parag, "");
        _builder_2.append(", \"");
        String _iD = par.getID();
        _builder_2.append(_iD, "");
        _builder_2.append("\", file, oText.createTextCursorByRange(oText.getEnd()))");
        _builder_2.newLineIfNotEmpty();
        _builder_2.append("oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)");
        _builder_2.newLine();
        String _plus_2 = (temp + _builder_2);
        temp = _plus_2;
        cState.setVariable("temp", temp);
      }
    }
  }
}
