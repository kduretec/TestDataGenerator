package benchmarkdp.datagenerator.generator.ocl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;

public class OCLMetadata extends AbstractOCLEvaluator{

	private String name; 
	
	public OCLMetadata(ModelType mt, Object con, String n, String exp) {
		name = n;
		modelType = mt;
		initialize(con, exp);
	}
	
	@Override
	public void evaluateTestModel(TestCase tC) {
		EList<EObject> objects = tC.getTestModel().getModelObjects();
		Object doc =  objects.get(0);
		Object value = eval.evaluate(doc);
		tC.getMetadata().add(name, value);
	}

	
}
