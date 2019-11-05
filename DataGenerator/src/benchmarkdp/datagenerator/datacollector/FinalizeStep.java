package benchmarkdp.datagenerator.datacollector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.core.TestCase;
import benchmarkdp.datagenerator.core.TestCaseContainer;
import benchmarkdp.datagenerator.core.Text;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class FinalizeStep implements IWorkflowStep {

	private static Logger log = LoggerFactory.getLogger(FinalizeStep.class);

	private List<CollectorOperatorInterface> operators;
	private Map<String, TestCase> testCases;

	LineCollector lineCollector;
	ModelTextCollector modelTextCollector;

	public FinalizeStep() {
		operators = new ArrayList<CollectorOperatorInterface>();
		operators.add(new FitsCollector());
		operators.add(new GeneratedMetadataCollector());
		operators.add(new ModelMetadataCollector());
		lineCollector = new LineCollector();
		modelTextCollector = new ModelTextCollector();
	}

	@Override
	public void executeStep(ExperimentProperties ep, TestCaseContainer tCC) {

		boolean isOk = true;
		for (TestCase tc : tCC.getTestCases()) {
			log.info("Finalizing core : " + tc.getTestCaseName());
			for (CollectorOperatorInterface coi : operators) {
				Map<String, Object> mValues = coi.collect(ep, tc);
				tc.getMetadata().add(mValues);
			}

			List<Text> ts = modelTextCollector.collectTextELementsList(ep, tc);
			tc.getTextElements().addText(ts);
			Map<String, Text> mt = lineCollector.collectTextElemenentsMap(ep, tc);
			tc.getTextElements().addText(mt);

			tc.saveTestCaseComponents(ep);

			isOk = isOk & verifyTestCase(ep, tc);
		}
		if (isOk) {
			ep.setExperimentState("TEST_CASES_FINALIZED");
		}
	}

	@Override
	public IWorkflowStep nextStep() {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean verifyTestCase(ExperimentProperties ep, TestCase tc) {
		int cnt = 0;
		String relativeMetaFile = ep.getMetadataFolder() + File.separator + tc.getTestCaseName() + ".xml";
		String metadataFile = ep.getFullFolderPath() + relativeMetaFile;
		File f = new File(metadataFile);
		if (f.exists()) {
			tc.setMetadataFile(relativeMetaFile);
			cnt++;
		}
		String relativeTextFile = ep.getTextFolder() + File.separator + tc.getTestCaseName() + ".xml";
		String textFile = ep.getFullFolderPath() + relativeTextFile;
		f = new File(textFile);
		if (f.exists()) {
			tc.setTextFile(relativeTextFile);
			cnt++;
		}

		if (cnt == 2) {
			tc.setTestCaseState("FINALIZED");
			return true;
		} else {
			return false;
		}
	}
}
