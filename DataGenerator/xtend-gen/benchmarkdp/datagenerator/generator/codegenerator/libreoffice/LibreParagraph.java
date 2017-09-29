package benchmarkdp.datagenerator.generator.codegenerator.libreoffice;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMLibre.Paragraph;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class LibreParagraph extends AbstractElementCompiler {
  public String compile(final Paragraph par, final boolean inTable) {
    StringConcatenation _builder = new StringConcatenation();
    String temp = _builder.toString();
    return temp;
  }
  
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    throw new Error("Unresolved compilation problems:"
      + "\nSimpleText cannot be resolved to a type."
      + "\nThe method or field words is undefined for the type Paragraph");
  }
}
