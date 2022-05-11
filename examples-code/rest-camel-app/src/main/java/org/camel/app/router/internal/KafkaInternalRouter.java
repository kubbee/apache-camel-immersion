package org.camel.app.router.internal;

import org.apache.camel.builder.RouteBuilder;
import org.camel.app.bean.MovieKafkaBean;
import org.springframework.stereotype.Component;

@Component
public class KafkaInternalRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:send-movies-kafka")
                .routeId("direct-send-movies-kafka-id")
                .description("send movies for kafka topic")
                .bean(MovieKafkaBean.class, "getMovieKafka")
                .to("TopicMoviesKafka");

    }
}
