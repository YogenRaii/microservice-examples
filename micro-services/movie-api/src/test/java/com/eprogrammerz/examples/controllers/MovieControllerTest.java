package com.eprogrammerz.examples.controllers;

import com.eprogrammerz.examples.models.Movie;
import com.eprogrammerz.examples.repositories.MovieRepositoryImpl;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by 542596 on 2/19/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MovieControllerTest {
    private MovieController classUnderTest;

    private MovieRepositoryImpl movieRepositoryImplMock;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();

        movieRepositoryImplMock = Mockito.mock(MovieRepositoryImpl.class);
        classUnderTest = new MovieController(movieRepositoryImplMock);
    }

    @After
    public void tearDown() throws Exception {
        classUnderTest = null;
    }

    @Test
    public void getBookReturnsBookObject() throws Exception {
        Movie movie = new Movie(1207, "Awesome Movie", "Me Myself", "4/5");
        Mockito.when(movieRepositoryImplMock.findOneById(Matchers.anyLong())).thenReturn(movie);

        ResponseEntity<Movie> responseEntity = classUnderTest.getMovie(1200L);

        assertThat("Code is 200.", responseEntity.getStatusCodeValue(), equalTo(200));
    }

}