package org.camel.app.router.internal;

import org.apache.camel.builder.RouteBuilder;
import org.camel.app.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieInternalRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        /*
         * TODO: Esta tora não esta mais sendo envia para o mongodb como eu volto a fazer isto;
         *
         * TODO: Agora para enviar ao kafka o melhor é ser depois que dado foi persistido, como faço isso?
         */
        from("direct:save-movie")
            .routeId("direct-save-movie-id")
            .routeDescription("Send a movie to save on database.")
            .convertBodyTo(Movie.class)
            .to("direct:send-movies-kafka");
            //.marshal().json(JsonLibrary.Jackson, Movie.class)
            //.to("direct:mongodb-movie-insert");

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