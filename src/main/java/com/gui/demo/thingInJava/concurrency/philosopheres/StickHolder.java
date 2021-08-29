package com.gui.demo.thingInJava.concurrency.philosopheres;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Classname StickHolder
 * @Description 哲学家进餐
 * @Date 2021/8/25 15:21
 * @Created by gt136
 */
public class StickHolder {
    private static class Chopstick {

    }

    private Chopstick stick = new Chopstick();
    private BlockingQueue<Chopstick> holders = new ArrayBlockingQueue<>(1);

    public StickHolder() {
        putDown();
    }
    public void pickUp() {
        try {
            holders.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void putDown() {
        try {
            holders.put(stick);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
