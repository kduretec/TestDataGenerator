package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.Color;
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
    _builder.append("objWord.Visible = WScript.Arguments.Item(3) ");
    _builder.newLine();
    _builder.append("grFile = WScript.Arguments.Item(1) + \"");
    Object _variable_1 = cState.getVariable("documentName");
    _builder.append(_variable_1, "");
    _builder.append(".txt\" \t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("grFileMetadata = WScript.Arguments.Item(2) + \"");
    Object _variable_2 = cState.getVariable("documentName");
    _builder.append(_variable_2, "");
    _builder.append(".txt\"");
    _builder.newLineIfNotEmpty();
    _builder.append("Set objFSO = CreateObject(\"Scripting.FileSystemObject\")");
    _builder.newLine();
    _builder.append("Set objFile = objFSO.CreateTextFile(grFile, True)");
    _builder.newLine();
    _builder.append("Set objFileMetadata = objFSO.CreateTextFile(grFileMetadata, True)");
    _builder.newLine();
    _builder.append("Set oDoc = objWord.Documents.Add()");
    _builder.newLine();
    _builder.append("oDoc.Background.Fill.Visible = True");
    _builder.newLine();
    _builder.append("oDoc.Background.Fill.ForeColor.RGB = ");
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
    Color _documentBackground = d.getDocumentBackground();
    this.compiler.compile("Color", _documentBackground);
    Object _variable_3 = cState.getVariable("temp");
    temp = ((String) _variable_3);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.newLine();
    _builder_1.append("oDoc.PageSetup.TextColumns.SetCount(");
    _builder_1.append(1, "");
    _builder_1.append(") ");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("Set oSelection = objWord.Selection ");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("i = 1 ");
    _builder_1.newLine();
    _builder_1.append("tableIndex = 1");
    _builder_1.newLine();
    _builder_1.append("tBox = 0");
    _builder_1.newLine();
    _builder_1.append("cBox = 0");
    _builder_1.newLine();
    String _plus_1 = (temp + _builder_1);
    temp = _plus_1;
    cState.setVariable("temp", temp);
    this.compileDocumentElements(d, cState);
    Object _variable_4 = cState.getVariable("temp");
    temp = ((String) _variable_4);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("oDoc.SaveAs WScript.Arguments.Item(0) + \"");
    Object _variable_5 = cState.getVariable("documentName");
    _builder_2.append(_variable_5, "");
    _builder_2.append(".");
    String _documentFormat = d.getDocumentFormat();
    _builder_2.append(_documentFormat, "");
    _builder_2.append("\", ");
    String _documentFormatCode = d.getDocumentFormatCode();
    _builder_2.append(_documentFormatCode, "");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("\t\t");
    _builder_2.newLine();
    _builder_2.append("objFileMetadata.Write \"pagecount \" & oDoc.ComputeStatistics(2) & vbCrLf");
    _builder_2.newLine();
    _builder_2.append("objFileMetadata.Write \"wordcount \" & oDoc.ComputeStatistics(0) & vbCrLf");
    _builder_2.newLine();
    _builder_2.append("objFileMetadata.Write \"paragraphcount \" & oDoc.ComputeStatistics(4)");
    _builder_2.newLine();
    _builder_2.append("oDoc.Saved = TRUE");
    _builder_2.newLine();
    _builder_2.append("objFile.Close()");
    _builder_2.newLine();
    _builder_2.append("objFileMetadata.Close()");
    _builder_2.newLine();
    _builder_2.append("objWord.Quit");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("Sub selLines(p, id, o, outFile) ");
    _builder_2.newLine();
    _builder_2.append("    ");
    _builder_2.append("p.Range.Select");
    _builder_2.newLine();
    _builder_2.append("    ");
    _builder_2.append("counter = 1");
    _builder_2.newLine();
    _builder_2.append("    ");
    _builder_2.newLine();
    _builder_2.append("    ");
    _builder_2.append("Do While True");
    _builder_2.newLine();
    _builder_2.append("        ");
    _builder_2.append("o.Selection.Collapse(1)");
    _builder_2.newLine();
    _builder_2.append("        ");
    _builder_2.append("Call o.Selection.EndKey(5,1)");
    _builder_2.newLine();
    _builder_2.append("        ");
    _builder_2.append("outFile.Write(id & \":\" & counter & \":\" & o.Selection.Text & vbCrLf)");
    _builder_2.newLine();
    _builder_2.append("        ");
    _builder_2.append("maxEnd = o.Selection.End");
    _builder_2.newLine();
    _builder_2.append("        ");
    _builder_2.append("o.Selection.Collapse(0)");
    _builder_2.newLine();
    _builder_2.append("        ");
    _builder_2.append("If maxEnd >= p.Range.End Then");
    _builder_2.newLine();
    _builder_2.append("            ");
    _builder_2.append("Exit Do");
    _builder_2.newLine();
    _builder_2.append("        ");
    _builder_2.append("End If");
    _builder_2.newLine();
    _builder_2.append("        ");
    _builder_2.append("counter = counter + 1 ");
    _builder_2.newLine();
    _builder_2.append("    ");
    _builder_2.append("Loop");
    _builder_2.newLine();
    _builder_2.append("    ");
    _builder_2.append("o.Selection.EndKey END_OF_STORY");
    _builder_2.newLine();
    _builder_2.append("End Sub");
    _builder_2.newLine();
    String _plus_2 = (temp + _builder_2);
    temp = _plus_2;
    cState.setVariable("temp", temp);
  }
  
  public void compileDocumentElements(final Document d, final CompilerState cState) {
    boolean check = false;
    EList<Page> _pages = d.getPages();
    int size = _pages.size();
    int i = 0;
    EList<Page> _pages_1 = d.getPages();
    for (final Page p : _pages_1) {
      {
        i = (i + 1);
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
