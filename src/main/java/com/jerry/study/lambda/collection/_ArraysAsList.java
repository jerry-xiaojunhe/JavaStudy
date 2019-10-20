package com.jerry.study.lambda.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiaoj
 */
public class _ArraysAsList {
    public static void main(String[] args){
        List<String> l = Arrays.asList("ab","cd");

        l.forEach(s -> System.out.println(s));

        System.out.println();

        l.forEach(System.out::println);
    }
}
