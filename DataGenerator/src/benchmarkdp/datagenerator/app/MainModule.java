package benchmarkdp.datagenerator.app;

import benchmarkdp.datagenerator.app.endpoints.EndpointsProvider;
import benchmarkdp.datagenerator.app.endpoints.TestService;
import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EndpointsProvider.class).to(TestProvider.class);
        bind(TestService.class);
    }
}
