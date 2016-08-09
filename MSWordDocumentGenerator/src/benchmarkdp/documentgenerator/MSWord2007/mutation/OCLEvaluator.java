package benchmarkdp.documentgenerator.MSWord2007.mutation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import benchmarkdp.documentgenerator.MSWord2007.Document;
import benchmarkdp.documentgenerator.MSWord2007.MSWordPackage;

public class OCLEvaluator {

	private String groundTruthKey; 
	private String expression;

	private OCLExpression<EClassifier> query;

	private Query eval;

	public OCLEvaluator(String key, String exp) {
		groundTruthKey = key;
		expression = exp;

		OCL ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		OCLHelper helper = ocl.createOCLHelper();

		helper.setContext(MSWordPackage.Literals.DOCUMENT);

		try {
			query = helper.createQuery(expression);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eval = ocl.createQuery(query);
	}
	
	public void evaluateDocument(DocumentHolder dH) {
		EList<EObject> objects = dH.getDocumentObjects();
		Document doc = (Document) objects.get(0);
		
		Object value = eval.evaluate(doc);
		System.out.println("Evaluated " + groundTruthKey + " " + value.toString());
		dH.addGroundTruth(groundTruthKey, value.toString());

	}
}
