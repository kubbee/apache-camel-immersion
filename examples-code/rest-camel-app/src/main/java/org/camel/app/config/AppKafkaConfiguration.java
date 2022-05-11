package org.camel.app.config;

import org.apache.camel.component.kafka.KafkaConfiguration;
import org.apache.camel.component.kafka.KafkaEndpoint;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.schemaregistry.serializer.WrapperKafkaAvroDeserializer;
import org.springframework.schemaregistry.serializer.WrapperKafkaAvroSerializer;

import io.confluent.kafka.serializers.subject.TopicRecordNameStrategy;

@Configuration
public class AppKafkaConfiguration {

    private KafkaEndpoint kafkaEndpoint;


    public KafkaConfiguration kafkaConfiguration() {
        final SchemaRegistryKafkaConfiguration configuration = new SchemaRegistryKafkaConfiguration();
        configuration.setAcks("all");
        configuration.setSecurityProtocol("SASL_SSL");
        configuration.setSaslJaasConfig("org.apache.kafka.common.security.plain.PlainLoginModule   required username='ABUYVNY36MQUCRFV'   password='wt4EjxrmIbYQPpU4WboDrgEtwL2mJ5HqECxEAoEtQVvJrRnGoZ8FU1k/QaXpDFQ5';");
        configuration.setSchemaRegistryURL("https://psrc-q25x7.us-east-2.aws.confluent.cloud");
        configuration.setSaslMechanism("PLAIN");
        configuration.setSessionTimeoutMs(45000);
        configuration.setBrokers("pkc-ymrq7.us-east-2.aws.confluent.cloud:9092");
        configuration.setSpecificAvroReader(true);
        configuration.setAutoRegisterSchemas(true);
        configuration.setAutoCommitEnable(false);
        configuration.setMaxPollIntervalMs(3000L);
        configuration.setGroupId("group-id");
        configuration.setValueSubjectNameStrategy(TopicRecordNameStrategy.class.getCanonicalName());
        configuration.setKeyDeserializer(StringDeserializer.class.getCanonicalName());
        configuration.setValueDeserializer(WrapperKafkaAvroDeserializer.class.getCanonicalName());

        return configuration;
    }



    @Bean("TopicMoviesKafka")
    public KafkaEndpoint kafkaMovie() {
        var configuration = kafkaConfiguration();
        configuration.setTopic("movies-kafka-ribas");
        kafkaEndpoint.setConfiguration(configuration);

        return kafkaEndpoint;
    }
}
