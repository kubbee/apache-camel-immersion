package org.camel.app.config;

import io.confluent.kafka.serializers.subject.TopicRecordNameStrategy;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Producer;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.component.kafka.KafkaConfiguration;
import org.apache.camel.component.kafka.KafkaEndpoint;
import org.apache.kafka.clients.NetworkClient;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.internals.DefaultPartitioner;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.camel.app.model.MovieKafkaRibas;
import org.eclipse.jetty.io.EndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.schemaregistry.serializer.WrapperKafkaAvroDeserializer;
import org.springframework.schemaregistry.serializer.WrapperKafkaAvroSerializer;
import org.camel.app.model.MovieKafkaRibas;

import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

@Configuration
public class CustomKafkaConfiguration {

    @Autowired
    private CamelContext camelContext;

    @Autowired
    private ProducerTemplate producerTemplate;

    public KafkaConfiguration kafkaConfiguration(){
        SchemaRegistryKafkaConfiguration configuration = new SchemaRegistryKafkaConfiguration();

        configuration.setRequestRequiredAcks("all");
        configuration.setSecurityProtocol("SASL_PLAINTEXT");
        configuration.setSaslJaasConfig("org.apache.kafka.common.security.plain.PlainLoginModule   required username='ABUYVNY36MQUCRFV'   password='wt4EjxrmIbYQPpU4WboDrgEtwL2mJ5HqECxEAoEtQVvJrRnGoZ8FU1k/QaXpDFQ5';");
        configuration.setSchemaRegistryURL("https://psrc-q25x7.us-east-2.aws.confluent.cloud");
        configuration.setSaslMechanism("PLAIN");
        configuration.setSessionTimeoutMs(45000);
        configuration.setBrokers("pkc-ymrq7.us-east-2.aws.confluent.cloud:9092");
        configuration.setSpecificAvroReader(true);
        configuration.setAutoCommitEnable(false);
        configuration.setMaxPollIntervalMs(3000L);
        configuration.setGroupId("group-id");
        configuration.setClientId("movies-id");
        configuration.setKeySerializer(StringSerializer.class.getCanonicalName());
        configuration.setValueSerializer(WrapperKafkaAvroSerializer.class.getCanonicalName());
        configuration.setKeyDeserializer(StringDeserializer.class.getCanonicalName());
        configuration.setValueDeserializer(WrapperKafkaAvroDeserializer.class.getCanonicalName());

        return configuration;
    }

    @Bean
    public KafkaEndpoint kafkaEndpoint() throws Exception {
        var kafkaConfiguration = kafkaConfiguration();
        kafkaConfiguration.setTopic("movies-kafka-ribas");

        KafkaComponent component  = new KafkaComponent();
        component.setConfiguration(kafkaConfiguration);

        KafkaEndpoint endpoint  =  new KafkaEndpoint("KafkaMovies", component);
        endpoint.setConfiguration(kafkaConfiguration);

        return endpoint;
    }

}
