package com.jerry.study.thread.FutureCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 8400
 */
public class FutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        java.util.concurrent.FutureTask<Integer> futureTask = new java.util.concurrent.FutureTask<>(new Task());
        exec.submit(futureTask);
        while(!futureTask.isDone()){}
        System.out.println(futureTask.get());
        exec.shutdownNow();
    }
}
