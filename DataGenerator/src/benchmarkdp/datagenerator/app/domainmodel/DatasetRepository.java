package benchmarkdp.datagenerator.app.domainmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class DatasetRepository {


    List<Dataset> datList;

    public DatasetRepository() {
        datList = new ArrayList<>();
        datList.add(new Dataset("Test1", 5));
        datList.add(new Dataset("Test2", 3));
    }

    @XmlElement
    public List<Dataset> getDatList() {
        return datList;
    }

    public void setDatList(List<Dataset> datList) {
        this.datList = datList;
    }

}
