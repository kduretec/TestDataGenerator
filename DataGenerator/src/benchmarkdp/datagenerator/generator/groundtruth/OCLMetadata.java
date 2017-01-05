package benchmarkdp.datagenerator.generator.groundtruth;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestModel;

public class OCLMetadata extends AbstractOCLEvaluator{

	private String name; 
	
	public OCLMetadata(ModelType mt, Object con, String n, String exp) {
		name = n;
		modelType = mt;
		initialize(con, exp);
	}
	
	@Override
	public void evaluateTestModel(TestModel tm) {
		EList<EObject> objects = tm.getModelObjects();
		Object doc =  objects.get(0);
		Object value = eval.evaluate(doc);
		tm.getMetadata().add(name, value);
	}

	
}
