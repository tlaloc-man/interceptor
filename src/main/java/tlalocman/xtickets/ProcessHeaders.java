package tlalocman.xtickets;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessHeaders implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String HttpPath = exchange.getIn().getHeader("CamelHttpPath", String.class);
        String QueryString = exchange.getIn().getHeader("CamelHttpQuery", String.class);
        String HttpMethod = exchange.getIn().getHeader("CamelHttpMethod", String.class);

        exchange.getIn().setHeader("CamelHttpPath", HttpPath);
        exchange.getIn().setHeader("CamelHttpQuery", QueryString);
        exchange.getIn().setHeader("CamelHttpMethod", HttpMethod);
        exchange.getIn().setHeader("Accept-Encoding", "identity" );

    }
}
