package com.eprogrammerz.examples.hystrix.client.services;

import com.eprogrammerz.examples.hystrix.client.domain.Movie;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Yogen on 12/31/2016.
 */
@Component
public class MovieApiFallback implements MovieApi {
    @Override
    public Movie getMovie(@PathVariable("id") Long id) {
        return new Movie("Avatar", "James Camerson", "8/10");
    }
}
