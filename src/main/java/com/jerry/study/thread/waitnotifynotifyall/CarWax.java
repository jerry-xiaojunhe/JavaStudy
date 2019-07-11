package com.jerry.study.thread.waitnotifynotifyall;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CarWax
{
    public static void main(String[] args) throws InterruptedException{
        Car car = new Car();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new WaxOn(car));
        es.execute(new Buffer(car));
        TimeUnit.SECONDS.sleep(6);
        es.shutdownNow();
    }
}

class Car
{
    private boolean waxOn = false;

    // 上蜡，并通知下一个步骤
    public synchronized void waxed()
    {
        waxOn = true;
        notifyAll();
    }

    // 上完蜡，等待打磨
    public synchronized void waitforbuffering() throws InterruptedException
    {
        while (waxOn)
        {
            wait();
        }
    }

    // 打磨，并通知下一个步骤
    public synchronized void buffered()
    {
        waxOn = false;
        notifyAll();
    }

    // 打磨完，等待上蜡
    public synchronized void waitforwaxing() throws InterruptedException
    {
        while (!waxOn)
        {
            wait();
        }
    }
}

class WaxOn implements Runnable
{
    private Car car;

    public WaxOn(Car c)
    {
        car = c;
    }

    @Override
    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                System.out.println("wax on");
                TimeUnit.SECONDS.sleep(2);
                car.waxed();
                car.waitforbuffering();
            }
        }
        catch (InterruptedException e)
        {

        }
    }
}

class Buffer implements Runnable
{
    private Car car;

    public Buffer(Car c)
    {
        car = c;
    }

    @Override
    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                car.waitforwaxing();
                System.out.println("buffered");
                TimeUnit.SECONDS.sleep(2);
                car.buffered();
            }
        }
        catch (InterruptedException e)
        {

        }
    }
}
