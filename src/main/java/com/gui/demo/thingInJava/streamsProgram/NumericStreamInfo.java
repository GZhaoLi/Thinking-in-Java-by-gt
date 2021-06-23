package com.gui.demo.thingInJava.streamsProgram;

import static com.gui.demo.thingInJava.streamsProgram.optional.RandInts.*;
/**
 * @Classname NumericStreamInfo
 * @Description 数字流信息
 * @Date 2021/6/23 10:29
 * @Created by gt136
 */
public class NumericStreamInfo {
    public static void main(String[] args) {
        System.out.println(rands().average().getAsDouble());
        System.out.println(rands().max().getAsInt());
        System.out.println(rands().min().getAsInt());
        System.out.println(rands().sum());
        System.out.println(rands().summaryStatistics());
    }
}
/*
output:
507.94
998
8
50794
IntSummaryStatistics{count=100, sum=50794, min=8, average=507.940000, max=998}
 */