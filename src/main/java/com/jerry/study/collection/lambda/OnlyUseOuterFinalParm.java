package com.jerry.study.collection.lambda;

/**
 * @author 8400
 */
public class OnlyUseOuterFinalParm {
    final static int outerA = 10;

    public static void main(String[] args){
        final int outerB = 20;
        testOuterFinalParm<Integer, String> testOuterFinalParm1 = (a, b) -> {return a+b+outerA+outerB;};
        System.out.println(testOuterFinalParm1.operation(1,2));
    }

    interface testOuterFinalParm<T1 extends Number, T2>{
        T1 operation(T1 a, T1 b);
    }
}