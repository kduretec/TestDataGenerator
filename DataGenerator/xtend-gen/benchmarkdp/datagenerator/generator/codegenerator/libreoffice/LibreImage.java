package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMLibre.Image;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreImage extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Image img = ((Image) object);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("oText.insertControlCharacter(oText.getEnd(), com.sun.star.text.ControlCharacter.PARAGRAPH_BREAK, False)");
    _builder.newLine();
    _builder.append("Set oGraph = oDoc.createInstance(\"com.sun.star.text.GraphicObject\")");
    _builder.newLine();
    _builder.append("oGraph.GraphicURL = ConvertToURL(\"/home/kresimir/Dropbox/Work/Projects/BenchmarkDP/benchmarking/publications/JSS/Generated/Macro/Images/Desert.jpg\")");
    _builder.newLine();
    _builder.append("oGraph.AnchorType = com.sun.star.text.TextContentAnchorType.AS_CHARACTER");
    _builder.newLine();
    _builder.append("oGraph.Width = TwipsPerPixelX() * ");
    int _width = img.getWidth();
    _builder.append(_width, "");
    _builder.append(" * 2540.0 / 1440 ");
    _builder.newLineIfNotEmpty();
    _builder.append("oGraph.Height = TwipsPerPixelY() * ");
    int _height = img.getHeight();
    _builder.append(_height, "");
    _builder.append(" * 2540.0 / 1440 ");
    _builder.newLineIfNotEmpty();
    _builder.append("oText.insertTextContent(oText.getEnd(), oGraph, False )");
    _builder.newLine();
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
  }
}
