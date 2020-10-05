package benchmarkdp.datagenerator.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.InjectionManagerProvider;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

public class GuiceFeature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        ServiceLocator locator = InjectionManagerProvider.getInjectionManager(context)
                .getInstance(ServiceLocator.class);

        Injector injector = Guice.createInjector(new MainModule());
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(locator);
        GuiceIntoHK2Bridge guiceBridge = locator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(injector);
        return true;
    }
}
