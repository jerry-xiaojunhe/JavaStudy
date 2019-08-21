package com.jerry.study.lambda.list;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author jerry
 */
public class _predicate {
    public static void main(String[] args){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "Jacoco");

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
        Predicate<String> startWithJ = str->str.startsWith("J");
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
