package com.jerry.study.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Jerry
 */
public class _doubleColon {
    public static void main(String[] args){
        List<innerClass> lists = new ArrayList<>();
        lists.add(new innerClass("jerry"));
        lists.add(new innerClass("Tom"));

        lists.stream().map(innerClass::getName).forEach(System.out::println);
    }
}

class innerClass{
    public String name;
    public innerClass(String str){
        name = str;
    }
    public String getName(){
        return name;
    }
}