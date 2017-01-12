package com.eprogrammerz.examples.controllers;

import com.eprogrammerz.examples.domain.Movie;
import com.eprogrammerz.examples.services.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by Yogen on 12/25/2016.
 */
@RestController
@Slf4j
public class RequestController {
    @Autowired
    private MovieService movieService;

    @RequestMapping("/recommended")
    public ResponseEntity<Movie> getRecommendedMovie(){
        long movieOfTheDayId = getLuckyMovieId();
        log.info("Calling MovieService:findMovie({})", movieOfTheDayId);
        Movie movieRecommended = movieService.findMovie(movieOfTheDayId);
        return new ResponseEntity<>(movieRecommended, HttpStatus.OK);
    }

    /**
     * Helper method to provide the random long number
     * @return long number between 1200 and 1
     */
    private long getLuckyMovieId(){

        long id = (int)(new Random().nextDouble() * 4) + 1200;
        return id;
    }
}
