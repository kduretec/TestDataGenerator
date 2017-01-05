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

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;
import benchmarkdp.datagenerator.model.PSMDocx.Document;
import benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage;



public class OCLEvaluatorPSMDocx implements OCLEvaluatorInterface {

	private String groundTruthKey; 
	private ModelType modelType;
	private String expression;
	
	private OCLExpression<EClassifier> query;
	
	private Query eval;
	
	public OCLEvaluatorPSMDocx(String key, String exp) {
		groundTruthKey = key;
		modelType = ModelType.PSMDocx;
		expression = exp;

		OCL ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		OCLHelper helper = ocl.createOCLHelper();

		helper.setContext(PSMDocxPackage.Literals.DOCUMENT);

		try {
			query = helper.createQuery(expression);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eval = ocl.createQuery(query);
	}
	
	@Override
	public ModelType getModelType() {
		// TODO Auto-generated method stub
		return modelType;
	}

	@Override
	public void evaluateTestModel(TestCase tC) {
		EList<EObject> objects = tC.getTestModel().getModelObjects();
		Document doc = (Document) objects.get(0);
		
		Object value = eval.evaluate(doc);
		tC.getMetadata().add(groundTruthKey, value);
		
	}

	
}
