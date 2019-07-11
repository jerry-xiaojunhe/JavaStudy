package com.jerry.study.thread.waitnotifynotifyall;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Blocker
{
    synchronized void waitingCall()
    {
        try
        {
            while (!Thread.interrupted())
            {
                wait();
                System.out.println("Thread: " + Thread.currentThread() + " is awake");
            }
        }
        catch (InterruptedException e)
        {

        }
    }

    synchronized void prod()
    {
        notify();
    }

    synchronized void prodAll()
    {
        notifyAll();
    }
}

class TaskInBlocker implements Runnable
{
    static Blocker blocker = new Blocker();

    @Override
    public void run()
    {
        blocker.waitingCall();
    }
}

class Task2InBlocker implements Runnable
{
    static Blocker blocker = new Blocker();

    @Override
    public void run()
    {
        blocker.waitingCall();
    }
}

class NotifyVSNotifyAll
{
    public static void main(String[] args) throws Exception
    {
        ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++)
        {
            es.execute(new TaskInBlocker());
        }

        es.execute(new Task2InBlocker());

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            boolean prod = true;

            @Override
            public void run()
            {
                if(prod)
                {
                    System.out.print("\nnotify ");
                    TaskInBlocker.blocker.prod();
                    prod = false;
                }
                else
                {
                    System.out.print("\nnotify all ");
                    TaskInBlocker.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400, 400);//run every 400ms

        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("Timer canceled");

        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Task2 block notify all");
        Task2InBlocker.blocker.prodAll();

        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Shutting down");
        es.shutdownNow();
    }
}
