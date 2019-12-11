package com.jerry.study._interface;

/**
 * @auther Jerry
 */
public class _defaultImpl {
    public static void main(String[] args) {
        classInDefaultImpl obj = new classInDefaultImpl();
        obj.show();
        classInDefaultImpl2 obj2 = new classInDefaultImpl2();
        obj2.show();
    }
}

class classInDefaultImpl implements interfaceTest{
    @Override
    public void show(){
        System.out.println("this is in the class");
    }
}

class classInDefaultImpl2 implements  interfaceTest{

}