package com.jerry.study.generic;

public class GenericMethod {
    public <T> void show(T t){
        System.out.println(t);
    }

    public static void main(String[] args){
        GenericMethod tool = new GenericMethod();

        tool.show("hello");
        tool.show(12);
        tool.show(12.5);
    }
}
