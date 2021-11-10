package com.gui.demo.thingInJava.concurrency.share;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname AtomicityTest
 * @Description volatile 的使用：同步方法的使用
 * @Date 2021/8/10 16:54
 * @Created by gt136
 */
public class AtomicityTest implements Runnable{
    //
    private  int i = 0;

    public synchronized int getValue() {
        return i;
    }
    private synchronized void evenIncrement() {
        i++;
        i++;
    }
    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
