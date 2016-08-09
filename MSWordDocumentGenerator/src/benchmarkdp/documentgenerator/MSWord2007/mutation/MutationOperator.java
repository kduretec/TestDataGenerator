package benchmarkdp.documentgenerator.MSWord2007.mutation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

public class MutationOperator implements MutationOperatorInterface {

	private String name;
	
	private URI transformationURI;
	
	TransformationExecutor executor ;
	
	public MutationOperator(String n, String link) {
		name = n;
		transformationURI = URI.createURI(link);
		executor = new TransformationExecutor(transformationURI);
		
	}
	
	public TransformationExecutor getTransformationExecutor() {
		return executor;
	}
	
	public String getName() {
		return name;
	}
	
}
