package com.jerry.study.lambda;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jerry
 */
public class ReplaceAnonymousClass {
    public static void main(String[] args) throws InterruptedException {
        // befor java 8
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(
            new Runnable() {
            @Override
            public void run() {
                System.out.println("this is thread " + Thread.currentThread());
            }
        });
        Thread.sleep(5000);

        // java 8
        exec.execute(() -> {
            int a = 10;
            int b = 0;
            for(int i = 0;i<a;i++){
                b += i;
            }

            System.out.println(b);
        });
        Thread.sleep(5000);
        exec.shutdownNow();
    }
}
