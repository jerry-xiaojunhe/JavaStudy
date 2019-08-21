package com.jerry.study.lambda;

/**
 * @author jerry
 */
public class ReplaceAnonymousClassWithParm {
    public static void main(String[] args){
        int a;
        a = fun(new test(){
            @Override
            public int add(int a){
                return ++a;
            }
        }, 5);

        System.out.println(a);

        //todo: without anonymous class
    }

    public static int fun(test obj, int b){
        return obj.add(b);
    }
}

class test{
    public int add(int a){
        return a+10;
    }
}
