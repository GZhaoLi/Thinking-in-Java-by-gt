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
 * 不同的同步方法竞争调用自己的 method
 * Guarded 类负责跟踪 callCount 中成功调用 method() 的次数。SynchronizedMethod 的方式是同步控制整个 method() 方法，
 * 而 CriticalSection 的方式是使用同步控制块来仅同步 method 方法的一部分代码。这样，控制时长的 Nap 对象可以排除到同步控制块外。
 * 输出会显示 CriticalSection 中可用的 method() 有多少。
 *
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
        //睡眠0.01秒
        new Nap(0.01);
        //因父类字段没有private，所以子类可以读取到父类的字段
        callCount.incrementAndGet();
    }
}

class CriticalSection extends Guarded {

    @Override
    public void method() {
        new Nap(0.01);
        //同步块锁住了整个对象
        synchronized (this) {
            callCount.incrementAndGet();
        }
    }
}

class Caller implements Runnable {
    private final Guarded g;

    Caller(Guarded g) {
        this.g = g;
    }
    private final AtomicLong successfulCalls = new AtomicLong();//不指定的话初始值为0
    private final AtomicBoolean stop = new AtomicBoolean(false);

    @Override
    public void run() {
        //相当于计时器，在这个时间段内stop的值不会设置为true，所以while语句会一直执行并调用method方法，
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                stop.set(true);
            }
        },2500);
        while (!stop.get()) {
            g.method();
            //自动增加1，并返回之前的值
            successfulCalls.getAndIncrement();
        }
        System.out.println("-> " + successfulCalls.get());
    }
}
public class SynchronizedComparison {
    static void test(Guarded g) {
        //将多个Guarded的子类传入Caller中进行并发操作，
        List<CompletableFuture<Void>> callers =
                Stream.of(new Caller(g),new Caller(g),new Caller(g),new Caller(g))
                    .map(CompletableFuture::runAsync)//让这几个对象异步执行
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