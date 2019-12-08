package com.jerry.study.collection.arrays;

import java.util.Arrays;

/**
 * @auther Jerry
 */
public class _equals {
    //Arrays.equals 方法检测相应的数组元素是否相等
    public static void main(String[] args) {

        String[] aa = {"1","abc"};
        String[] bb = {"abc", "1"};

        System.out.println(Arrays.equals(aa,bb));
    }
}
