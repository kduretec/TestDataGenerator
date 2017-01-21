package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMLibre.Cell;
import benchmarkdp.datagenerator.model.PSMLibre.Element;
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph;
import benchmarkdp.datagenerator.model.PSMLibre.Row;
import benchmarkdp.datagenerator.model.PSMLibre.Table;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreTable extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Table t = ((Table) object);
    int numR = t.getNumRows();
    int numC = t.getNumCol();
    Object _variable = cState.getVariable("parag");
    Integer numPar = ((Integer) _variable);
    int parag = numPar.intValue();
    parag = (parag + 1);
    Integer _integer = new Integer(parag);
    cState.setVariable("parag", _integer);
    Object _variable_1 = cState.getVariable("temp");
    String temp = ((String) _variable_1);
    Boolean _boolean = new Boolean(true);
    cState.setVariable("inTable", _boolean);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)");
    _builder.newLine();
    _builder.append("oTable = ThisComponent.createInstance( \"com.sun.star.text.TextTable\" )");
    _builder.newLine();
    _builder.append("oTable.initialize(");
    _builder.append(numR, "");
    _builder.append(", ");
    _builder.append(numC, "");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("oText.insertTextContent(oText.getEnd(), oTable, False)");
    _builder.newLine();
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
    this.compileTableElements(t, cState);
    Boolean _boolean_1 = new Boolean(false);
    cState.setVariable("inTable", _boolean_1);
  }
  
  public void compileTableElements(final Table t, final CompilerState cState) {
    for (int i = 1; (i <= t.getNumRows()); i++) {
      for (int j = 1; (j <= t.getNumCol()); j++) {
        EList<Row> _row = t.getRow();
        Row _get = _row.get((i - 1));
        EList<Cell> _cell = _get.getCell();
        Cell _get_1 = _cell.get((j - 1));
        EList<Element> _elements = _get_1.getElements();
        int _size = _elements.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          Object _variable = cState.getVariable("temp");
          String temp = ((String) _variable);
          temp = (((((temp + "Set oCell = oTable.getCellByPosition(") + Integer.valueOf((j - 1))) + ",") + Integer.valueOf((i - 1))) + ")\n");
          temp = (temp + "oCell.setString( ");
          cState.setVariable("temp", temp);
          EList<Row> _row_1 = t.getRow();
          Row _get_2 = _row_1.get((i - 1));
          EList<Cell> _cell_1 = _get_2.getCell();
          Cell _get_3 = _cell_1.get((j - 1));
          EList<Element> _elements_1 = _get_3.getElements();
          for (final Element e : _elements_1) {
            boolean _matched = false;
            if (e instanceof Paragraph) {
              _matched=true;
              this.compiler.compile("Paragraph", e);
            }
          }
          Object _variable_1 = cState.getVariable("temp");
          temp = ((String) _variable_1);
          temp = (temp + " ) \n");
          cState.setVariable("temp", temp);
        }
      }
    }
  }
}
