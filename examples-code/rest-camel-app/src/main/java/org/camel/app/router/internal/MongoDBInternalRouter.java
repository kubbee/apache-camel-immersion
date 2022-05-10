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
                .convertBodyTo(String.class)
                .to("mongodb:connectionBean?database=api&collection=movies&operation=insert");
    }
}
