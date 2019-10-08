package com.jerry.study.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Jerry
 */
public class _retainAll {
    public static void main(String[] args) {
        //取交集，a = "a", "b"
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("d");
        List<String> b = new ArrayList<>();
        b.add("a");
        b.add("b");
        b.add("c");
        boolean c = a.retainAll(b);
        System.out.println(c);
    }
}
