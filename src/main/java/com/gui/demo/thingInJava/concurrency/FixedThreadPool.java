package com.gui.demo.thingInJava.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Classname FixedThreadPool
 * @Description 替换Executors.newCachedThreadPool();为不同的 Executor
 * @Date 2021/7/18 18:33
 * @Created by gt136
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        //构造器参数是线程的数量
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                try {
                    TimeUnit.MILLISECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //旧模式
            /*if (i == 2) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
            es.execute(new LiftOff());
        }
        es.shutdown();
    }
}
