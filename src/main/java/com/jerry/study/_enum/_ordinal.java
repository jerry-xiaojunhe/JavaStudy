package com.jerry.study._enum;

/**
 * @auther Jerry
 */
public class _ordinal {
    public static void main(String[] args){
        testEnum test = testEnum.B;
        System.out.println(test.ordinal());
        
    }
}

enum testEnum{
    A,
    B,
}
