package org.camel.examples.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class BaseRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:base-route?period={{timer.period}}")
                .routeId("timer-base-route-id")
                .setHeader("foo", constant("bar"))
                .to("direct:a")
        .end();

    }

}
