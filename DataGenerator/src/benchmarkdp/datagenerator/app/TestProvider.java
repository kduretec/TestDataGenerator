package benchmarkdp.datagenerator.app;

import benchmarkdp.datagenerator.app.endpoints.EndpointsProvider;
import benchmarkdp.datagenerator.app.endpoints.RestPoints;

import java.util.HashSet;
import java.util.Set;

public class TestProvider implements EndpointsProvider {

    private Set<Class<?>> endpoints;

    public TestProvider() {
        endpoints = new HashSet<>();
        endpoints.add(RestPoints.class);
    }

    @Override
    public Set<Class<?>> getEndpoints() {
        return endpoints;
    }
}
