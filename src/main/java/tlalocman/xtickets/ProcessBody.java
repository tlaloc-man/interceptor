package tlalocman.xtickets;

import io.micrometer.core.instrument.util.IOUtils;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.converter.stream.InputStreamCache;

import static org.apache.camel.util.function.Suppliers.constant;

public class ProcessBody implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String path  = exchange.getIn().getHeader("CamelHttpPath", String.class);
        String body = exchange.getIn().getBody(String.class);
        body = body.replace("debugger", "");
        body = body.replace("e.which === 123", "false");

        exchange.getIn().setBody(body);
    }
}
