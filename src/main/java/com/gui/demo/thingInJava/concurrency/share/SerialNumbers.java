package com.gui.demo.thingInJava.concurrency.share;

/**
 * @author gt136
 * @Classname SerialNumbers
 * @Description 产生序列号
 * @Date 2021/8/12 17:28
 * @Created by gt136
 */
public class SerialNumbers {
    private volatile int serialNumber = 0;
    public int nextSerialNumber() {
        return serialNumber++;
    }
}
