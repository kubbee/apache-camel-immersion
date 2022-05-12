package org.camel.app.router.internal;

import org.apache.camel.builder.RouteBuilder;
import org.camel.app.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieInternalRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:save-movie")
            .routeId("direct-save-movie-id")
            .routeDescription("Send a movie to save on database.")
            .to("direct:mongodb-movie-insert");

        from("direct:findAll-movies")
                .routeId("direct-findAll-movies-id")
                .description("Find all movies on the database")
                .to("direct:mongodb-movie-findAll");

        from("direct:findByGender-movies")
                .routeId("direct-findByGender-movies-id")
                .description("Find all movies on the database")
                .to("direct:mongodb-movie-findByGender");


    }
}