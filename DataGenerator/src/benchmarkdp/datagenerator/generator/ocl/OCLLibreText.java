package benchmarkdp.datagenerator.generator.ocl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;
import benchmarkdp.datagenerator.generator.TestModel;
import benchmarkdp.datagenerator.generator.Text;
import benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage;
import benchmarkdp.datagenerator.model.PSMLibre.Element;
import benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage;
import benchmarkdp.datagenerator.model.PSMLibre.Row;
import benchmarkdp.datagenerator.model.PSMLibre.Table;
import benchmarkdp.datagenerator.model.PSMLibre.TextContainer;

public class OCLLibreText extends AbstractOCLEvaluator {

	public OCLLibreText() {
		modelType = ModelType.PSMLibre;
	}

	@Override
	public void evaluateTestModel(TestCase tC) {

		TestModel tm = tC.getTestModel();
		if (tm.getModelType() == modelType) {
			EList<EObject> objects = tm.getModelObjects();
			Object doc = objects.get(0);

			// fetch all elements
			initialize(PSMLibrePackage.Literals.DOCUMENT, "self.pages.elements->asSequence()");
			Object value = evaluateObject(doc);
			List<Object> elList = (List<Object>) value;

			for (Object el : elList) {
				Element docEl = (Element) el;
				Text txt = new Text();
				txt.setID(docEl.getID());

				if (docEl instanceof TextContainer) {
					initialize(PSMLibrePackage.Literals.PARAGRAPH_IMPL, "self.text.value->asSequence()");
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
					initialize(PSMLibrePackage.Literals.ROW,
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
				tC.getTextElements().addText(txt);
			}
		}

	}

}
