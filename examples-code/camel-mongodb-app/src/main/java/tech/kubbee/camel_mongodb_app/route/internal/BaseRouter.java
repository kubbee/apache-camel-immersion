package tech.kubbee.camel_mongodb_app.route.internal;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;
import tech.kubbee.camel_mongodb_app.bean.MovieBean;
import tech.kubbee.camel_mongodb_app.model.Movie;

@Component
public class BaseRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:hello?period={{timer.period}}")
                .routeId("hello")
                .bean(MovieBean.class, "getMovie")
                .marshal().json(JsonLibrary.Jackson, Movie.class)
                .to("direct:mongodb-insert")
                .end();
    }
}
