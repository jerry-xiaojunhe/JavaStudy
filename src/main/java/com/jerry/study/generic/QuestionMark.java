package com.jerry.study.generic;

import java.util.ArrayList;
import java.util.List;

public class QuestionMark {
    // <>中的类型只能是Number的 子类 或者 自身
    public static void test(List<? extends Number> list){}

    // <>中的类型只能是B的 父类 或者 B
    public static void testSuper(List<? super B> list){}

    public static void main(String[] args){
        List<Integer> integer = new ArrayList<>();
        test(integer);

        List<String> strings = new ArrayList<>();

        // 编译报错
        //test(strings);

        List<A> As = new ArrayList<>();
        testSuper(As);
        List<B> Bs = new ArrayList<>();
        testSuper(Bs);

        // 编译报错
        //List<C> Cs = new ArrayList<>();
        //testSuper(Cs);
    }
}

class A{}
class B extends A{}
class C extends B{}
