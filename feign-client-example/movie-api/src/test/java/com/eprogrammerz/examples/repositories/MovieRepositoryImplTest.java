package com.eprogrammerz.examples.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Yogen on 12/25/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MovieRepositoryImplTest {

    @InjectMocks
    private MovieRepositoryImpl repository;

    @Test
    public void findOneByIdTest(){
        long bookId = 1202L;

        //verify results
        assertNotNull(String.format("Movie with id %s does not exist", bookId), repository.findOneById(bookId));
        assertEquals(repository.findOneById(bookId).getId(), 1202L);
        assertEquals(repository.findOneById(bookId).getName(), "Ulysses");

        //verify null is returned while non-existing id is passed.
        assertNull(repository.findOneById(1205L));
    }
}