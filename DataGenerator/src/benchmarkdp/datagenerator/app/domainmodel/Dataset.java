package benchmarkdp.datagenerator.app.domainmodel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dataset {

    private String name;

    private int numberOfDocuments;

    public Dataset(String name, int numberOfDocuments) {
        this.name = name;
        this.numberOfDocuments = numberOfDocuments;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public int getNumberOfDocuments() {
        return numberOfDocuments;
    }

    public void setNumberOfDocuments(int numberOfDocuments) {
        this.numberOfDocuments = numberOfDocuments;
    }
}
