package benchmarkdp.datagenerator.app;

import benchmarkdp.datagenerator.app.endpoints.ResourceLoader;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.ServletException;
import java.io.File;

public class MainServer {

    public static void main(String[] args) throws LifecycleException, ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addWebapp("/", new File(".").getAbsolutePath());

        Tomcat.addServlet(context, "jersey-container-servlet", resourceConfig());
        context.addServletMapping("/*", "jersey-container-servlet");

        tomcat.start();
        tomcat.getServer().await();
    }

    private static ServletContainer resourceConfig() {
        Injector injector = Guice.createInjector(new MainModule());
        ResourceLoader resourceLoader = injector.getInstance(ResourceLoader.class);
        ResourceConfig config = new ResourceConfig(resourceLoader.getClasses());
        config.packages("ca.ulaval.glo4002.trading").register(GuiceFeature.class);
        return new ServletContainer(config);
    }


}
