package org.camel.app.router.rest;

import ch.qos.logback.core.rolling.helper.ArchiveRemover;
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

            .get("/all")
                .id("rest-movies-byId-id")
                .description("Get movie byId")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_ATOM_XML_VALUE)

                .outType(Movie.class)
                .to("direct:all")

            .post("/save")
                .id("rest-movies-save")
                .description("Save movie")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)

                .type(Movie.class)
                .to("direct:all");
    }
}
