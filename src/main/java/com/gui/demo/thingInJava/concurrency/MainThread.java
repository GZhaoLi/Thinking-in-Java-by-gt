package com.gui.demo.thingInJava.concurrency;

/**
 * @Classname MainThread
 * @Description 主线程中开辟线程
 * @Date 2021/7/15 15:39
 * @Created by gt136
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
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
