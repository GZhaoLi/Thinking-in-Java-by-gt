package com.gui.demo.thingInJava.concurrency.share;

/**
 * @Classname EvenGenerator
 * @Description 非同步方法控制共享区域
 * @Date 2021/7/30 17:50
 * @Created by gt136
 */
public class EvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++ currentEvenValue;//[1]这里是危险的地方
//        Thread.yield();
        ++ currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EventChecker.test(new EvenGenerator());
    }
}
/*
output:
2053 not even!
2059 not even!
2057 not even!
2055 not even!
 */