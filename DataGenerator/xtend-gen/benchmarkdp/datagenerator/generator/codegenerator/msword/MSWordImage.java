package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.Image;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MSWordImage extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    Image img = ((Image) object);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    Object _variable_1 = cState.getVariable("inlineShape");
    Integer imgNum = ((Integer) _variable_1);
    int iN = imgNum.intValue();
    iN = (iN + 1);
    Integer _integer = new Integer(iN);
    cState.setVariable("inlineShape", _integer);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set oImg = oSelection.InlineShapes.AddPicture(\"c:\\Users\\Kresimir Duretec\\Dropbox\\Work\\Projects\\BenchmarkDP\\benchmarking\\publications\\JSS\\Generated\\Macro\\Images\\Desert.jpg\")");
    _builder.newLine();
    _builder.append("oImg.Height = ");
    int _height = img.getHeight();
    _builder.append(_height, "");
    _builder.newLineIfNotEmpty();
    _builder.append("oImg.Width = ");
    int _width = img.getWidth();
    _builder.append(_width, "");
    _builder.newLineIfNotEmpty();
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
  }
}
