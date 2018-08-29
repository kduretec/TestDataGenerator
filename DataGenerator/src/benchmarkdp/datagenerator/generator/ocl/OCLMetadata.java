package benchmarkdp.datagenerator.generator.ocl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import benchmarkdp.datagenerator.testcase.ModelType;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.TestModel;

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
			//System.out.println("Evaluating " + tC.getTestCaseName());
			if (tm.getModelType() == modelType) {
				EList<EObject> objects = tm.getModelObjects();
				Object doc =  objects.get(0);
				Object value = evaluateObject(doc);
				//System.out.println("Adding metadata : " + name + " ; " + value.toString());
				tC.getMetadata().add(name+":DataGenerator", value);				
			}
			tm = tm.getParent();
		}
	}
	
}
