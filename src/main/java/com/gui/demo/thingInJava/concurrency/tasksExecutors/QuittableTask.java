package com.gui.demo.thingInJava.concurrency.tasksExecutors;

import com.gui.demo.thingInJava.concurrency.Nap;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Classname QuittableTask
 * @Description TODO
 * @Date 2021/8/19 11:15
 * @Created by gt136
 */
public class QuittableTask implements Runnable {
    final int id;

    public QuittableTask(int id) {
        this.id = id;
    }

    private AtomicBoolean running = new AtomicBoolean(true);
    public void quit() {
        running.set(false);
    }

    @Override
    public void run() {
        while (running.get()) { //[1]
            new Nap(0.1);
        }
        System.out.print(id + " ");
    }
}
