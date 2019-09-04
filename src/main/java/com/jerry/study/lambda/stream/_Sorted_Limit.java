package com.jerry.study.lambda.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiaoj
 */
public class _Sorted_Limit {
    public static void main(String[] args){
        List<Integer> integers = Arrays.asList(4, 5, 6,1, 2, 3,7, 8,8,9,10);

        integers.stream().sorted().limit(5).forEach(System.out::println);
    }
}
