package org.camel.app.router.internal;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.component.kafka.KafkaProducer;
import org.camel.app.config.CustomKafkaConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class KafkaInternalRouter extends RouteBuilder {

    @Autowired
    private CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        KafkaComponent kafka = new KafkaComponent();
        kafka.setConfiguration(new CustomKafkaConfiguration().kafkaConfiguration());
        camelContext.addComponent("kafka", kafka);

        from("direct:send-movies-kafka")
                .routeId("direct-send-movies-kafka-id")
                .description("send movies for kafka topic")
                // Write pojo in avro format to kafka. Avro schema gets registered at schema-registry.
                //.to("kafka:movies-kafka-ribas?configuration=customKafkaConfiguration&brokers={{kafka.bootstrap.servers}}");
                //.to("kafka:movies-kafka-ribas?brokers={{kafka.bootstrap.servers}}");
                .to("kafka:movies-kafka-ribas");

    }
}
