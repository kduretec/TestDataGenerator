package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorInterface;
import benchmarkdp.datagenerator.generator.codegenerator.CodeGeneratorObserverInterface;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.generator.codegenerator.ModelElementsCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreColor;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreDocument;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreFontFamily;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreGeneratedCode;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreImage;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibrePage;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreParagraph;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreSimpleText;
import benchmarkdp.datagenerator.generator.codegenerator.libreoffice.LibreTable;
import benchmarkdp.datagenerator.model.PSMLibre.Document;
import benchmarkdp.datagenerator.testcase.ModelType;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.TestModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreCodeGenerator implements CodeGeneratorInterface {
  private ModelType modelType = ModelType.PSMLibre;
  
  private CodeGeneratorObserverInterface cGOb;
  
  private ModelElementsCompiler compiler;
  
  private CompilerState compilerState;
  
  public LibreCodeGenerator() {
    CompilerState _compilerState = new CompilerState();
    this.compilerState = _compilerState;
    ModelElementsCompiler _modelElementsCompiler = new ModelElementsCompiler(this.compilerState);
    this.compiler = _modelElementsCompiler;
    LibreDocument _libreDocument = new LibreDocument();
    this.compiler.addCompiler("Document", _libreDocument);
    LibrePage _librePage = new LibrePage();
    this.compiler.addCompiler("Page", _librePage);
    LibreParagraph _libreParagraph = new LibreParagraph();
    this.compiler.addCompiler("Paragraph", _libreParagraph);
    LibreTable _libreTable = new LibreTable();
    this.compiler.addCompiler("Table", _libreTable);
    LibreImage _libreImage = new LibreImage();
    this.compiler.addCompiler("Image", _libreImage);
    LibreSimpleText _libreSimpleText = new LibreSimpleText();
    this.compiler.addCompiler("SimpleText", _libreSimpleText);
    LibreColor _libreColor = new LibreColor();
    this.compiler.addCompiler("Color", _libreColor);
    LibreFontFamily _libreFontFamily = new LibreFontFamily();
    this.compiler.addCompiler("FontFamily", _libreFontFamily);
  }
  
  @Override
  public ModelType getModelType() {
    return this.modelType;
  }
  
  @Override
  public void addCodeGeneratorObserver(final CodeGeneratorObserverInterface cgo) {
    this.cGOb = cgo;
  }
  
  @Override
  public void generateCode(final TestCase tC) {
    TestModel _testModel = tC.getTestModel();
    EList<EObject> _modelObjects = _testModel.getModelObjects();
    EObject _get = _modelObjects.get(0);
    Document d = ((Document) _get);
    LibreGeneratedCode libreCode = new LibreGeneratedCode(this.cGOb);
    String _software = d.getSoftware();
    libreCode.software = _software;
    String _operatingSystem = d.getOperatingSystem();
    libreCode.operatingSystem = _operatingSystem;
    this.compilerState.setVariable("libreCode", libreCode);
    String _testCaseName = tC.getTestCaseName();
    this.compilerState.setVariable("documentName", _testCaseName);
    Integer _integer = new Integer(0);
    this.compilerState.setVariable("numCodeLines", _integer);
    Integer _integer_1 = new Integer(0);
    this.compilerState.setVariable("parag", _integer_1);
    this.compiler.compile("Document", d);
    String _helper = this.helper();
    libreCode.addHelperFunction(_helper);
    String _helper2 = this.helper2();
    libreCode.addHelperFunction(_helper2);
    String _helper3 = this.helper3();
    libreCode.addHelperFunction(_helper3);
    tC.setGeneratedCode(libreCode);
  }
  
  public String helper() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Sub getLines(numPar, parID, file, textCursor) ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("oTextCursor = textCursor");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("oViewCursor = ThisComponent.CurrentController.getViewCursor()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("line = 0");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("oTextCursor.gotoStartOfParagraph(False)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("oViewCursor.gotoRange(oTextCursor, False)\t");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Do While True ");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("oViewCursor.gotoEndOfLine(False)");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("oTextCursor.gotoRange(oViewCursor, True)");
    _builder.newLine();
    _builder.append("\t\t       \t\t\t");
    _builder.append("line = line + 1");
    _builder.newLine();
    _builder.append("\t\t        \t   \t");
    _builder.append("s = parID &amp; \":\" &amp; line &amp; \":\" &amp; oTextCursor.String");
    _builder.newLine();
    _builder.append("\t\t        \t   \t");
    _builder.append("Print #file, s");
    _builder.newLine();
    _builder.append("\t\t        \t   \t");
    _builder.append("REM MsgBox \"numparh=\" + num + \" numline=\" + line + \" text=\" + oTextCursor.String, 0, \"Lines\"");
    _builder.newLine();
    _builder.append("\t\t        \t   \t");
    _builder.append("oTextCursor.collapseToEnd()");
    _builder.newLine();
    _builder.append("\t\t        \t   \t");
    _builder.append("If oTextCursor.isEndOfParagraph() Then Exit Do ");
    _builder.newLine();
    _builder.append("\t\t        \t");
    _builder.append("Loop  ");
    _builder.newLine();
    _builder.append("End Sub");
    _builder.newLine();
    _builder.newLine();
    String fun = _builder.toString();
    return fun;
  }
  
  /**
   * // This is a helper function used to get the content of each line in a paragraph
   * def helper() {
   * var fun = '''
   * Sub getLines(numPar, parID, file)
   * oTextCursor = ThisComponent.Text.createTextCursor()
   * oTextCursor.gotoStart(False)
   * oViewCursor = ThisComponent.CurrentController.getViewCursor()
   * num = numPar
   * Do
   * num = num + 1
   * line = 0
   * oTextCursor.gotoStartOfParagraph(False)
   * oViewCursor.gotoRange(oTextCursor, False)
   * If numPar = num Then
   * Do While True
   * oViewCursor.gotoEndOfLine(False)
   * oTextCursor.gotoRange(oViewCursor, True)
   * line = line + 1
   * s = parID &amp; ":" &amp; line &amp; ":" &amp; oTextCursor.String
   * Print #file, s
   * MsgBox "numparh=" + num + " numline=" + line + " text=" + oTextCursor.String, 0, "Lines"
   * oTextCursor.collapseToEnd()
   * If oTextCursor.isEndOfParagraph() Then Exit Do
   * Loop
   * Exit Do
   * End If
   * Loop While oTextCursor.gotoNextParagraph(False)
   * End Sub
   * 
   * '''
   * return fun
   * }
   */
  public String helper2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Function getParagraphStyleName(colorCode, fontName) as String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Dim stName As String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("stName = \"PAR_BACK_\" &amp; colorCode &amp; \"_\" &amp; fontName  ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oStyleFamilies = ThisComponent.getStyleFamilies()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oParagraphStyles = oStyleFamilies.getByName(\"ParagraphStyles\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("If (NOT oParagraphStyles.HasByName(stName))  Then");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("oStyle = ThisComponent.createInstance(\"com.sun.star.style.ParagraphStyle\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("oStyle.ParaBackColor = \tcolorCode");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("oStyle.CharFontName = fontName");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("oParagraphStyles.insertByName(stName, oStyle)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("End If ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("getParagraphStyleName = stName");
    _builder.newLine();
    _builder.append("End Function ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    String fun = _builder.toString();
    return fun;
  }
  
  public String helper3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Function LoadGraphicIntoDocument(oDoc As Object, cUrl, cInternalName) As String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Dim oBitmaps");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Dim cNewUrl As String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\' Get the BitmapTable from this drawing document.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\' It is a service that maintains a list of bitmaps that are internal");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\' to the document.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oBitmaps = oDoc.createInstance( \"com.sun.star.drawing.BitmapTable\" )");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\' Add an external graphic to the BitmapTable of this document.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oBitmaps.insertByName( cInternalName, cUrl )");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\' Now ask for it back.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\' What we get back is an different Url that points to a graphic");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\' which is inside this document, and remains with the document.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("cNewUrl = oBitmaps.getByName( cInternalName )");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LoadGraphicIntoDocument = cNewUrl");
    _builder.newLine();
    _builder.append("End Function");
    _builder.newLine();
    String fun = _builder.toString();
    return fun;
  }
  
  public String helper4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Sub InsertGraphicObject(oDoc, sURL)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Dim oCursor");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Dim oGraph");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Dim oText");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oText = oDoc.getText()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oCursor = oText.createTextCursor()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oCursor.goToStart(FALSE)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oGraph = oDoc.createInstance(\"com.sun.star.text.GraphicObject\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oGraph.GraphicURL = sURL");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oGraph.AnchorType = com.sun.star.text.TextContentAnchorType.AS_CHARACTER");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oGraph.Width = 6000");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oGraph.Height = 8000");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'now insert the image into the text document");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("oText.insertTextContent(oCursor, oGraph, False )");
    _builder.newLine();
    _builder.append("End Sub");
    _builder.newLine();
    String fun = _builder.toString();
    return fun;
  }
}
