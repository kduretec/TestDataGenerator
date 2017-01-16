package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.Document;
import benchmarkdp.datagenerator.model.PSMDocx.Page;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MSWordDocument extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Document d = ((Document) object);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Const END_OF_STORY = 6 ");
    _builder.newLine();
    _builder.append("Set objWord = CreateObject(\"Word.Application\") ");
    _builder.newLine();
    _builder.append("objWord.Visible = True ");
    _builder.newLine();
    _builder.append("grFile = \"c:\\Users\\Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\benchmarking\\publications\\JSS\\Generated\\GroundTruth\\MSWordOutput\\");
    Object _variable_1 = cState.getVariable("documentName");
    _builder.append(_variable_1, "");
    _builder.append("-wordgroundtruth.txt\" \t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("Set objFSO = CreateObject(\"Scripting.FileSystemObject\")");
    _builder.newLine();
    _builder.append("Set objFile = objFSO.CreateTextFile(grFile, True)");
    _builder.newLine();
    _builder.append("Set oDoc = objWord.Documents.Add()");
    _builder.newLine();
    _builder.append("oDoc.PageSetup.TextColumns.SetCount(");
    int _numColum = d.getNumColum();
    _builder.append(_numColum, "");
    _builder.append(") ");
    _builder.newLineIfNotEmpty();
    _builder.append("Set oSelection = objWord.Selection ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("i = 1 ");
    _builder.newLine();
    _builder.append("tableIndex = 1");
    _builder.newLine();
    _builder.append("tBox = 0");
    _builder.newLine();
    _builder.append("cBox = 0");
    _builder.newLine();
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
    this.compileDocumentElements(d, cState);
    Object _variable_2 = cState.getVariable("temp");
    temp = ((String) _variable_2);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("oDoc.SaveAs \"c:\\Users\\Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\benchmarking\\publications\\JSS\\Generated\\Documents\\");
    Object _variable_3 = cState.getVariable("documentName");
    _builder_1.append(_variable_3, "");
    _builder_1.append(".");
    String _documentFormat = d.getDocumentFormat();
    _builder_1.append(_documentFormat, "");
    _builder_1.append("\", ");
    String _documentFormatCode = d.getDocumentFormatCode();
    _builder_1.append(_documentFormatCode, "");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.newLine();
    _builder_1.append("objFile.Write \"pagecount \" & oDoc.ComputeStatistics(2) & vbCrLf");
    _builder_1.newLine();
    _builder_1.append("objFile.Write \"wordcount \" & oDoc.ComputeStatistics(0) & vbCrLf");
    _builder_1.newLine();
    _builder_1.append("objFile.Write \"paragraphcount \" & oDoc.ComputeStatistics(4)");
    _builder_1.newLine();
    _builder_1.append("oDoc.Saved = TRUE");
    _builder_1.newLine();
    _builder_1.append("objFile.Close()");
    _builder_1.newLine();
    _builder_1.append("objWord.Quit");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Sub selLines(p, id, o, outFile) ");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("p.Range.Select");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("counter = 1");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Do While True");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("o.Selection.Collapse(1)");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("Call o.Selection.EndKey(5,1)");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("outFile.Write(id & \":\" & counter & \":\" & o.Selection.Text & vbCrLf)");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("maxEnd = o.Selection.End");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("o.Selection.Collapse(0)");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("If maxEnd >= p.Range.End Then");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("Exit Do");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("End If");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("counter = counter + 1 ");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Loop");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("o.Selection.EndKey END_OF_STORY");
    _builder_1.newLine();
    _builder_1.append("End Sub");
    _builder_1.newLine();
    String _plus_1 = (temp + _builder_1);
    temp = _plus_1;
    cState.setVariable("temp", temp);
  }
  
  public void compileDocumentElements(final Document d, final CompilerState cState) {
    boolean check = false;
    EList<Page> _pages = d.getPages();
    for (final Page p : _pages) {
      {
        if (check) {
          Object _variable = cState.getVariable("temp");
          String temp = ((String) _variable);
          temp = (temp + "oSelection.InsertBreak(7)\n");
          cState.setVariable("temp", temp);
        }
        this.compiler.compile("Page", p);
        check = true;
      }
    }
  }
}
