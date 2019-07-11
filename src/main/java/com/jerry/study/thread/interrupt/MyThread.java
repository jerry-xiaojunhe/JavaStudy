package com.jerry.study.thread.interrupt;

import java.util.concurrent.TimeUnit;

public class MyThread extends Thread
{
    public void run()
    {
        try
        {
            for (int i = 0; i < 50000; i++)
            {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("i = " + i);
            }
        }
        catch (Exception e)
        {
            System.out.println("Interrupted in Thread1.");
        }
    }
}
