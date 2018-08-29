package benchmarkdp.datagenerator.generator.ocl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import benchmarkdp.datagenerator.model.PIM.PIMPackage;
import benchmarkdp.datagenerator.testcase.ModelType;
import benchmarkdp.datagenerator.testcase.TestCase;

public abstract class AbstractOCLEvaluator implements OCLEvaluatorInterface{
	
	protected ModelType modelType;

	private Query eval;

	private OCLExpression<EClassifier> query;
	
	private OCL ocl;
	
	
	protected void initialize(Object context, String expression) {
		
		ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		OCLHelper helper = ocl.createOCLHelper();
		helper.setContext(context);

		try {
			query = helper.createQuery(expression);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eval = ocl.createQuery(query);
	}
	
	public ModelType getModelType() {
		return modelType;
	}
	
	protected Object evaluateObject(Object obj) {
		Object value = eval.evaluate(obj);
		return value;
	}

}
