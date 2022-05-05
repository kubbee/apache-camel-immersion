package org.camel.app.bean;

import org.camel.app.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieBean {

    public List<Movie> getMovies(){
        List<Movie> movies = new ArrayList<>();

        for(int a=0; a<=10; a++){
            Movie m = new Movie();
            m.setNome("Filme ".concat(String.valueOf(a)));
            m.setGenero("Ação");

            movies.add(m);
        }

        return movies;
    }
}
