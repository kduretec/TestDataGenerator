package benchmarkdp.datagenerator.app.endpoints;

import javax.inject.Inject;
import javax.ws.rs.core.Application;
import java.util.Set;

public class ResourceLoader extends Application {

    private EndpointsProvider endpointsProvider;

    @Inject
    public ResourceLoader(EndpointsProvider endPointProvider) {
        this.endpointsProvider = endPointProvider;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return endpointsProvider.getEndpoints();
    }

}

