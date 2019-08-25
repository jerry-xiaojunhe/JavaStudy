package com.jerry.study.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @auther Jerry
 */
public class _forEach {
    public static void main(String[] args) {
        //before java 8
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        // in java 8
        features.forEach(System.out::println);
    }
}
