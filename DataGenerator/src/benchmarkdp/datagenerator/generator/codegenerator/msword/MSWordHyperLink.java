package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.HyperLink;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class MSWordHyperLink extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    HyperLink h = ((HyperLink) object);
    Object _variable = cState.getVariable("temp");
    String temp = ((String) _variable);
    temp = (temp + "\n");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Set oRange = oSelection.Range");
    _builder.newLine();
    _builder.append("oDoc.Hyperlinks.Add oRange, \"");
    String _url = h.getUrl();
    _builder.append(_url, "");
    _builder.append("\", , , \" ");
    String _value = h.getValue();
    _builder.append(_value, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    String _plus = (temp + _builder);
    temp = _plus;
    cState.setVariable("temp", temp);
  }
}
