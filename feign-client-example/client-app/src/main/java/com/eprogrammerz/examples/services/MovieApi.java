package com.eprogrammerz.examples.services;

import com.eprogrammerz.examples.domain.Movie;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Yogen on 12/26/2016.
 */
@FeignClient(name = "movie-api")
public interface MovieApi {
    @RequestMapping(method = RequestMethod.GET, value = "/movies/{id}")
    Movie getMovie(@PathVariable("id") Long id);
}


