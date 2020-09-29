package benchmarkdp.datagenerator.app;

import benchmarkdp.datagenerator.app.endpoints.EndpointsProvider;
import benchmarkdp.datagenerator.app.endpoints.RestPoints;

import java.util.HashSet;
import java.util.Set;

public class TEstEndPointProvider implements EndpointsProvider {

    private Set<Class<?>> endpoints;

    public TEstEndPointProvider() {
        endpoints = new HashSet<>();
        endpoints.add(RestPoints.class);
    }

    @Override
    public Set<Class<?>> getEndpoints() {
        return endpoints;
    }
}
