package com.gui.demo.thingInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Classname CaptureUncaughtException
 * @Description 給每个线程附着一个异常处理器
 * @Date 2021/7/22 14:33
 * @Created by gt136
 */
class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created： " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}
public class CaptureUncaughtException {
    public static void main(String[] args) {
        //返回ThreadPoolExecutor
        ExecutorService service = Executors.newCachedThreadPool(new HandlerThreadFactory());
        //execute方法会执行参数线程的run()方法
        service.execute(new ExceptionThread2());
    }
}
/*
output:
HandlerThreadFactory@6d03e736 creating new Thread
created Thread[Thread-0,5,main]
eh = MyUncaughtExceptionHandler@568db2f2
run() by Thread[Thread-0,5,main]
eh = MyUncaughtExceptionHandler@568db2f2
HandlerThreadFactory@6d03e736 creating new Thread
created Thread[Thread-1,5,main]
eh = MyUncaughtExceptionHandler@2f8d3330
caught java.lang.RuntimeException
 */