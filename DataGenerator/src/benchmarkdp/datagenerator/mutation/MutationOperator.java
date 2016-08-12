package benchmarkdp.datagenerator.mutation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

public class MutationOperator implements MutationOperatorInterface {

	private String name;
	private String source;
	private String destination;
	
	private URI transformationURI;
	
	TransformationExecutor executor;
	
	public MutationOperator(String n, String s, String d, String link) {
		name = n;
		source = s;
		destination = d;
		transformationURI = URI.createURI(link);
		executor = new TransformationExecutor(transformationURI);	
	}
	
	public TransformationExecutor getTransformationExecutor() {
		return executor;
	}
	
	public String getName() {
		return name;
	}

	public String getSourceModel() {
		return source;
	}

	public String getDestinationModel() {
		return destination;
	}
	
}
