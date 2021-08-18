package com.gui.demo.thingInJava.concurrency.tasksExecutors;

import com.gui.demo.thingInJava.concurrency.Nap;

/**
 * @Classname NapTask
 * @Description TODO
 * @Date 2021/8/18 14:25
 * @Created by gt136
 */
public class NapTask implements Runnable{
    final int id;

    public NapTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        new Nap(0.1);
        System.out.println(this + " " + Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return "NapTask{" +
                "id=" + id +
                '}';
    }
}
