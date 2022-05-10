package org.camel.app.router.rest;

import org.apache.camel.builder.RouteBuilder;
import org.camel.app.model.Movie;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieRestRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/movies")
            .id("rest-movies-id")
            .get("/findAll")
                .id("rest-movies-findAll-id")
                .description("Get movies")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .to("direct:findAll-movies")

            .get("/findByGender")
                .id("rest-movies-findByGender-id")
                .description("Find Movie by Gender")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .to("direct:findByGender-movies")


            .post("/save")
                .id("rest-movies-save-id")
                .description("Receive a json and sends for save.")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .type(Movie.class)
                .to("direct:save-movie");
    }
}
