package org.camel.app.router.rest;

import org.apache.camel.builder.RouteBuilder;
import org.camel.app.model.Movie;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class MovieRestRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/movies")
            .id("rest-movies-id")

            .post("/save")
                .id("rest-movies-save-id")
                .description("Receive a json and sends for save.")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .type(Movie.class)
                .to("direct:save-movie");
    }
}
