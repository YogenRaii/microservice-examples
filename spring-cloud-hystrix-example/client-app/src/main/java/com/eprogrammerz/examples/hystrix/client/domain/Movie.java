package com.eprogrammerz.examples.hystrix.client.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Yogen on 12/25/2016.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Movie implements Serializable {
    private static final long serialVersionUID = 2281585426839510707L;
    private String name;
    private String directorName;
    private String rating;
}
