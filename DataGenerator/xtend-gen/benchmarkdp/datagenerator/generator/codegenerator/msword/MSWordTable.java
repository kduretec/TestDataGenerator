package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.Cell;
import benchmarkdp.datagenerator.model.PSMDocx.Element;
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph;
import benchmarkdp.datagenerator.model.PSMDocx.Row;
import benchmarkdp.datagenerator.model.PSMDocx.Table;
import benchmarkdp.datagenerator.model.PSMDocx.WordTable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MSWordTable extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    WordTable t = ((WordTable) object);
    int numR = t.getNumRows();
    int numC = t.getNumCol();
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    Boolean _boolean = new Boolean(true);
    cState.setVariable("inTable", _boolean);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("oSelection.TypeParagraph()");
    _builder.newLine();
    _builder.append("Set oRange = oSelection.Range");
    _builder.newLine();
    _builder.append("oDoc.Tables.Add oRange, ");
    _builder.append(numR, "");
    _builder.append(", ");
    _builder.append(numC, "");
    _builder.newLineIfNotEmpty();
    _builder.append("Set objTable = oDoc.Tables(tableIndex)");
    _builder.newLine();
    _builder.append("objTable.AutoFormat(16)");
    _builder.newLine();
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
    this.compileTableElements(t, cState);
    Object _variable_1 = cState.getVariable("temp");
    temp = ((String) _variable_1);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("tableIndex = tableIndex + 1");
    _builder_1.newLine();
    _builder_1.append("oSelection.EndKey END_OF_STORY");
    _builder_1.newLine();
    _builder_1.append("oSelection.TypeParagraph()");
    _builder_1.newLine();
    _builder_1.append("i= i + 1");
    _builder_1.newLine();
    String _plus_1 = (temp + _builder_1);
    temp = _plus_1;
    cState.setVariable("temp", temp);
    Boolean _boolean_1 = new Boolean(false);
    cState.setVariable("inTable", _boolean_1);
  }
  
  public void compileTableElements(final Table t, final CompilerState cState) {
    for (int i = 1; (i <= t.getNumRows()); i++) {
      for (int j = 1; (j <= t.getNumCol()); j++) {
        {
          Object _variable = cState.getVariable("temp");
          String temp = ((String) _variable);
          temp = (((((temp + "objTable.Cell(") + Integer.valueOf(i)) + ",") + Integer.valueOf(j)) + ").Select\n");
          cState.setVariable("temp", temp);
          EList<Row> _row = t.getRow();
          Row _get = _row.get((i - 1));
          EList<Cell> _cell = _get.getCell();
          Cell _get_1 = _cell.get((j - 1));
          EList<Element> _elements = _get_1.getElements();
          for (final Element e : _elements) {
            boolean _matched = false;
            if (e instanceof Paragraph) {
              _matched=true;
              this.compiler.compile("Paragraph", e);
            }
          }
        }
      }
    }
  }
}
