package it;

import static org.mockito.Mockito.mock;

/**
 * @auther xiaojun.he
 */
public class TestClass {
    public void printSth(String sth){
        System.out.println(sth);
    }

    public int add(int a, int b){
        return a+b;
    }

    public innerclass get(){
        return new innerclass();
    }

    class innerclass{

    }
}

class Main{
    public static void main(String[] args){
        TestClass.innerclass obj = mock(TestClass.innerclass.class);
    }
}
