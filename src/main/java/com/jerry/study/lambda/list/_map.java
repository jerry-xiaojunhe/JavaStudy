package com.jerry.study.lambda.list;

import java.util.Arrays;
import java.util.List;

/**
 * @author jerry
 */
public class _map {
    //map，它允许你改变你的对象

    public static void main(String[] args){
        List<Double> costBeforeTax = Arrays.asList(100D, 200D, 300D, 400D, 500D);

        // before java 8
        for(double a : costBeforeTax){
            double price = a + a*.12;
            System.out.println(price);
        }

        // in java 8
        costBeforeTax.stream().map((cost)->cost+cost*.12).forEach(System.out::println);


        System.out.println("print the costs");
        costBeforeTax.forEach(System.out::println);
    }
}
