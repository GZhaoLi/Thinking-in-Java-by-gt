package com.gui.demo.thingInJava.concurrency.share;

import com.gui.demo.thingInJava.concurrency.Nap;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname SynchronizedComparison
 * @Description 不同的同步方法竞争调用method
 * @Date 2021/8/13 9:30
 * @Created by gt136
 */
abstract class Guarded {
    AtomicLong callCount = new AtomicLong();

    public abstract void method();

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + callCount.get();
    }
}

class SynchronizedMethod extends Guarded {

    @Override
    public synchronized void method() {
        new Nap(0.01);
        //因此父类字段没有private，所以子类可以读取到父类的字段
        callCount.incrementAndGet();
    }
}

class CriticalSection extends Guarded {

    @Override
    public void method() {
        new Nap(0.01);
        synchronized (this) {
            callCount.incrementAndGet();
        }
    }
}

class Caller implements Runnable {
    private Guarded g;

    Caller(Guarded g) {
        this.g = g;
    }
    private AtomicLong successfulCalls = new AtomicLong();
    private AtomicBoolean stop = new AtomicBoolean(false);

    @Override
    public void run() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                stop.set(true);
            }
        },2500);
        while (!stop.get()) {
            g.method();
            successfulCalls.getAndIncrement();
        }
        System.out.println("-> " + successfulCalls.get());
    }
}
public class SynchronizedComparison {
    static void test(Guarded g) {
        //
        List<CompletableFuture<Void>> callers =
                Stream.of(new Caller(g),new Caller(g),new Caller(g),new Caller(g))
                    .map(CompletableFuture::runAsync)
                    .collect(Collectors.toList());
        callers.forEach(CompletableFuture::join);
        System.out.println(g);
    }

    public static void main(String[] args) {
        test(new CriticalSection());
        test(new SynchronizedMethod());
    }
}
/*
output:
-> 159
-> 159
-> 159
-> 159
CriticalSection: 636
-> 48
-> 45
-> 50
-> 18
SynchronizedMethod: 161
 */