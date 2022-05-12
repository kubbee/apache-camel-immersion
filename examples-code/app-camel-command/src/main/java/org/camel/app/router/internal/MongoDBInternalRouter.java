package org.camel.app.router.internal;

import org.apache.camel.builder.RouteBuilder;
import org.camel.app.bean.MovieBean;
import org.springframework.stereotype.Component;

@Component
public class MongoDBInternalRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:mongodb-movie-insert")
                .routeId("direct-mongodb-movie-insert-id")
                .description("This route send a movie collection for mongodb")
                .to("mongodb:connectionBean?database=api&collection=movies&operation=insert")
                .to("direct:send-movies-kafka");

        from("direct:mongodb-movie-findAll")
                .routeId("direct-mongodb-movie-findAll-id")
                .description("This route find all movies on mongodb")
                .to("mongodb:connectionBean?database=api&collection=movies&operation=findAll");

        from("direct:mongodb-movie-findByGender")
                .routeId("direct-mongodb-movie-findByGender-id")
                .description("This route find all movies on mongodb")
                .bean(MovieBean.class, "queryByGender")
                .to("mongodb:connectionBean?database=api&collection=movies&operation=findAll");
    }
}
