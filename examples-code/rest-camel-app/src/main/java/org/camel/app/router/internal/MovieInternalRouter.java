package org.camel.app.router.internal;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JacksonXMLDataFormat;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.camel.app.bean.MovieBean;
import org.camel.app.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieInternalRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:save-movie")
            .routeId("direct-save-movie-id")
            .routeDescription("Send a movie to save on database.")
            .convertBodyTo(Movie.class)
            .wireTap("direct:send-movies-kafka")
            .marshal().json(JsonLibrary.Jackson, Movie.class)
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