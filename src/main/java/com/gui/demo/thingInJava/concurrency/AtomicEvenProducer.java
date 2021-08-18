package com.gui.demo.thingInJava.concurrency;

import com.gui.demo.thingInJava.concurrency.share.EventChecker;
import com.gui.demo.thingInJava.concurrency.share.IntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname AtomicEvenProducer
 * @Description TODO
 * @Date 2021/8/12 22:09
 * @Created by gt136
 */
public class AtomicEvenProducer extends IntGenerator {
    private AtomicInteger currentValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EventChecker.test(new AtomicEvenProducer());

    }
}
/*
output:
No odd numbers discovered
 */