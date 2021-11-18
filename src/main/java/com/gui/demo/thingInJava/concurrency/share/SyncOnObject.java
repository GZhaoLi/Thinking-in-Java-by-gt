package com.gui.demo.thingInJava.concurrency.share;

import com.gui.demo.thingInJava.concurrency.Nap;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/**
 * 下面代码的思想是这样的：SyncOnObject类的test方法会将两个同步方法（因为DualSynch没有实现Runnable，所以没有run方法）异步执行，并将执行后的结果打印出来。
 *      f()和g() 的方法会根据传入的boolean来进行是否休眠，在循环的次数内休眠n*0.01秒。而在同步锁的作用下，即使下一条test方法执行也会阻塞，并且同时阻塞的是两个方法
 *      因为是同一个对象，所以它们是顺序执行的，按照锁的优先顺序执行，而打印的时候也是打印的同一个queue，所以不会中断。
 * @Date 2021/8/13 14:17
 * @Created by gt136
 */
class DualSynch {
    ConcurrentLinkedQueue<String> trace = new ConcurrentLinkedQueue<>();

    public synchronized void f(boolean nap) {
        for (int i = 0; i < 50; i++) {
            trace.add(String.format("f() " + i));
            //如果 nap 为true，则停顿
            if (nap) new Nap(0.01);
        }
    }

    private final Object syncObject = new Object();

    public void g(boolean nap) {
        synchronized (syncObject) {
            for (int i = 0; i < 50; i++) {
                trace.add(String.format("g() " + i));
                if (nap) new Nap(0.01);
            }
        }
    }
}

public class SyncOnObject {
    static void test(boolean fNap, boolean gNap) {
        DualSynch ds = new DualSynch();
        List<CompletableFuture<Void>> cfs = Arrays.stream(new Runnable[]{
                () -> ds.f(fNap), () -> ds.g(gNap)//用这个Runnable数组的去运行 ds 的两个不同同步方法
        })
                .map(CompletableFuture::runAsync)//异步运行
                .collect(Collectors.toList());
        cfs.forEach(CompletableFuture::join);//返回一个结果值
        ds.trace.forEach(System.out::println);//遍历输出trace队列中的数据
    }

    public static void main(String[] args) {
        test(true, false);
        System.out.println("*********");
        test(false,true);
    }
}
/*
output:
f() 0
g() 0
g() 1
g() 2
g() 3
g() 4
f() 1
f() 2
f() 3
f() 4
*********
f() 0
g() 0
f() 1
f() 2
f() 3
f() 4
g() 1
g() 2
g() 3
g() 4
 */