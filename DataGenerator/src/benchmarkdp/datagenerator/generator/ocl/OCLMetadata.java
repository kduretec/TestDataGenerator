package benchmarkdp.datagenerator.generator.ocl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;
import benchmarkdp.datagenerator.generator.TestModel;

public class OCLMetadata extends AbstractOCLEvaluator{

	private String name; 
	
	public OCLMetadata(ModelType mt, Object con, String n, String exp) {
		name = n;
		modelType = mt;
		initialize(con, exp);
	}
	
	@Override
	public void evaluateTestModel(TestCase tC) {
		TestModel tm = tC.getTestModel();
		while (tm != null) {
			if (tm.getModelType() == modelType) {
				EList<EObject> objects = tm.getModelObjects();
				Object doc =  objects.get(0);
				Object value = evaluateObject(doc);
				tC.getMetadata().add(name, value);				
			}
			tm = tm.getParent();
		}
	}
	
}
