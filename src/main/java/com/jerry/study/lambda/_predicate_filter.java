package com.jerry.study.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 8400
 */
public class _predicate_filter {
    public static void main(String[] args){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "Jerry", "Jab12a");

        Predicate<String> startWithJ = str -> str.startsWith("J");
        languages.stream().filter(startWithJ).forEach(System.out::println);

        System.out.println();

        Predicate<String> endWithA = str -> str.endsWith("a");
        Predicate<String> longerThan4 = str -> str.length()>4;

        languages.stream().filter(startWithJ).filter(endWithA).filter(longerThan4).forEach(System.out::println);

        languages.stream().filter(startWithJ.and(endWithA).or(longerThan4)).forEach(System.out::println);

        List<String> languages2 = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "Jacoco");

        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter2(languages, (str)->str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter3(languages, (str)->str.length() > 4);

        System.out.println("start with J and longer than 4");
        Predicate<String> startWithj = str->str.startsWith("J");
        languages.stream().filter(startWithJ.and(str->str.length()>4)).forEach(System.out::println);
    }

    public static void filter(List<String> names, Predicate<String> condition){
        for(String name : names){
            if(condition.test(name)){
                System.out.println(name);
            }
        }
    }

    public static void filter2(List<String> names, Predicate<String> condition){
        names
            .stream()
            .filter((str)-> condition.test(str))
            .forEach(System.out::println);
    }

    public static void filter3(List<String> names, Predicate<String> condition){
        names
            .stream()
            .filter((str)->str.length()>4)
            .forEach(System.out::println);
    }

}


