package benchmarkdp.datagenerator.mappers;

import benchmarkdp.datagenerator.core.TestCase;
import benchmarkdp.datagenerator.core.TestDataset;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class GenericMapper<T> {

    public T load(String content) {


        JAXBContext jaxbContext;
        T tCC = null;
//        try {
////            jaxbContext = JAXBContext.newInstance(tCC);
////            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
////
////            tCC = (TestDataset) jaxbUnmarshaller.unmarshal(f);
////
//
//        } catch (JAXBException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        return tCC;
    }

    public String save(T element) {

        T tCC = null;
//        JAXBContext jaxbContext;
//        try {
//            jaxbContext = JAXBContext.newInstance(TestDataset.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            // output pretty printed
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//           // jaxbMarshaller.marshal(tCC, f);
//        } catch (JAXBException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return null;
    }
}
