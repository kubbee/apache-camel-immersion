package org.camel.app.router.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaComponent;
import org.camel.app.config.CustomKafkaConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class KafkaInternalRouter extends RouteBuilder {

    @Autowired
    private CamelContext camelContext;

    @Value("${direct.send.movies.kafka}")
    private String autoStartup;

    @Override
    public void configure() throws Exception {

        var configuration = new CustomKafkaConfiguration().kafkaConfiguration();
        configuration.setTopic("immersion-camel");

        KafkaComponent kafka = new KafkaComponent();
        kafka.setConfiguration(configuration);

        camelContext.addComponent("kafka", kafka);

        from("direct:immersion-camel")
                .routeId("direct-send-movies-kafka-id")
                .autoStartup(Boolean.valueOf(autoStartup))
                .description("send movies for kafka topic")
                .to("kafka:movies-kafka-ribas");
    }
}
