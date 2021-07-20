package com.gui.demo.thingInJava.concurrency;

import java.util.concurrent.TimeUnit;

import static com.gui.demo.thingInJava.concurrency.Print.*;
/**
 * @Classname SimpleDeamons
 * @Description 后台进程
 * @Date 2021/7/19 15:46
 * @Created by gt136
 */
public class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(500);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            print("sleep() interrupted");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            //设置它为后台进程在这个线程开始之前
            daemon.setDaemon(true);
            daemon.start();
        }

        print("All daemons started ");
        try {
            TimeUnit.MILLISECONDS.sleep(1750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*
output:
All daemons started
Thread[Thread-8,5,main] SimpleDaemons@11f3ef5e
Thread[Thread-5,5,main] SimpleDaemons@f2733ba
Thread[Thread-0,5,main] SimpleDaemons@6b52350c
Thread[Thread-1,5,main] SimpleDaemons@42337127
Thread[Thread-7,5,main] SimpleDaemons@2d74268a
Thread[Thread-6,5,main] SimpleDaemons@60cb300b
Thread[Thread-9,5,main] SimpleDaemons@1fe9b76c
Thread[Thread-3,5,main] SimpleDaemons@7e7e475e
Thread[Thread-2,5,main] SimpleDaemons@47c48106
Thread[Thread-4,5,main] SimpleDaemons@c622f0c
 */