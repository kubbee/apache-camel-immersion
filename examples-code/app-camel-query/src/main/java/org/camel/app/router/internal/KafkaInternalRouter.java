package org.camel.app.router.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaComponent;
import org.camel.app.config.CustomKafkaConfiguration;
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

        from("kafka:movies-kafka-ribas")
                .routeId("direct-send-movies-db-id")
                .description("send movies for kafka topic")
                .to("direct:mongodb-movie-insert");
    }
}
