package tlalocman.xtickets;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Interceptor extends RouteBuilder {

    @Override
    public void configure() {
        from("jetty:http://0.0.0.0/?matchOnUriPrefix=true")
                .routeId("local")
                .process(new ProcessHeaders())
                .log("headers: ${header.CamelHttpPath}")
                .to("https://web.xticket.mx?bridgeEndpoint=true&throwExceptionOnFailure=false")
                .process(new ProcessBody());
    }


}
