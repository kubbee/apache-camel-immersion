package tech.kubbee.camel_mongodb_app.route.internal;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MongoDBInternalRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        String connection= "";

        from("direct:mongodb-insert")
                .process(exchange -> {
                    String json = exchange.getIn().getBody(String.class);
                    System.out.println(json);
                })
                .convertBodyTo(String.class)
                .toD("mongodb:connectionBean?database=api&collection=movies&operation=insert");
    }
}
