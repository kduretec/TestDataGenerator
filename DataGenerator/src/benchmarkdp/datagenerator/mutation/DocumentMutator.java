package benchmarkdp.datagenerator.mutation;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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

public class DocumentMutator {

	DocumentHolder doc;

	List<MutationOperatorInterface> mutations;

	public DocumentMutator(DocumentHolder dh) {
		doc = dh;
		mutations = new ArrayList<MutationOperatorInterface>();
	}

	public DocumentHolder getDocumentHolder() {
		return doc;
	}

	public void addMutation(MutationOperatorInterface mut, int num) {
		for (int i = 0; i < num; i++) {
			mutations.add(mut);
		}
	}

	public void mutate() {
		System.out.println("Mutating " + doc.getName());
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true);
		OutputStreamWriter outStream = new OutputStreamWriter(System.out);
		Log log = new WriterLog(outStream);
		context.setLog(log);
		for (int i = 0; i < mutations.size(); i++) {
			MutationOperatorInterface m = mutations.get(i);
			ModelType sourceModel = m.getSourceModel();
			ModelType destinationModel = m.getDestinationModel();
			TransformationExecutor executor = m.getTransformationExecutor();
			ModelExtent input = doc.getModelExtent(sourceModel);
			ModelExtent output = new BasicModelExtent();
			ExecutionDiagnostic result = executor.execute(context, input, output);
			if (sourceModel == destinationModel) {
				output = input;
			}
			if (result.getSeverity() == Diagnostic.OK) {
				doc.setModelExtent(destinationModel, output);
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
		mutations.clear();
	}
}
