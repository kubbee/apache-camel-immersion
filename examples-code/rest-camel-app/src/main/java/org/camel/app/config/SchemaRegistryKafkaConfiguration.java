package org.camel.app.config;

import io.confluent.kafka.serializers.subject.TopicRecordNameStrategy;
import org.apache.camel.component.kafka.KafkaConfiguration;
import org.apache.kafka.clients.producer.internals.DefaultPartitioner;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.schemaregistry.serializer.WrapperKafkaAvroSerializer;

import java.util.Properties;

public class SchemaRegistryKafkaConfiguration extends KafkaConfiguration {
    @Override
    public Properties createProducerProperties() {
        Properties properties = new Properties();
        properties.setProperty("schema.registry.url", "https://psrc-q25x7.us-east-2.aws.confluent.cloud");
        properties.setProperty("bootstrap.servers", "pkc-ymrq7.us-east-2.aws.confluent.cloud:9092");
        properties.setProperty("client.dns.lookup", "");
        properties.setProperty("client.id", "custom-producer-id");
        properties.setProperty("key.serializer", StringSerializer.class.getCanonicalName());
        properties.setProperty("auto.register.schemas", "1");
        properties.setProperty("value.subject.name.strategy", "");
        properties.setProperty("key.subject.name.strategy", "");
        properties.setProperty("sasl.jaas.config", "");
        properties.setProperty("basic.auth.credentials.source", "USER_INFO");
        properties.setProperty("basic.auth.user.info", "ICT3Q2TRNO3E2AS4:3FV82GI9dfF1TAeq9iqkb3o8Xs+b0cZpYSA8wE2Rw0t72kOVOt4v0SO0Bm/Az+Yh");
        properties.setProperty("security.protocol", "SASL_SSL");
        properties.setProperty("sasl.mechanism", "PLAIN");
        properties.setProperty("acks", "all");
        properties.setProperty("auto.register.schemas", "true");
        properties.setProperty("value.subject.name.strategy", TopicRecordNameStrategy.class.getCanonicalName());
        properties.setProperty("key.subject.name.strategy", TopicRecordNameStrategy.class.getCanonicalName());
        properties.setProperty("batch.size", "16384");
        properties.setProperty("buffer.memory", "33554432");
        properties.setProperty("client.dns.lookup", "use_all_dns_ips");
        properties.setProperty("connections.max.idle.ms", "540000");
        properties.setProperty("delivery.timeout.ms", "120000");
        properties.setProperty("enable.idempotence", "false");
        properties.setProperty("linger.ms", "0");
        properties.setProperty("max.block.ms", "60000");
        properties.setProperty("max.in.flight.requests.per.connection", "5");
        properties.setProperty("max.request.size", "1048576");
        properties.setProperty("metadata.max.age.ms", "300000");
        properties.setProperty("metadata.max.idle.ms", "300000");
        properties.setProperty("metrics.num.samples", "2");
        properties.setProperty("metrics.recording.level", "INFO");
        properties.setProperty("metrics.sample.window.ms", "30000");
        properties.setProperty("partitioner.class", DefaultPartitioner.class.getCanonicalName());
        properties.setProperty("receive.buffer.bytes", "65536");
        properties.setProperty("reconnect.backoff.max.ms", "1000");
        properties.setProperty("reconnect.backoff.ms", "50");
        properties.setProperty("request.timeout.ms", "30000");
        properties.setProperty("retries", "0");
        properties.setProperty("retry.backoff.ms", "100");
        properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule   required username='ABUYVNY36MQUCRFV'   password='wt4EjxrmIbYQPpU4WboDrgEtwL2mJ5HqECxEAoEtQVvJrRnGoZ8FU1k/QaXpDFQ5';");
        properties.setProperty("sasl.login.refresh.buffer.seconds", "300");
        properties.setProperty("sasl.login.refresh.min.period.seconds", "60");
        properties.setProperty("sasl.login.refresh.window.factor", "0.8");
        properties.setProperty("sasl.login.refresh.window.jitter", "0.05");
        properties.setProperty("send.buffer.bytes", "131072");
        properties.setProperty("socket.connection.setup.timeout.max.ms", "30000");
        properties.setProperty("socket.connection.setup.timeout.ms", "10000");
        //properties.setProperty("ssl.enabled.protocols", "[TLSv1.2, TLSv1.3]");
        //properties.setProperty("ssl.endpoint.identification.algorithm", "http");
        //properties.setProperty("ssl.protocol", "TLSv1.3");
        properties.setProperty("transaction.timeout.ms", "60000");
        properties.setProperty("value.serializer", WrapperKafkaAvroSerializer.class.getCanonicalName());

        return properties;
    }

    @Override
    public Properties createConsumerProperties() {
        Properties properties = new Properties();
        properties.setProperty("schema.registry.url", "https://psrc-q25x7.us-east-2.aws.confluent.cloud");
        properties.setProperty("bootstrap.servers", "pkc-ymrq7.us-east-2.aws.confluent.cloud:9092");
        properties.setProperty("client.dns.lookup", "");
        properties.setProperty("client.id", "custom-consumer-id");
        properties.setProperty("key.serializer", StringSerializer.class.getCanonicalName());
        properties.setProperty("auto.register.schemas", "1");
        properties.setProperty("value.subject.name.strategy", "");
        properties.setProperty("key.subject.name.strategy", "");
        properties.setProperty("sasl.jaas.config", "");
        properties.setProperty("basic.auth.credentials.source", "USER_INFO");
        properties.setProperty("basic.auth.user.info", "ICT3Q2TRNO3E2AS4:3FV82GI9dfF1TAeq9iqkb3o8Xs+b0cZpYSA8wE2Rw0t72kOVOt4v0SO0Bm/Az+Yh");
        properties.setProperty("security.protocol", "SASL_SSL");
        properties.setProperty("sasl.mechanism", "PLAIN");
        properties.setProperty("acks", "all");
        properties.setProperty("auto.register.schemas", "true");
        properties.setProperty("value.subject.name.strategy", TopicRecordNameStrategy.class.getCanonicalName());
        properties.setProperty("key.subject.name.strategy", TopicRecordNameStrategy.class.getCanonicalName());
        properties.setProperty("batch.size", "16384");
        properties.setProperty("buffer.memory", "33554432");
        properties.setProperty("client.dns.lookup", "use_all_dns_ips");
        properties.setProperty("connections.max.idle.ms", "540000");
        properties.setProperty("delivery.timeout.ms", "120000");
        properties.setProperty("enable.idempotence", "false");
        properties.setProperty("linger.ms", "0");
        properties.setProperty("max.block.ms", "60000");
        properties.setProperty("max.in.flight.requests.per.connection", "5");
        properties.setProperty("max.request.size", "1048576");
        properties.setProperty("metadata.max.age.ms", "300000");
        properties.setProperty("metadata.max.idle.ms", "300000");
        properties.setProperty("metrics.num.samples", "2");
        properties.setProperty("metrics.recording.level", "INFO");
        properties.setProperty("metrics.sample.window.ms", "30000");
        properties.setProperty("partitioner.class", DefaultPartitioner.class.getCanonicalName());
        properties.setProperty("receive.buffer.bytes", "65536");
        properties.setProperty("reconnect.backoff.max.ms", "1000");
        properties.setProperty("reconnect.backoff.ms", "50");
        properties.setProperty("request.timeout.ms", "30000");
        properties.setProperty("retries", "0");
        properties.setProperty("retry.backoff.ms", "100");
        properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule   required username='ABUYVNY36MQUCRFV'   password='wt4EjxrmIbYQPpU4WboDrgEtwL2mJ5HqECxEAoEtQVvJrRnGoZ8FU1k/QaXpDFQ5';");
        properties.setProperty("sasl.login.refresh.buffer.seconds", "300");
        properties.setProperty("sasl.login.refresh.min.period.seconds", "60");
        properties.setProperty("sasl.login.refresh.window.factor", "0.8");
        properties.setProperty("sasl.login.refresh.window.jitter", "0.05");
        properties.setProperty("send.buffer.bytes", "131072");
        properties.setProperty("socket.connection.setup.timeout.max.ms", "30000");
        properties.setProperty("socket.connection.setup.timeout.ms", "10000");
        //properties.setProperty("ssl.enabled.protocols", "[TLSv1.2, TLSv1.3]");
        //properties.setProperty("ssl.endpoint.identification.algorithm", "http");
       //properties.setProperty("ssl.protocol", "TLSv1.3");
        properties.setProperty("transaction.timeout.ms", "60000");
        properties.setProperty("value.serializer", WrapperKafkaAvroSerializer.class.getCanonicalName());

        return properties;
    }
}
