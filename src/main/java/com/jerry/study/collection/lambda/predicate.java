package com.jerry.study.collection.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 8400
 */
public class predicate {
    public static void main(String[] args){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "Jerry", "Jab12a");

        Predicate<String> startWithJ = str -> str.startsWith("J");
        languages.stream().filter(startWithJ).forEach(System.out::println);

        System.out.println();

        Predicate<String> endWithA = str -> str.endsWith("a");
        Predicate<String> longerThan4 = str -> str.length()>4;

        languages.stream().filter(startWithJ).filter(endWithA).filter(longerThan4).forEach(System.out::println);
    }
}
