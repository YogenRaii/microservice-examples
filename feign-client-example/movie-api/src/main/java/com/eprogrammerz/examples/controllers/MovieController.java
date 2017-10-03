package com.eprogrammerz.examples.controllers;

import com.eprogrammerz.examples.models.Movie;
import com.eprogrammerz.examples.repositories.MovieRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by rajkumar on 12/25/2016.
 */
@RestController
@Slf4j
public class MovieController {
    private final MovieRepositoryImpl movieRepositoryImpl;

    @Autowired
    public MovieController(MovieRepositoryImpl movieRepositoryImpl) {
        this.movieRepositoryImpl = movieRepositoryImpl;
    }

    @RequestMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {
        log.trace("getMovie({})", id);
        Optional<Movie> movieOptional = Optional.ofNullable(movieRepositoryImpl.findOneById(id));
        return movieOptional
                .map(movie -> {
                    Resource<Movie> movieResource = new Resource<>(movie);
                    movieResource.add(linkTo(methodOn(MovieController.class).getMovie(id)).withSelfRel());
                    return new ResponseEntity(movieResource, HttpStatus.OK);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}