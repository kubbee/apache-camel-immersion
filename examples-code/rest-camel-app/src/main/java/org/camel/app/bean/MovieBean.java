package org.camel.app.bean;

import com.mongodb.client.model.Filters;
import org.apache.camel.Exchange;
import org.apache.camel.component.mongodb.MongoDbConstants;
import org.camel.app.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieBean {

    public void getMovies(Exchange exchange){
    }

    public void queryByGender(Exchange exchange){
        exchange
                .getIn()
                .setHeader(MongoDbConstants.CRITERIA,
                           Filters.eq("gender",
                                   exchange.getIn().getHeader("gender", String.class)));
    }
}
