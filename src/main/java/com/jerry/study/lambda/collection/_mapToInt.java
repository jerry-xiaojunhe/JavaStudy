package com.jerry.study.lambda.collection;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @auther Jerry
 */
public class _mapToInt {
    //IntStream
    public static void main(String[] args){
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

        System.out.println("IntStream");
        IntStream ints = primes.stream().mapToInt(x->x+1);

        ints.forEach(System.out::println);

        IntSummaryStatistics stats = primes.stream().mapToInt(x->x+1).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());

        System.out.println();

        System.out.println("sum");
        System.out.println(primes.stream().mapToInt(Integer::intValue).sum());
    }
}
