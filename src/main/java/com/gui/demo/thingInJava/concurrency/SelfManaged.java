package com.gui.demo.thingInJava.concurrency;

/**
 * @Classname SelfManaged
 * @Description 通过调用适当的Thread 构造器为 Thread对象 赋予具体的名称
 * @Date 2021/7/19 17:11
 * @Created by gt136
 */
public class SelfManaged implements Runnable{
    private int countDown = 2;

    public SelfManaged() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() +"("+ countDown + "),";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new SelfManaged();
        }
    }
}
/*
output:Thread-X 代表第几个线程
Thread-2(5),
Thread-2(4),
Thread-2(3),
Thread-2(2),
Thread-2(1),
Thread-3(5),
Thread-3(4),
Thread-3(3),
Thread-3(2),
Thread-3(1),
Thread-0(5),
Thread-0(4),
Thread-0(3),
Thread-0(2),
Thread-0(1),
 */