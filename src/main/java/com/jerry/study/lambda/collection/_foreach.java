package com.jerry.study.lambda.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @author jerry
 */
public class _foreach {
    public static void main(String[] args){
        // in java8
        List<String> features = Arrays.asList("Lambdas", "Default Method",
            "Stream API", "Date and Time API");

        features.forEach((n)->System.out.println(n));

        System.out.println();

        features.forEach(System.out::println);
    }
}
