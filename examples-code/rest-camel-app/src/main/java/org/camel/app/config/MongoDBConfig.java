package org.camel.app.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MongoDBConfig {

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private String port;

    @Value("${mongodb.database}")
    private String database;

    @Value("${mongodb.username}")
    private String username;

    @Value("${mongodb.password}")
    private String password;

    @Bean("connectionBean")
    public MongoClient mongoClient(){
        MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
        ServerAddress serverAddress = new ServerAddress(host, Integer.parseInt(port));

        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .applyToClusterSettings(builder ->
                        builder.hosts(Arrays.asList(serverAddress)))
                .build();

        return MongoClients.create(settings);
    }
}
