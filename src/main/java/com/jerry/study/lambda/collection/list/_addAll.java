package com.jerry.study.lambda.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Jerry
 */
public class _addAll {
    public static void main(String[] args){
        List<String> aaa = new ArrayList<>();
        aaa.add("abc");
        aaa.add("111");
        List<String> bbb = new ArrayList<>();
        bbb.add("111");
        bbb.add("222");

        aaa.addAll(bbb); // "abc", "111", "111", "222"

        List<Person> ps = new ArrayList<>();
        List<Person> ps2 = new ArrayList<>();
    }

    class Person {
    }
}
