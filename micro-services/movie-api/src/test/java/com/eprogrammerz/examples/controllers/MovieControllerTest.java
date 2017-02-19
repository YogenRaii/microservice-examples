package com.eprogrammerz.examples.controllers;

import com.eprogrammerz.examples.models.Movie;
import com.eprogrammerz.examples.repositories.MovieRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by 542596 on 2/19/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MovieControllerTest {
    private MovieController classUnderTest;

    private MovieRepository movieRepositoryMock;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

        movieRepositoryMock = Mockito.mock(MovieRepository.class);
        classUnderTest = new MovieController(movieRepositoryMock);
    }

    @After
    public void tearDown() throws Exception {
        classUnderTest = null;
    }

    @Test
    public void getBookReturnsBookObject() throws Exception {
        Movie movie = new Movie(1207, "Awesome Movie", "Me Myself", "4/5");
        Mockito.when(movieRepositoryMock.findOneById(Matchers.anyLong())).thenReturn(movie);

        ResponseEntity<Movie> responseEntity = classUnderTest.getMovie(1200L);
        System.out.println(responseEntity);
    }

}