package org.camel.app.config;

import org.apache.camel.component.kafka.KafkaConfiguration;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomKafkaConfiguration {

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

        // Serializer
        configuration.setKeySerializer(StringSerializer.class.getCanonicalName());
        configuration.setValueSerializer(StringSerializer.class.getCanonicalName());

        // Deserializer
        configuration.setKeyDeserializer(StringDeserializer.class.getCanonicalName());
        configuration.setValueDeserializer(StringDeserializer.class.getCanonicalName());

        return configuration;
    }
}
