package com.jerry.study.collection;

import java.util.Comparator;

/**
 * @auther Jerry
 */
public class _Comparator {
    public static void main(String[] args) {
        System.out.println(new StringLengthComparator().compare("111","22"));
    }
}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}