package com.jerry.study.lambda.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther Jerry
 */
public class _computeIfPresent {
    public static void main(String[] args) throws CloneNotSupportedException {
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("str", 123);

        String a = "123";
        _computeIfPresent obj = new _computeIfPresent();
        _computeIfPresent obj2 = (_computeIfPresent)obj.clone();

        Integer x = myMap.computeIfPresent("str", null);
    }
}
