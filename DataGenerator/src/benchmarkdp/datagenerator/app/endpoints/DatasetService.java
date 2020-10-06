package benchmarkdp.datagenerator.app.endpoints;

import benchmarkdp.datagenerator.app.domainmodel.Dataset;
import benchmarkdp.datagenerator.app.domainmodel.DatasetRepository;

import java.util.List;

/**
 *
 */
public final class DatasetService {


    DatasetRepository datasetRepo;

    public DatasetService() {
        datasetRepo = new DatasetRepository();
    }

    public DatasetRepository getDatasetRepo() {
        return datasetRepo;
    }

    public void setDatasetRepo(DatasetRepository datasetRepo) {
        this.datasetRepo = datasetRepo;
    }

    public List<Dataset> sayHello() {
        return datasetRepo.getDatList();
    }
}
