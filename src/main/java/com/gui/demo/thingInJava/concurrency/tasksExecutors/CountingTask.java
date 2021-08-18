package com.gui.demo.thingInJava.concurrency.tasksExecutors;

import java.util.concurrent.Callable;

/**
 * @Classname CountingTask
 * @Description Callable
 * @Date 2021/8/18 16:16
 * @Created by gt136
 */
public class CountingTask implements Callable<Integer> {
    final int id;

    public CountingTask(int id) {
        this.id = id;
    }
    @Override
    public Integer call() throws Exception {
        Integer val = 0;
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id + " " + Thread.currentThread().getName()+" "+ val);
        return val;
    }
}
