package org.camel.examples.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ContentBasedRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Router direct:a
        from("direct:a").routeId("direct-a-id")
            .choice()
                .when(simple("${header.foo} == 'bar'"))
                    .to("direct:b")
                .when(simple("${header.foo} == 'cheese'"))
                    .to("direct:c")
                .otherwise()
                    .to("direct:d")
            .endChoice()
        .end();

        // Router direct:b
        from("direct:b").routeId("direct-b-id")
                .process(exchange -> {
                    exchange.getMessage().setBody("direct-b-id");
                })
                .to("stream:out")
        .end();

        // Router direct:c
        from("direct:c").routeId("direct-c-id")
                .process(exchange -> {
                    exchange.getMessage().setBody("direct-c-id");
                })
                .to("stream:out")
        .end();

        // Router direct:d
        from("direct:d").routeId("direct-d-id")
                .process(exchange -> {
                    exchange.getMessage().setBody("direct-d-id");
                })
                .to("stream:out")
        .end();
    }
}
