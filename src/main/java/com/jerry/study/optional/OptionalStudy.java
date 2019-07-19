package com.jerry.study.optional;

import java.util.Optional;

/**
 * @auther xiaojun.he
 */
public class OptionalStudy {

    public static void main(String[] args){

        TestClass a = new TestClass(1);

        Optional<TestClass> opt = Optional.of(a);

        TestClass b = opt.get();

        System.out.println(a.equals(b));
    }
}
class TestClass{
    public int a;

    public TestClass(int aa){
        a = aa;
    }

    public int getA(){return a;}

    public Object getObj() {
        return Integer.valueOf(2);
    }
}