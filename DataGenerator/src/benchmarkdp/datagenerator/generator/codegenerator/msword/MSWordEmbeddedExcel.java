package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.Cell;
import benchmarkdp.datagenerator.model.PSMDocx.Element;
import benchmarkdp.datagenerator.model.PSMDocx.EmbeddedExcel;
import benchmarkdp.datagenerator.model.PSMDocx.Paragraph;
import benchmarkdp.datagenerator.model.PSMDocx.Row;
import benchmarkdp.datagenerator.model.PSMDocx.Text;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MSWordEmbeddedExcel extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    EmbeddedExcel t = ((EmbeddedExcel) object);
    Object _variable = cState.getVariable("inlineShape");
    Integer tabNum = ((Integer) _variable);
    int tN = tabNum.intValue();
    tN = (tN + 1);
    Integer _integer = new Integer(tN);
    cState.setVariable("inlineShape", _integer);
    int numR = t.getNumRows();
    int numC = t.getNumCol();
    Object _variable_1 = cState.getVariable("temp");
    String temp = ((String) _variable_1);
    Boolean _boolean = new Boolean(true);
    cState.setVariable("inTable", _boolean);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("oSelection.TypeParagraph()");
    _builder.newLine();
    _builder.append("Set oRange = oSelection.Range");
    _builder.newLine();
    _builder.append("oDoc.InlineShapes.AddOLEObject \"Excel.Sheet\", , , , , , , oRange");
    _builder.newLine();
    _builder.append("Set oExcel = oDoc.InlineShapes(");
    _builder.append(tN, "");
    _builder.append(").OLEFormat.Object");
    _builder.newLineIfNotEmpty();
    _builder.append("Set oSheet = oExcel.Worksheets(\"Sheet1\")");
    _builder.newLine();
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
    this.compileTableElements(t, cState);
    Object _variable_2 = cState.getVariable("temp");
    temp = ((String) _variable_2);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("oSheet.UsedRange.Borders.LineStyle = 1");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("oSheet.Range(oSheet.Cells(");
    int _numRows = t.getNumRows();
    int _plus_1 = (_numRows + 1);
    _builder_1.append(_plus_1, "");
    _builder_1.append(",1), oSheet.Cells(oSheet.Rows.Count,oSheet.Columns.Count)).EntireRow.Hidden = True");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("oSheet.Range(oSheet.Cells(1,");
    int _numCol = t.getNumCol();
    int _plus_2 = (_numCol + 1);
    _builder_1.append(_plus_2, "");
    _builder_1.append("), oSheet.Cells(oSheet.Rows.Count,oSheet.Columns.Count)).EntireColumn.Hidden = True");
    _builder_1.newLineIfNotEmpty();
    _builder_1.newLine();
    _builder_1.append("REM oSelection.EndKey END_OF_STORY");
    _builder_1.newLine();
    _builder_1.append("Set oExcel = oDoc.InlineShapes(");
    _builder_1.append(tN, "");
    _builder_1.append(")");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("oSelection.Start = oExcel.Range.End + 1");
    _builder_1.newLine();
    _builder_1.append("oSelection.TypeParagraph()");
    _builder_1.newLine();
    _builder_1.append("i= i + 1");
    _builder_1.newLine();
    String _plus_3 = (temp + _builder_1);
    temp = _plus_3;
    cState.setVariable("temp", temp);
    Boolean _boolean_1 = new Boolean(false);
    cState.setVariable("inTable", _boolean_1);
  }
  
  public void compileTableElements(final EmbeddedExcel t, final CompilerState cState) {
    for (int i = 1; (i <= t.getNumRows()); i++) {
      for (int j = 1; (j <= t.getNumCol()); j++) {
        {
          Object _variable = cState.getVariable("temp");
          String temp = ((String) _variable);
          temp = (((((temp + "oSheet.Cells(") + Integer.valueOf(i)) + ",") + Integer.valueOf(j)) + ") = \" ");
          EList<Row> _row = t.getRow();
          Row _get = _row.get((i - 1));
          EList<Cell> _cell = _get.getCell();
          Cell _get_1 = _cell.get((j - 1));
          EList<Element> _elements = _get_1.getElements();
          for (final Element e : _elements) {
            String _switchResult = null;
            boolean _matched = false;
            if (e instanceof Paragraph) {
              _matched=true;
              _switchResult = this.compileParagraph(((Paragraph)e));
            }
            String _plus = (temp + _switchResult);
            temp = _plus;
          }
          temp = (temp + "\"\n");
          cState.setVariable("temp", temp);
        }
      }
    }
  }
  
  public String compileParagraph(final Paragraph p) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    EList<Text> _text = p.getText();
    Text _get = _text.get(0);
    String _value = _get.getValue();
    String _plus = (temp + _value);
    temp = _plus;
    return temp;
  }
}
