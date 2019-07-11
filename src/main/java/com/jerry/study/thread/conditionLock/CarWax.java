package com.jerry.study.thread.conditionLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarWax
{
    public static void main(String[] args) throws InterruptedException
    {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

class Car
{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;

    public void waxed()
    {
        lock.lock();
        try
        {
            waxOn = true;
            condition.signal();
        }
        finally
        {
            lock.unlock();
        }
    }

    public void waitForBuffered()
    {
        lock.lock();
        try
        {
            while (waxOn)
            {
                condition.await();
            }
        }
        catch (InterruptedException e)
        {

        }
        finally
        {
            lock.unlock();
        }
    }

    public void buffered()
    {
        lock.lock();
        try
        {
            waxOn = false;
            condition.signal();
        }
        finally
        {
            lock.unlock();
        }
    }

    public void waitForWaxing()
    {
        lock.lock();
        try
        {
            while (!waxOn)
            {
                condition.await();
            }
        }
        catch (InterruptedException e)
        {

        }
        finally
        {
            lock.unlock();
        }
    }
}

class WaxOn implements Runnable
{
    Car car;

    public WaxOn(Car car)
    {
        this.car = car;
    }

    @Override
    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                System.out.println("waxed");
                car.waxed();
                car.waitForBuffered();
            }
        }
        catch (Exception e)
        {

        }
    }
}

class WaxOff implements Runnable
{
    Car car;

    public WaxOff(Car car)
    {
        this.car = car;
    }

    @Override
    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                car.waitForWaxing();
                System.out.println("buffered");
                car.buffered();
            }
        }
        catch (Exception e)
        {

        }
    }
}
