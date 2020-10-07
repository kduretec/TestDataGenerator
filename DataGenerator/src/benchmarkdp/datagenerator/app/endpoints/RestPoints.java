package benchmarkdp.datagenerator.app.endpoints;

import benchmarkdp.datagenerator.app.domainmodel.Dataset;
import benchmarkdp.datagenerator.app.domainmodel.DatasetRepository;
import org.eclipse.core.internal.runtime.Product;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/datasets")
public class RestPoints {

    private final DatasetService datasetService;

    @Inject
    public RestPoints(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public DatasetRepository sayHello() {
        return datasetService.getDatasetRepo();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dataset sayHello(@PathParam("id") int id) {
        Dataset data = new Dataset("Fiurst test dataset", id);
        return data;
    }
}
