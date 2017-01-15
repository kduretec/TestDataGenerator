package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMLibre.Table;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreTable extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Table t = ((Table) object);
    int numR = t.getNumRows();
    int numC = t.getNumCol();
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    Boolean _boolean = new Boolean(true);
    cState.setVariable("inTable", _boolean);
    StringConcatenation _builder = new StringConcatenation();
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
    String _compileTableElements = this.compileTableElements(t);
    String _plus_1 = (temp + _compileTableElements);
    temp = _plus_1;
    cState.setVariable("temp", temp);
    Boolean _boolean_1 = new Boolean(false);
    cState.setVariable("inTable", _boolean_1);
  }
  
  public String compileTableElements(final Table t) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    for (int i = 1; (i <= t.getNumRows()); i++) {
      for (int j = 1; (j <= t.getNumCol()); j++) {
      }
    }
    return temp;
  }
}
