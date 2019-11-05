package benchmarkdp.datagenerator.generator.ocl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import benchmarkdp.datagenerator.core.ModelType;
import benchmarkdp.datagenerator.core.TestCase;
import benchmarkdp.datagenerator.core.Text;

public class OCLText extends AbstractOCLEvaluator {

	String expression = "self.pages.elements->selectByKind(TextContainer)->asSequence()->collectNested(words.value->asSequence())";

	public OCLText(ModelType mt, Object con) {
		modelType = mt;

		initialize(con, expression);
	}

	@Override
	public void evaluateTestModel(TestCase tC) {
		// TODO Auto-generated method stub
		EList<EObject> objects = tC.getTestModel().getModelObjects();
		Object doc = objects.get(0);
		Object value = evaluateObject(doc);

		List<Object> list = (List<Object>) value;

		int counter = 0;
		for (Object l : list) {
			counter++;
			StringBuilder sb = new StringBuilder();
			List<String> ls = (List<String>) l;
			for (String w : ls) {
				sb.append(w + " ");
			}
			String rT = sb.toString().trim();
			Text txt = new Text(Integer.toString(counter), rT);
			tC.getTextElements().addText(txt);
		}
	}

}
