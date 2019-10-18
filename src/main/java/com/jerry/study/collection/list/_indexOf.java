package com.jerry.study.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Jerry
 */
public class _indexOf {
    public static void main(String[] args) {
        List<String> aaa = new ArrayList<>();
        aaa.add("abc");
        aaa.add("110");
        aaa.add("222");
        aaa.add("111");

        aaa.removeIf(o -> o.startsWith("1"));

        System.out.println(aaa.size());
        System.out.println(aaa.indexOf("222"));//1

    }
}
