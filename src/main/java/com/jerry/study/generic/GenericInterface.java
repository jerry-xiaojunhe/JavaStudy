package com.jerry.study.generic;

import java.util.List;

public interface GenericInterface<T> {
    public abstract void show(T t);
}

class InterImpl implements GenericInterface<String>{

    @Override
    public void show(String s) {
        System.out.println(s);
    }

    public static void main(String[] args){
        InterImpl obj = new InterImpl();
        obj.show("abc");
    }
}

class InterImpl2<T> implements GenericInterface<T>{

    @Override
    public void show(T t) {
        System.out.println(t);
    }

    public static void main(String[] args){
        InterImpl2<String> obj = new InterImpl2<>();
        obj.show("abcd");

        InterImpl2<Integer> obj2 = new InterImpl2<>();
        obj2.show(1000);
    }
}
