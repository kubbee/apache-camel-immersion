package org.camel.app.router.internal;

import org.apache.camel.builder.RouteBuilder;
import org.camel.app.bean.MovieBean;
import org.springframework.stereotype.Component;

@Component
public class MovieInternalRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:all")
            .routeId("dircet-all-id")
            .routeDescription("Get the information on the database")
            .bean(new MovieBean(), "getMovies");
    }
}
