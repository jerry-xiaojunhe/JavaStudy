package com.jerry.study.lambda.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Jerry
 */
public class _remove {
    public static void main(String[] args) {
        List<String> aaa = new ArrayList<>();
        aaa.add("abc");
        aaa.add("111");

        aaa.remove("abc");
        System.out.println(aaa);
    }
}
