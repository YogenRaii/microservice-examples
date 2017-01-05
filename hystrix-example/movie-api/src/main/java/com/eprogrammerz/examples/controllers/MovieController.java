package com.eprogrammerz.examples.controllers;

import com.eprogrammerz.examples.models.Movie;
import com.eprogrammerz.examples.repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by rajkumar on 12/25/2016.
 */
@RestController
@Slf4j
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/movies/{id}")
    public ResponseEntity<Movie> getBook(@PathVariable("id") Long id){
        log.trace("getBook({})",id);
        Optional<Movie> movieOptional = Optional.ofNullable(movieRepository.findOneById(id));
        return movieOptional.map(movie -> new ResponseEntity(movie, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }
}
