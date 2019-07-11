package com.jerry.study.collection.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author 8400
 */
public class foreach {
    public static void main(String[] args){
        List<String> l = Arrays.asList("ab","cd");

        l.forEach(s -> System.out.println(s));

        System.out.println();

        l.forEach(System.out::println);
    }
}
