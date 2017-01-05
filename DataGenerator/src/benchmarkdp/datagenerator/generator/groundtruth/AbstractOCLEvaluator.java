package benchmarkdp.datagenerator.generator.groundtruth;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.model.PIM.PIMPackage;

public abstract class AbstractOCLEvaluator implements OCLEvaluatorInterface{
	
	protected ModelType modelType;

	protected Query eval;

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

}
