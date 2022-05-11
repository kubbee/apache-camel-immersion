package org.camel.app.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.camel.Exchange;
import org.camel.app.model.Movie;
import org.camel.app.model.MovieKafkaRibas;
import org.springframework.stereotype.Component;

/*
 *   TODO:  Esta class não precisamos mais usa-la por que não iremos converter o content para avro; como retirar do código?
 */

@Component
public class MovieKafkaBean {

    /*
    public void getMovieKafka(Exchange exchange) throws JsonProcessingException {
       var movie = exchange.getIn().getBody(Movie.class);

        var movieKafkaRibas = new MovieKafkaRibas(movie.getName(), movie.getGender());
        exchange.getIn().setBody(movieKafkaRibas);
    }
    */

    public void getMovieKafka(Exchange exchange) {
        var movie = exchange.getIn().getBody(Movie.class);
        exchange.getIn().setBody(movie);
    }
}
