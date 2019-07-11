package com.jerry.study.thread.interrupt;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupted
{
    public static void main(String[] args)
    {
        MyThread t = new MyThread();
        t.start();
        // Thread.interrupted()针对的是当前线程，当前线程是main，没有被中断，所以返回false
        System.out.println("第一次调用返回值： " + Thread.interrupted());
        System.out.println("第二次调用返回值： " + Thread.interrupted());

        // Thread.currentThread 就是当前线程main，所以被中断返回true，况且重置中断标志，再返回false
        // Thread.interrupted() 也可以换成Thread.currentThread.isInterrupted(), 返回两次true
        Thread.currentThread().interrupt();
//        System.out.println("第三次调用返回值： " + Thread.interrupted());
//        System.out.println("第四次调用返回值： " + Thread.interrupted());
        System.out.println("第三次调用返回值： " + Thread.currentThread().isInterrupted());
        System.out.println("第四次调用返回值： " + Thread.currentThread().isInterrupted());
    }
}