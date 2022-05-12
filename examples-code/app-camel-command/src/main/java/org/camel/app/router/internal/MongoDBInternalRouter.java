package org.camel.app.router.internal;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MongoDBInternalRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:mongodb-movie-insert")
                .routeId("direct-mongodb-movie-insert-id")
                .description("This route send a movie collection for mongodb")
                .to("mongodb:connectionBean?database=api-command&collection=movies&operation=insert")
                .to("direct:send-movies-kafka");
    }
}
