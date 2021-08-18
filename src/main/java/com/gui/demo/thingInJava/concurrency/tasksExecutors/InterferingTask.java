package com.gui.demo.thingInJava.concurrency.tasksExecutors;

/**
 * @Classname InterferingTask
 * @Description 每个任务增加 val 100次
 * @Date 2021/8/18 15:39
 * @Created by gt136
 */
public class InterferingTask implements Runnable{
    final int id;
    private static Integer val = 0;
    public InterferingTask(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id + " " + Thread.currentThread().getName()+" "+ val);
    }
}
