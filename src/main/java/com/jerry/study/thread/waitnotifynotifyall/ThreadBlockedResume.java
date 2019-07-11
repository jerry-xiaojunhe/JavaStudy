package com.jerry.study.thread.waitnotifynotifyall;

public class ThreadBlockedResume
{
    public static void main(String[] args) throws InterruptedException
    {
        myclass mc = new myclass();
        thread1 t1 = new thread1(mc);
        thread2 t2 = new thread2(mc);

        Thread T1 = new Thread(t1);
        Thread T2 = new Thread(t2);

        T1.start();
        Thread.sleep(10000);
        T2.start();
    }
}

class thread1 implements Runnable
{
    private static myclass obj;

    public thread1(myclass o)
    {
        obj = o;
    }

    @Override
    public void run()
    {
        try
        {
            synchronized (obj)
            {
                System.out.println("I am in the thread1 now");
                Thread.sleep(5000);
                System.out.println("Now thread1 is blocked");
                obj.wait();
                Thread.sleep(5000);
                System.out.println("Finally thread1 is resumed and running now");
            }
        }
        catch (Exception e)
        {

        }
    }
}

class thread2 implements Runnable
{
    private static myclass obj;

    public thread2(myclass o)
    {
        obj = o;
    }

    @Override
    public void run()
    {
        synchronized (obj)
        {
            System.out.println("Now i am thread2");
            System.out.println("thread2 finishes to run");
            obj.notifyAll();
            System.out.println("thread2 ends.");
        }
    }
}

class myclass
{
}
