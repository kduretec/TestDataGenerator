package benchmarkdp.datagenerator.app;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.examples.blackbox.UtilitiesLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import benchmarkdp.datagenerator.generator.MutationStep;
import benchmarkdp.datagenerator.model.PIM.PIMPackage;
import benchmarkdp.datagenerator.model.PSMDocx.PSMDocxPackage;
import benchmarkdp.datagenerator.model.PSMLibre.PSMLibrePackage;
import benchmarkdp.datagenerator.properties.ExperimentProperties;
import benchmarkdp.datagenerator.properties.PropertiesHandler;
import benchmarkdp.datagenerator.testcase.InitializeTestCasesStep;
import benchmarkdp.datagenerator.testcase.TestCaseContainer;
import benchmarkdp.datagenerator.testcase.TestCaseHandler;
import benchmarkdp.datagenerator.workflow.IWorkflowStep;

public class Main {

	private static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		log.info("Starting the app");

		TransformationExecutor.BlackboxRegistry.INSTANCE.registerModule(UtilitiesLibrary.class,
				"m2m.qvt.oml.ExampleJavaLib", "m2m.qvt.oml");
		
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		PIMPackage mwp = PIMPackage.eINSTANCE;
		PSMDocxPackage pwd = PSMDocxPackage.eINSTANCE;
		PSMLibrePackage pld = PSMLibrePackage.eINSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		PropertiesHandler ph = new PropertiesHandler();
		if (args.length > 0) {
			ExperimentProperties pr = ph.loadProperties(args[0]);
			log.info("Experiment name " + pr.getExperimentName());
			log.info("Folder " + pr.getFullFolderPath());

			IWorkflowStep step = null;
			String state = pr.getExperimentState();
			TestCaseContainer tCC = null;
			TestCaseHandler tch = new TestCaseHandler();
			
			if (state.compareTo("START") != 0 && state.compareTo("FOLDER_STRUCTURE_INITIALIZED") != 0) {
				tCC = tch.load(pr);
				log.info(tCC.numberTestCases() + " testcases loaded");
				//log.info("TestCase number " + tCC.numberTestCases());
				//log.info(tCC.getTestCases().get(0).getTestFeature().getFeature("numWords"));
			}
			switch (state) {
			case "START":
				step = new InitializeFolderStep();
				break;
			case "FOLDER_STRUCTURE_INITIALIZED":
				step = new InitializeTestCasesStep();
				break;
			default:
				step = new MutationStep();
				break;
			}
			if (tCC == null) {
				tCC = new TestCaseContainer();
			}
			
			while (step != null) {
				step.executeStep(pr, tCC);
				log.info("State = " + pr.getExperimentState());
				ph.saveProperties(pr);
				if (tCC.numberTestCases() > 0) {
					tch.save(pr, tCC);
				}
				step = step.nextStep();
			}
		}

	}

}
