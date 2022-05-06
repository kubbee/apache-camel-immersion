package org.camel.app.router.internal;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JacksonXMLDataFormat;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.camel.app.bean.MovieBean;
import org.camel.app.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieInternalRouter extends RouteBuilder {

    JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
    @Override
    public void configure() throws Exception {

        from("direct:all")
            .routeId("dircet-all-id")
            .routeDescription("Get the information on the database")
            .bean(new MovieBean(), "getMovies")
            .log("${body}");
    }
}
