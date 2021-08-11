package com.gui.demo.thingInJava.concurrency.share;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname MuteEvenGenerator
 * @Description TODO
 * @Date 2021/8/10 14:40
 * @Created by gt136
 */
public class MuteEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EventChecker.test(new MuteEvenGenerator());
    }
}
