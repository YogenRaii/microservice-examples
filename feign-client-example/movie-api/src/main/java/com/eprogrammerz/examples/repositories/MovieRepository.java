package com.eprogrammerz.examples.repositories;

/**
 * Created by 542596 on 2/19/2017.
 */
@FunctionalInterface
public interface MovieRepository<T,R> {
    R findOneById(T t);
}
