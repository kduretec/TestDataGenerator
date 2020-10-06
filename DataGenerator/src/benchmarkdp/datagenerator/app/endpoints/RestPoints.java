package benchmarkdp.datagenerator.app.endpoints;

import benchmarkdp.datagenerator.app.domainmodel.Dataset;
import benchmarkdp.datagenerator.app.domainmodel.DatasetRepository;
import org.eclipse.core.internal.runtime.Product;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    public Response sayHello() {
        GenericEntity<DatasetRepository> entity = new GenericEntity<DatasetRepository>(datasetService.getDatasetRepo()) {};
        Response response = Response.ok(entity).build();
        return response;
    }
}
