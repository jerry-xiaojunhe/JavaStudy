package com.jerry.study.thread.interrupt;

public class InterruptedException {
    public static void main(String[] args) throws java.lang.InterruptedException {
        MyThread t = new MyThread();
        t.start();

        Thread.sleep(5000);

        t.interrupt();
    }
}

