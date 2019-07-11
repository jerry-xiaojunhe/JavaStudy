package com.jerry.study.thread.FutureCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 8400
 */
public class Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        java.util.concurrent.Future<Integer> result = exec.submit(new Task());
        while(!result.isDone()){}

        System.out.println(result.get());
        exec.shutdownNow();
    }
}