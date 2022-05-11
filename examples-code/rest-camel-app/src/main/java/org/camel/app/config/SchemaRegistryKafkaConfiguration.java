package org.camel.app.config;

import org.apache.camel.component.kafka.KafkaConfiguration;
import org.apache.camel.spi.UriParam;

import java.util.Objects;
import java.util.Properties;

public class SchemaRegistryKafkaConfiguration extends KafkaConfiguration {

    @UriParam(label = "confluent")
    private String schemaRegistryURL;

    @UriParam(label = "confluent")
    private boolean autoRegisterSchemas;

    @UriParam(label = "confluent")
    private String valueSubjectNameStrategy;

    @UriParam(label = "confluent")
    private String keySubjectNameStrategy;

    @UriParam(label = "confluent,consumer")
    private boolean specificAvroReader;

    @UriParam(label = "producer")
    private String acks;

    public String getSchemaRegistryURL() {
        return schemaRegistryURL;
    }

    public void setSchemaRegistryURL(final String schemaRegistryURL) {
        this.schemaRegistryURL = schemaRegistryURL;
    }

    public boolean isSpecificAvroReader() {
        return specificAvroReader;
    }

    public void setSpecificAvroReader(final boolean specificAvroReader) {
        this.specificAvroReader = specificAvroReader;
    }

    public void setAcks(final String acks) {
        this.acks = acks;
    }

    public String getAcks() {
        return acks;
    }

    public boolean isAutoRegisterSchemas() {
        return autoRegisterSchemas;
    }

    public void setAutoRegisterSchemas(final boolean autoRegisterSchemas) {
        this.autoRegisterSchemas = autoRegisterSchemas;
    }

    public String getValueSubjectNameStrategy() {
        return valueSubjectNameStrategy;
    }

    public void setValueSubjectNameStrategy(final String valueSubjectNameStrategy) {
        this.valueSubjectNameStrategy = valueSubjectNameStrategy;
    }

    public String getKeySubjectNameStrategy() {
        return keySubjectNameStrategy;
    }

    public void setKeySubjectNameStrategy(final String keySubjectNameStrategy) {
        this.keySubjectNameStrategy = keySubjectNameStrategy;
    }

    @Override
    public Properties createConsumerProperties() {
        final Properties properties = super.createConsumerProperties();
        addPropertyIfNotNull(properties, "schema.registry.url", getSchemaRegistryURL());
        addPropertyIfNotNull(properties, "specific.avro.reader", isSpecificAvroReader());
        addPropertyIfNotNull(properties, "auto.register.schemas", isAutoRegisterSchemas());
        addPropertyIfNotNull(properties, "value.subject.name.strategy", getValueSubjectNameStrategy());
        addPropertyIfNotNull(properties, "key.subject.name.strategy", getKeySubjectNameStrategy());
        addPropertyIfNotNull(properties, "basic.auth.credentials.source", "USER_INFO");
        addPropertyIfNotNull(properties, "basic.auth.user.info", "ICT3Q2TRNO3E2AS4:3FV82GI9dfF1TAeq9iqkb3o8Xs+b0cZpYSA8wE2Rw0t72kOVOt4v0SO0Bm/Az+Yh");
        return properties;
    }

    @Override
    public Properties createProducerProperties() {
        final Properties properties = super.createProducerProperties();
        addPropertyIfNotNull(properties, "schema.registry.url", getSchemaRegistryURL());
        addPropertyIfNotNull(properties, "acks", getAcks());
        addPropertyIfNotNull(properties, "auto.register.schemas", isAutoRegisterSchemas());
        addPropertyIfNotNull(properties, "value.subject.name.strategy", getValueSubjectNameStrategy());
        addPropertyIfNotNull(properties, "key.subject.name.strategy", getKeySubjectNameStrategy());
        addPropertyIfNotNull(properties, "basic.auth.credentials.source", "USER_INFO");
        addPropertyIfNotNull(properties, "basic.auth.user.info", "ICT3Q2TRNO3E2AS4:3FV82GI9dfF1TAeq9iqkb3o8Xs+b0cZpYSA8wE2Rw0t72kOVOt4v0SO0Bm/Az+Yh");
        return properties;
    }

    private static <T> void addPropertyIfNotNull(final Properties properties, final String key, final T value) {
        if (Objects.nonNull(value)) {
            properties.put(key, value);
        }
    }

}
