package benchmarkdp.datagenerator.generator.mutation;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.Log;
import org.eclipse.m2m.qvt.oml.util.WriterLog;

import benchmarkdp.datagenerator.generator.ModelType;
import benchmarkdp.datagenerator.generator.TestCase;

public class MutationOperator implements MutationOperatorInterface {

	protected String name;
	protected ModelType source;
	protected ModelType destination;
	
	protected URI transformationURI;
		
	protected TransformationExecutor executor;
	
	//protected List<String> features; 
	
	public MutationOperator(String n, ModelType s, ModelType d, String link) {
		name = n;
		source = s;
		destination = d;
		transformationURI = URI.createURI(link);
		executor = new TransformationExecutor(transformationURI);
		//features = f;
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
	
//	public List<String> getFeatures() {
//		return features;
//	}
	
	public List<TestCase> mutateTestCase(TestCase tC) {
		List<TestCase> tModels = new ArrayList<TestCase>();
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true);
		OutputStreamWriter outStream = new OutputStreamWriter(System.out);
		Log log = new WriterLog(outStream);
		context.setLog(log);
		if (tC.getTestModel().getModelType() == source) {

			// set the transformation parameters
//			for (String feature : features) {
//				Object value = null;
//				if (tC.getTestFeature().isFeatureAvailable(feature)) {
//					value = tC.getTestFeature().getFeature(feature);
//				}
//				context.setConfigProperty(feature, value);
//			}
			
			Map<String, String> testFeatures = tC.getTestFeature().getAllFeatures();
			for (Map.Entry<String, String> feat : testFeatures.entrySet()) {
				context.setConfigProperty(feat.getKey(), feat.getValue());
			}
			

			TransformationExecutor executor = getTransformationExecutor();
			ModelExtent input = tC.getTestModel().getModelExtent();
			ModelExtent output = new BasicModelExtent();
			ExecutionDiagnostic result = executor.execute(context, input, output);
			if (result.getSeverity() == Diagnostic.OK) {
				if (source == destination) {
					tC.getTestModel().setModelExtent(input);
				} else {
					TestCase nTM = new TestCase(tC);
					nTM.getTestModel().setModelExtent(output);
					nTM.getTestModel().setModelType(destination);
					tModels.add(nTM);
				}
			} else {
				// turn the result diagnostic into status and send it to error
				// log
				IStatus status = BasicDiagnostic.toIStatus(result);
				// Activator.getDefault().getLog().log(status);
				System.out.println(status.getMessage());
				for (IStatus st : status.getChildren()) {
					System.out.println(st.getMessage());
				}
			}
		}
		return tModels;
	}
}
