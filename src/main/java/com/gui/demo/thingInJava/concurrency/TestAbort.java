package com.gui.demo.thingInJava.concurrency;

/**
 * @Classname TestAbort
 * @Description TimedAbort 的立即退出作用
 * @Date 2021/8/2 17:34
 * @Created by gt136
 */
public class TestAbort {
    public static void main(String[] args) {
        new TimedAbort(4);
        System.out.println("Napping for 4");
        new Nap(4,"nap");
    }
}
/*
output:先输出第一行，等待4秒后输出第二行
Napping for 4
TimedAbort 1.0
 */