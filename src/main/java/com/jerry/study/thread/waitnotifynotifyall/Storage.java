package com.jerry.study.thread.waitnotifynotifyall;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Storage
{
    private int[] cells = new int[10];
    private int inPos, outPos;
    private int count = 0;

    public static void main(String[] args) throws InterruptedException
    {
        Storage s = new Storage();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Input(s));
        exec.execute(new Output(s));

        TimeUnit.SECONDS.sleep(10);

        exec.shutdownNow();
    }

    public synchronized void put(int num) throws InterruptedException
    {
        while (count == cells.length)
        {
            wait();
        }

        cells[inPos] = num;
        System.out.println("in cells [" + inPos + "], save data " + num);
        inPos++;
        if (inPos == cells.length)
            inPos = 0;
        count++;
//        TimeUnit.SECONDS.sleep(1);
        notify();
    }

    public synchronized void get() throws InterruptedException
    {
        while (count == 0)
        {
            wait();
        }

        int data = cells[outPos];
        System.out.println("from cells [" + outPos + "], get " + data);
        cells[outPos] = 0;
        outPos++;
        if (outPos == cells.length)
        {
            outPos = 0;
        }
        count--;
//        TimeUnit.SECONDS.sleep(1);
        notify();
    }
}

class Input implements Runnable
{
    private Storage s;
    private int num = 0;

    public Input(Storage s)
    {
        this.s = s;
    }

    @Override
    public void run()
    {
        while (!Thread.interrupted())
        {
            try
            {
                s.put(num++);
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class Output implements Runnable
{
    private Storage s;

    public Output(Storage s)
    {
        this.s = s;
    }

    @Override
    public void run()
    {
        while (!Thread.interrupted())
        {
            try
            {
                s.get();
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
