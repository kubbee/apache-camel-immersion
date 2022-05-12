package org.camel.app.router.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.camel.app.config.CustomKafkaConfiguration;
import org.camel.app.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class KafkaInternalRouter extends RouteBuilder {

    @Autowired
    private CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        var configuration = new CustomKafkaConfiguration().kafkaConfiguration();
        configuration.setTopic("movies-kafka-ribas");

        KafkaComponent kafka = new KafkaComponent();
        kafka.setConfiguration(configuration);

        camelContext.addComponent("kafka", kafka);

        from("direct:send-movies-kafka")
                .routeId("direct-send-movies-kafka-id")
                .description("send movies for kafka topic")
                .to("kafka:movies-kafka-ribas");
    }
}