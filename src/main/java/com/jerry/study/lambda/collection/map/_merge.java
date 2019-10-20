package com.jerry.study.lambda.collection.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther Jerry
 */
public class _merge {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        List<String> words = Arrays.asList("aa", "bb", "cc", "aa", "cc");
        words.forEach(word -> {
                map.merge(word, 1, (previousValue, newValue) -> previousValue + newValue);
            }
        );

        System.out.println(map);
    }
}
