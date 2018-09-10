package benchmarkdp.datagenerator.datacollector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.testcase.TestCase;
import benchmarkdp.datagenerator.testcase.TestCaseContainer;
import benchmarkdp.datagenerator.testcase.Text;
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
		
		for (TestCase tc: tCC.getTestCases()) {
			log.info("Finalizing testcase : " + tc.getTestCaseName());
			for (CollectorOperatorInterface coi : operators) {
				Map<String, Object> mValues = coi.collect(ep, tc);
				tc.getMetadata().add(mValues);
			}
			
			List<Text> ts = modelTextCollector.collectTextELementsList(ep, tc);
			tc.getTextElements().addText(ts);
			Map<String, Text> mt = lineCollector.collectTextElemenentsMap(ep, tc);
			tc.getTextElements().addText(mt);
			
			ep.setExperimentState("FINALIZED");
			tc.saveTestCaseComponents(ep);
		}

	}

	@Override
	public IWorkflowStep nextStep() {
		// TODO Auto-generated method stub
		return null;
	}

}
