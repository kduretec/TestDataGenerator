package benchmarkdp.datagenerator.generator.codegenerator.msword;

import benchmarkdp.datagenerator.generator.codegenerator.AbstractElementCompiler;
import benchmarkdp.datagenerator.generator.codegenerator.CompilerState;
import benchmarkdp.datagenerator.model.PSMDocx.Document;
import benchmarkdp.datagenerator.model.PSMDocx.Page;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class MSWordDocument extends AbstractElementCompiler {
  @Override
  public void compile(final EObject object, final CompilerState cState) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field numColum is undefined for the type Document");
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
