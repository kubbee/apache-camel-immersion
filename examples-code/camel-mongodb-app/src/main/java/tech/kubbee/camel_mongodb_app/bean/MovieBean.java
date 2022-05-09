package tech.kubbee.camel_mongodb_app.bean;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;
import tech.kubbee.camel_mongodb_app.model.Movie;

@Component
public class MovieBean {

    public void getMovie(Exchange exchange){
        Movie m = new Movie();
        m.setName("Harry Potter e o Enigma do Principe");
        m.setGender("Ficção");

        exchange.getMessage().setBody(m);
    }
}
