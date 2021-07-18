package com.gui.demo.thingInJava.concurrency;

/**
 * @Classname Test01
 * @Description TODO
 * @Date 2021/7/16 15:50
 * @Created by gt136
 */
public class Test01 implements Runnable{
    private static int taskCount;
    private final int id = taskCount++;

    public Test01() {
        System.out.println("Test01 started:id = " + id);
    }

    @Override
    public void run() {
        System.out.println("大话西游" + id);
        //
        Thread.yield();
        System.out.println("大话西游" + id);
        Thread.yield();
        System.out.println("大话西游" + id);
        Thread.yield();
        System.out.println("Test01 ended:id = " + id);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Test01()).start();
        }
    }
}
/*
output:
Test01 started:id = 0
Test01 started:id = 1
Test01 started:id = 2
大话西游0
大话西游2
大话西游0
大话西游1
大话西游1
大话西游1
Test01 ended:id = 1
大话西游0
大话西游2
Test01 ended:id = 0
大话西游2
Test01 ended:id = 2
 */
