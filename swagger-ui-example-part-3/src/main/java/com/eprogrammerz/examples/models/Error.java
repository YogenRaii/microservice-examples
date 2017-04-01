package com.eprogrammerz.examples.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Yogen on 4/1/2017.
 */
@Getter
@AllArgsConstructor
public class Error {
    private int errorCode;
    private String message;
}
