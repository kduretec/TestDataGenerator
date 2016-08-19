package benchmarkdp.datagenerator.mutation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

public class MutationOperator implements MutationOperatorInterface {

	private String name;
	private ModelType source;
	private ModelType destination;
	
	private URI transformationURI;
	
	TransformationExecutor executor;
	
	private List<String> features; 
	
	public MutationOperator(String n, ModelType s, ModelType d, String link, List<String> f) {
		name = n;
		source = s;
		destination = d;
		transformationURI = URI.createURI(link);
		executor = new TransformationExecutor(transformationURI);
		features = f;
	}
	
	public TransformationExecutor getTransformationExecutor() {
		return executor;
	}
	
	public String getName() {
		return name;
	}

	public ModelType getSourceModel() {
		return source;
	}

	public ModelType getDestinationModel() {
		return destination;
	}
	
	public List<String> getFeatures() {
		return features;
	}
}
