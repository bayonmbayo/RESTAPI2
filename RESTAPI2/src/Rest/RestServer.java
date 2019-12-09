package Rest;

import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class RestServer {

    public static void main(String args[]) throws Exception {

        URI endpoint = new URI("http://localhost:55321/buchservices");

        ResourceConfig rc = new ResourceConfig(LieferantenAPI.class, BuecherAPI.class, BestellungsAPI.class);
        HttpServer server = JdkHttpServerFactory.createHttpServer(endpoint, rc);
    }
}
