package benchmarkdp.datagenerator.generator.ocl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;
import benchmarkdp.datagenerator.generator.Text;
import benchmarkdp.datagenerator.model.PSMLibre.Element;
import benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage;
import benchmarkdp.datagenerator.model.PSMLibre.Table;
import benchmarkdp.datagenerator.model.PSMLibre.TextContainer;

public class OCLLibreText extends AbstractOCLEvaluator {

	public OCLLibreText() {
		modelType = ModelType.PSMLibre;
	}

	@Override
	public void evaluateTestModel(TestCase tm) {

		// // TODO Auto-generated method stub
		EList<EObject> objects = tm.getTestModel().getModelObjects();
		Object doc = objects.get(0);

		// fetch all elements
		initialize(PSMLibrePackage.Literals.DOCUMENT, "self.pages.elements->asSequence()");
		Object value = evaluateObject(doc);
		List<Object> elList = (List<Object>) value;

		for (Object el : elList) {
			Element docEl = (Element) el;
			//Text txt = new Text();
			//txt.setID(docEl.getID());

			if (docEl instanceof TextContainer) {
				initialize(PSMLibrePackage.Literals.TEXT_CONTAINER, "self.words.value->asSequence()");
				Object words = evaluateObject(docEl);
				List<String> wList = (List<String>) words;
				StringBuilder sb = new StringBuilder();
				for (String w : wList) {
					sb.append(w + " ");
				}
				String rT = sb.toString().trim();
				Text txt = new Text(docEl.getID(), rT);
				tm.getTextElements().addText(txt);
			} else if (docEl instanceof Table) {
				
			}
		}

	}

}
