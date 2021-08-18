package com.gui.demo.thingInJava.concurrency.share;

import com.gui.demo.thingInJava.concurrency.TimedAbort;
import com.gui.demo.thingInJava.concurrency.share.AtomicityTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AtomicIntegerTest
 * @Description TODO
 * @Date 2021/8/12 21:36
 * @Created by gt136
 */
public class AtomicIntegerTest implements Runnable{
    private AtomicInteger i = new AtomicInteger(0);
    public int getAsInt() {
        return i.get();
    }

    public void evenIncrement() {
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
            if (getAsInt() % 2 != 0) {
                System.out.println(getAsInt());
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        new TimedAbort(4, "No odd numbers discovered");
    }
}
/*
output:
No odd numbers discovered
 */