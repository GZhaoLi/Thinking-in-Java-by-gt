package com.gui.demo.thingInJava.concurrency.share;

import com.gui.demo.thingInJava.concurrency.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * @author gt136
 * @Classname SerialNumberChecker
 * @Description 通过线程安全的方式获取序列号
 * @Date 2021/8/12 17:51
 * @Created by gt136
 */
public class SerialNumberChecker implements Runnable {
    private CircularSet serials = new CircularSet(1000);
    private SerialNumbers producer;

    public SerialNumberChecker(SerialNumbers producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            int serial = producer.nextSerialNumber();
            if (serials.contains(serial)) {
                System.out.println("Duplicate: " + serial);
                System.exit(0);
            }
            serials.add(serial);
        }
    }

    static void test(SerialNumbers producer) {
        for (int i = 0; i < 10; i++) {
            CompletableFuture.runAsync(new SerialNumberChecker(producer));
        }
        new Nap(4, "No duplicate detected");
    }
}
