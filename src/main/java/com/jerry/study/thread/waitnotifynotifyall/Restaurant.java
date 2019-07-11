package com.jerry.study.thread.waitnotifynotifyall;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Restaurant
{
    Meal meal = new Meal(0);

    Chef chef = new Chef(this);
    WaitPerson waitPerson = new WaitPerson(this);

    ExecutorService exec = Executors.newCachedThreadPool();

    public Restaurant()
    {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args)
    {
        new Restaurant();
    }
}

class Chef implements Runnable
{
    private Restaurant r;

    public Chef(Restaurant r)
    {
        this.r = r;
    }

    @Override
    public void run()
    {
        int count = 0;
        try
        {
            while (!Thread.interrupted())
            {
                synchronized (this)
                {
                    while (r.meal != null)
                    {
                        wait();
                    }
                }

                if (++count == 10)
                {
                    System.out.println("Out of food, Closed");
                    r.exec.shutdownNow();
                }

                System.out.println("Order up!");
                synchronized (r.waitPerson)
                {
                    r.meal = new Meal(count);
                    r.waitPerson.notify();
                }

                TimeUnit.MILLISECONDS.sleep(100);
            }
        }
        catch (InterruptedException e)
        {

        }
    }
}

class WaitPerson implements Runnable
{
    private Restaurant r;

    public WaitPerson(Restaurant r)
    {
        this.r = r;
    }

    @Override
    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                synchronized (this)
                {
                    while (r.meal == null)
                    {
                        wait();
                    }
                }

                System.out.println("WaitPerson got " + r.meal);
                synchronized (r.chef)
                {
                    r.meal = null;
                    r.chef.notify();
                }

                TimeUnit.MILLISECONDS.sleep(100);
            }
        }
        catch (InterruptedException e)
        {

        }

    }
}

class Meal
{
    private int orderNum = 0;

    public Meal(int orderNum)
    {
        this.orderNum = orderNum;
    }

    @Override
    public String toString()
    {
        return "Meal " + orderNum;
    }
}
