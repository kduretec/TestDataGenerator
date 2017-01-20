package benchmarkdp.datagenerator.generator.ocl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;
import benchmarkdp.datagenerator.generator.Text;
import benchmarkdp.datagenerator.model.PSMDocx.Element;
import benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage;
import benchmarkdp.datagenerator.model.PSMDocx.Row;
import benchmarkdp.datagenerator.model.PSMDocx.Table;
import benchmarkdp.datagenerator.model.PSMDocx.TextContainer;

public class OCLMSWordText extends AbstractOCLEvaluator {

	public OCLMSWordText() {
		modelType = ModelType.PSMDocx;

	}

	@Override
	public void evaluateTestModel(TestCase tm) {

		// // TODO Auto-generated method stub
		EList<EObject> objects = tm.getTestModel().getModelObjects();
		Object doc = objects.get(0);

		// fetch all elements
		initialize(PSMDocxPackage.Literals.DOCUMENT, "self.pages.elements->asSequence()");
		Object value = evaluateObject(doc);
		List<Object> elList = (List<Object>) value;

		for (Object el : elList) {
			Element docEl = (Element) el;
			Text txt = new Text();
			txt.setID(docEl.getID());
			if (docEl instanceof TextContainer) {
				initialize(PSMDocxPackage.Literals.TEXT_CONTAINER, "self.words.value->asSequence()");
				Object words = evaluateObject(docEl);
				List<String> wList = (List<String>) words;
				StringBuilder sb = new StringBuilder();
				for (String w : wList) {
					sb.append(w + " ");
				}
				String rT = sb.toString().trim();
				txt.setRawText(rT);
			} else if (docEl instanceof Table) {
				Table tbl = (Table) docEl;
				EList<Row> rows = tbl.getRow();
				initialize(PSMDocxPackage.Literals.ROW,
						"self.cell.elements->selectByKind(TextContainer)->asSequence()->collectNested(words.value->asSequence())");
				for (Row r : rows) {
					Object rValue = evaluateObject(r);
					List<Object> lS = (List<Object>) rValue;
					StringBuilder sb = new StringBuilder();
					for (Object l : lS) {
						List<String> words = (List<String>) l;
						for (String w : words) {
							sb.append(w + " ");
						}						
					}
					String lT = sb.toString().trim();
					txt.addLine(lT);
				}
			}
			tm.getTextElements().addText(txt);
		}

	}

}
