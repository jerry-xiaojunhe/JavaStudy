package com.jerry.study.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiaoj
 */
public class _MethodReference {
    public static void main(String[] args){
        //不修改元素，可以用
        List<String> a = Arrays.asList("a","b");
        a.forEach(System.out::println);

        //修改元素
        a.forEach(s->System.out.println("* "+s+" *"));
    }
}
