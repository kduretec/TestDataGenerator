package benchmarkdp.datagenerator.app.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloworld")
public class RestPoints {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "This is hello from the main endpoint!";
    }
}
