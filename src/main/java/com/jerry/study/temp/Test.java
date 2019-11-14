package com.jerry.study.temp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther Jerry
 */
public class Test {
    public static void main(String[] args){
        System.out.println(File.separator);
        ThreadLocal<Integer> obj;

        List<String> a = new ArrayList<>();
        a.add("123");
        a.add("abcd");

        List<String> b = a.stream().filter(o -> {
            if(o.length()>3) return true;
            return false;
        }).collect(Collectors.toList());
        b.forEach(System.out::println);
    }
}
