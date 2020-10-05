package benchmarkdp.datagenerator.app.endpoints;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
public class RestPoints {

    private final TestService testService;

    @Inject
    public RestPoints(TestService testService) {
        this.testService = testService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return testService.sayHello();
    }
}
