package com.jerry.study.thread.FutureCallable;

import java.util.concurrent.Callable;

/**
 * @author 8400
 */
public class Callables {
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int temp = 0;
        for(int i = 0; i<1000;i++){
            temp += i;
        }

        return temp;
    }
}
