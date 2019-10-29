package com.jerry.study.lambda.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther Jerry
 */
public class _computeIfAbsent {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("4", 100);
        for (int i = 0; i < 5; i++) {
            int x = i;
            Integer subMap = myMap.computeIfAbsent(String.valueOf(i), k -> x);
        }

        for(String key: myMap.keySet()){
            System.out.println(key + ":" + myMap.get(key));
        }
    }
}
