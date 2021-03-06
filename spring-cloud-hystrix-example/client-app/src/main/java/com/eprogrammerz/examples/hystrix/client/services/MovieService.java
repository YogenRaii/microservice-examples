package com.eprogrammerz.examples.hystrix.client.services;

import com.eprogrammerz.examples.hystrix.client.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Yogen on 12/25/2016.
 */
@Service
public class MovieService {

    @Autowired
    MovieApi movieApi;

    public Movie findMovie(Long id) {
        Movie movieOfTheDay = movieApi.getMovie(id);
        return movieOfTheDay;
    }
}
