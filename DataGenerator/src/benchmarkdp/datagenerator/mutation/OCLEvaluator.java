package benchmarkdp.datagenerator.mutation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import benchmarkdp.datagenerator.model.PIM.Document;
import benchmarkdp.datagenerator.model.PIM.PIMPackage;


public class OCLEvaluator {

	private String groundTruthKey; 
	private ModelType model;
	private String expression;

	private OCLExpression<EClassifier> query;

	private Query eval;

	public OCLEvaluator(String key, ModelType mo, String exp) {
		groundTruthKey = key;
		model = mo;
		expression = exp;

		OCL ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		OCLHelper helper = ocl.createOCLHelper();

		helper.setContext(PIMPackage.Literals.DOCUMENT);

		try {
			query = helper.createQuery(expression);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eval = ocl.createQuery(query);
	}
	
	public void evaluateDocument(DocumentHolder dH) {
		EList<EObject> objects = dH.getDocumentObjects(model);
		Document doc = (Document) objects.get(0);
		
		Object value = eval.evaluate(doc);
		System.out.println("Evaluated " + groundTruthKey + " " + value.toString());
		dH.addGroundTruth(groundTruthKey, value.toString());

	}
}
