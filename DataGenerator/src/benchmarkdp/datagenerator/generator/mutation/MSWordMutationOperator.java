package benchmarkdp.datagenerator.generator.mutation;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.Log;
import org.eclipse.m2m.qvt.oml.util.WriterLog;

import benchmarkdp.datagenerator.testcase.ModelType;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.TestModel;

@Deprecated
//Not needed anymore as MutatorOperator is enough for the new design
public class MSWordMutationOperator extends MutationOperator implements MutationOperatorInterface {

	private List<String> formats;

	private List<String> platforms;

	private Map<String, String> formatMapping;

	public MSWordMutationOperator(String n, ModelType s, ModelType d, String link, List<String> form,
			List<String> plat) {
		super(n, s, d, link);
		formats = form;
		platforms = plat;
		formatMapping = new HashMap<String, String>();
		formatMapping.put("doc", "0");
		formatMapping.put("docx", "16");
		formatMapping.put("rtf", "6");
		formatMapping.put("pdf", "17");
		formatMapping.put("odt", "20"); 
	}

	@Override
	public void mutateTestCase(TestCase tC) {
		//List<TestCase> tModels = new ArrayList<TestCase>();
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true);
		OutputStreamWriter outStream = new OutputStreamWriter(System.out);
		Log log = new WriterLog(outStream);
		context.setLog(log);

		if (tC.getTestModel().getModelType() == source) {
			List<Object> tForm = new ArrayList<Object>();
			List<Object> tPlat = new ArrayList<Object>();
			// set the transformation parameters
//			for (String feature : features) {
//				Object value = null;
//				if (tC.getTestFeature().isFeatureAvailable(feature)) {
//					value = tC.getTestFeature().getFeature(feature);
//					if (feature == "format") {
//						tForm.add(value);
//					} else if (feature == "platform") {
//						tPlat.add(value);
//					} else {
//						context.setConfigProperty(feature, value);
//					}
//				}
//			}
			if (tForm.isEmpty()) {
				tForm.addAll(formats);
			}
			if (tPlat.isEmpty()) {
				tPlat.addAll(platforms);
			}
			for (Object oF : tForm) {
				for (Object oP : tPlat) {
					context.setConfigProperty("format", oF);
					context.setConfigProperty("formatCode", formatMapping.get(oF));
					context.setConfigProperty("platform", oP);
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
							//tModels.add(nTM);
						}
					} else {
						// turn the result diagnostic into status and send it to
						// error
						// log
						IStatus status = BasicDiagnostic.toIStatus(result);
						// Activator.getDefault().getLog().log(status);
						System.out.println(status.getMessage());
						for (IStatus st : status.getChildren()) {
							System.out.println(st.getMessage());
						}
					}
				}
			}
		}
		//return tModels;

	}

}
