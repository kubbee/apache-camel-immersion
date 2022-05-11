package org.camel.app.bean;

import org.apache.camel.Exchange;
import org.camel.app.model.Movie;
import org.springframework.stereotype.Component;
import org.camel.app.model.MovieKafkaRibas;

@Component
public class MovieKafkaBean {

    public void getMovieKafka(Exchange exchange){
       var movie = exchange.getIn().getBody(Movie.class);
       var movieKafkaRibas = new MovieKafkaRibas(movie.getName(),movie.getGender());
       exchange.getIn().setBody(movieKafkaRibas);
    }
}
