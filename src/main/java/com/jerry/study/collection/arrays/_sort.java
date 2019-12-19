package com.jerry.study.collection.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @auther Jerry
 */
public class _sort {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("11");
        a.add("s");

        a.sort(new StringLengthComparator());
        System.out.println(a);

        System.out.println();

        String[] b = {"11","s"};
        Arrays.sort(b, new StringLengthComparator());
        Arrays.stream(b).forEach(System.out::println);

        System.out.println();

        System.out.println(new StringLengthComparator().compare("111","22"));

        System.out.println(1030/1600D);
    }
}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}