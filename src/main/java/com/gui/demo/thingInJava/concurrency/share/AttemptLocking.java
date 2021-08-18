package com.gui.demo.thingInJava.concurrency.share;

import com.gui.demo.thingInJava.concurrency.Nap;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 并发库中的锁允许你放弃尝试获得一个锁
 * @Classname AttemptLocking
 * @Description ReentrantLock 的使用
 * @Date 2021/8/13 16:28
 * @Created by gt136
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimedLock() {
        //尝试获得锁
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        }finally {
            if (captured) {
                lock.unlock();
            }
        }
    }
    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2,TimeUnit.SECONDS): " + captured);
        }finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimedLock();
        al.timed();
        CompletableFuture.runAsync(() -> {
            al.lock.lock();
            System.out.println("acquired");
        });
        new Nap(0.2);
        al.untimedLock();
        al.timed();
    }
}
/*
output:
tryLock(): true
tryLock(2,TimeUnit.SECONDS): true
acquired
tryLock(): false
tryLock(2,TimeUnit.SECONDS): false
 */