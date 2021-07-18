package com.gui.demo.thingInJava.concurrency;

/**
 * @Classname LiftOff
 * @Description 线程描述任务：火箭发射倒计时
 * @Date 2021/7/15 15:18
 * @Created by gt136
 */
public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public LiftOff() {
        System.out.println("----");
    }

    public String status() {
        return "#" + id + "("+ (countDown > 0 ? countDown : "LiftOff!") + "),";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
/*
output:
#0(9),
#0(8),
#0(7),
#0(6),
#0(5),
#0(4),
#0(3),
#0(2),
#0(1),
#0(LiftOff!),
 */
