package com.jerry.study.collection.lambda;

/**
 * @author 8400
 */
public class test {
    MathOperation add = new MathOperation() {
        @Override
        public int operation(int a, int b) {
            return a + b;
        }
    };

    MathOperation addByLambda = (a, b) -> a + b;

    GreetingOperation greet1 = a -> {return "hello " + a;};

    public static void main(String[] args){
        test t = new test();
        System.out.println(t.add.operation(1,2));
        System.out.println(t.doit(1,3,t.addByLambda));

        System.out.println(t.greet1.Greeting("tom"));
    }

    private int doit(int a, int b, MathOperation op){
        return op.operation(a,b);
    }
}

interface MathOperation {
    int operation(int a, int b);
}

interface GreetingOperation {
    String Greeting(String name);
}