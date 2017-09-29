package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph;
import benchmarkdp.datagenerator.model.PSMLibre.Text;
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
    if (((parag > 1) && (!(inTable).booleanValue()))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)");
      _builder.newLine();
      String _plus = (temp + _builder);
      temp = _plus;
    }
    cState.setVariable("temp", temp);
    if ((!(inTable).booleanValue())) {
      parag = (parag + 1);
    }
    Integer _integer = new Integer(parag);
    cState.setVariable("parag", _integer);
    int counter = 0;
    EList<Text> _text = par.getText();
    for (final Text txt : _text) {
      {
        if (((inTable).booleanValue() && (counter > 0))) {
          Object _variable_3 = cState.getVariable("temp");
          temp = ((String) _variable_3);
          temp = (temp + " + ");
          cState.setVariable("temp", temp);
        }
        boolean _matched = false;
        if (txt instanceof Text) {
          _matched=true;
          this.compiler.compile("SimpleText", txt);
        }
        counter = (counter + 1);
      }
    }
    if ((!(inTable).booleanValue())) {
      Object _variable_3 = cState.getVariable("temp");
      temp = ((String) _variable_3);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("getLines(");
      _builder_1.append(parag, "");
      _builder_1.append(", \"");
      String _iD = par.getID();
      _builder_1.append(_iD, "");
      _builder_1.append("\", file)");
      _builder_1.newLineIfNotEmpty();
      String _plus_1 = (temp + _builder_1);
      temp = _plus_1;
      cState.setVariable("temp", temp);
    }
  }
}
