package com.jerry.study.thread.interrupt;

public class MyThreadInterrupted {
    public static void main(String[] args){
        MyThread t = new MyThread();
        t.start();

        //Thread.sleep(5);

        // 两次都返回true，用户线程调用isInterrupted不会重置中断标志为false
        // 调用Thread.sleep()之后，两次都返回false, why?
        t.interrupt();
        System.out.println("第一次调用返回值： " + t.isInterrupted());
        System.out.println("第二次调用返回值： " + t.isInterrupted());
    }
}

