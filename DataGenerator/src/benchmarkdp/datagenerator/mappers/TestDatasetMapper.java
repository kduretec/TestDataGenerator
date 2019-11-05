package benchmarkdp.datagenerator.mappers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import benchmarkdp.datagenerator.core.TestCase;
import benchmarkdp.datagenerator.core.TestDataset;
import benchmarkdp.datagenerator.properties.ExperimentProperties;

public class TestDatasetMapper {

	public TestDataset load(ExperimentProperties ep, boolean loadModels) {
		String path = ep.getFullFolderPath() + "/testCases.xml";
		File f = new File(path);
		JAXBContext jaxbContext;
		TestDataset tCC = null;
		try {
			jaxbContext = JAXBContext.newInstance(TestDataset.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			tCC = (TestDataset) jaxbUnmarshaller.unmarshal(f);

			if (loadModels) {
				for (TestCase tc : tCC.getTestCases()) {
					tc.load(ep);
				}
			}

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tCC;
	}

	public void save(ExperimentProperties ep, TestDataset tCC) {
		String path = ep.getFullFolderPath() + File.separator + "testCases.xml";
		File f = new File(path);
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(TestDataset.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(tCC, f);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
