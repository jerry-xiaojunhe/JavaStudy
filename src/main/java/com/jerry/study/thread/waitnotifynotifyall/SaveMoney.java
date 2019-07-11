package com.jerry.study.thread.waitnotifynotifyall;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SaveMoney
{
    private int balance = 0;

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    public synchronized void SaveCash(int cash) throws InterruptedException
    {
        if (this.getBalance() > 0)
        {
            System.out.println("save failed and wait, there still some money in your account, " + Thread.currentThread().getName());
            wait();
        }
        else
        {
            this.setBalance(cash);
            System.out.println("save successfully and notify, you have " + this.getBalance() + " left, " + Thread.currentThread().getName());
            notifyAll();
        }
    }

    public synchronized void DrewCash(int cash) throws InterruptedException
    {
        if (this.getBalance() < 0)
        {
            System.out.println("draw failed and wait, there still no money in your account, " + Thread.currentThread().getName());
            wait();
        }
        else
        {
            this.setBalance(cash);
            System.out.println("drew successfully and notify, you have " + this.getBalance() + " left, " + Thread.currentThread().getName());
            notifyAll();
        }
    }
}

class Save implements Runnable
{
    private SaveMoney sm;

    public Save(SaveMoney s)
    {
        sm = s;
    }

    public void run()
    {
        try
        {
            for (int i = 0; i < 10; i++)
            {
                sm.SaveCash(100);
                Thread.sleep(3000);
            }
        }
        catch (InterruptedException e)
        {

        }
    }
}

class Draw implements Runnable
{
    private SaveMoney sm;

    public Draw(SaveMoney s)
    {
        sm = s;
    }

    public void run()
    {
        try
        {
            for (int i = 0; i < 10; i++)
            {
                sm.DrewCash(-100);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {

        }
    }
}

class Ex
{
    public static void main(String[] args)
    {
        ExecutorService es = Executors.newCachedThreadPool();
        SaveMoney sm = new SaveMoney();
        es.execute(new Save(sm));
        es.execute(new Draw(sm));

    }
}
