package com.gui.demo.thingInJava.concurrency.share;

/**
 * @Classname SynchronizedGenerator
 * @Description 同步方法控制共享区域
 * @Date 2021/8/10 10:03
 * @Created by gt136
 */
public class SynchronizedGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    @Override
    public synchronized int next() {
        ++ currentEvenValue;
        Thread.yield();
        ++ currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EventChecker.test(new SynchronizedGenerator());
    }
}
