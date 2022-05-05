package org.camel.examples.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MulticastRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:a")
                .multicast().parallelProcessing()
                .to("direct:x")
                .to("direct:y")
                .to("direct:z");

        from("direct:x")
                .routeId("direct-x-id")
                .process(exchange -> {
                    exchange.getMessage().setBody("direct-x-id");
                })
                .to("stream:out")
        .end();

        from("direct:y")
                .routeId("direct-y-id")
                .process(exchange -> {
                    exchange.getMessage().setBody("direct-y-id");
                })
                .to("stream:out")
        .end();

        from("direct:z")
                .routeId("direct-z-id")
                .process(exchange -> {
                    exchange.getMessage().setBody("direct-z-id");
                })
                .to("stream:out")
        .end();
    }
}
