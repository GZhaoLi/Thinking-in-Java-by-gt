package com.gui.demo.thingInJava.concurrency;

/**
 * @Classname MoreBasicThreads
 * @Description 演示不同线程之间的交互
 * @Date 2021/7/16 15:25
 * @Created by gt136
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
/*
output:
Waiting for LiftOff
#0(9),
#1(9),
#0(8),
#1(8),
#0(7),
#1(7),
#2(9),
#1(6),
#0(6),
#2(8),
#0(5),
#1(5),
#2(7),
#2(6),
#2(5),
#1(4),
#0(4),
#2(4),
#0(3),
#1(3),
#0(2),
#1(2),
#0(1),
#2(3),
#1(1),
#0(LiftOff!),
#1(LiftOff!),
#2(2),
#2(1),
#2(LiftOff!),
 */