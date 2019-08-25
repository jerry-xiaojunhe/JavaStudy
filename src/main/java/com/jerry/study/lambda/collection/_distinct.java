package com.jerry.study.lambda.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaoj
 */
public class _distinct {
    //对集合进行去重
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
        distinct.forEach(System.out::println);
    }

}
