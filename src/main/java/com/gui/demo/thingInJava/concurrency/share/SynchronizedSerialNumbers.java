package com.gui.demo.thingInJava.concurrency.share;

/**
 * @Classname SynchronizedSerialNumbers
 * @Description TODO
 * @Date 2021/8/12 18:02
 * @Created by gt136
 */
public class SynchronizedSerialNumbers extends SerialNumbers {
    private int serialNumber = 0;
    @Override
    public synchronized int nextSerialNumber() {
        return serialNumber++;
    }

    public static void main(String[] args) {
        SerialNumberChecker.test(new SynchronizedSerialNumbers());
    }
}
/*
output:
No duplicate detected
 */