package org.camel.app.router.internal;

import com.mongodb.client.model.Filters;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mongodb.MongoDbConstants;
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

        from("direct:mongodb-movie-findAll")
                .routeId("direct-mongodb-movie-findAll-id")
                .description("This route find all movies on mongodb")
                .to("mongodb:connectionBean?database=api&collection=movies&operation=findAll");

        from("direct:mongodb-movie-findByGender")
                .routeId("direct-mongodb-movie-findByGender-id")
                .description("This route find all movies on mongodb")
                .process(exchange -> {
                    final String gender = exchange.getIn().getHeader("gender", String.class);
                    .setHeader(MongoDbConstants.CRITERIA, constant(Filters.eq("gender", gender)));
                })
                .to("mongodb:connectionBean?database=api&collection=movies&operation=findAll");
    }
}
