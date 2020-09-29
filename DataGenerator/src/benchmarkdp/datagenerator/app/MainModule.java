package benchmarkdp.datagenerator.app;

import benchmarkdp.datagenerator.app.endpoints.EndpointsProvider;
import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EndpointsProvider.class).to(TEstEndPointProvider.class);
    }
}
