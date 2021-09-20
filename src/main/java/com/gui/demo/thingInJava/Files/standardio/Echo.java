package com.gui.demo.thingInJava.Files.standardio;

import com.gui.demo.thingInJava.concurrency.TimedAbort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.gui.demo.thingInJava.concurrency.TimedAbort.*;
/**
 * @Classname Echo
 * @Description 包装`System.in`为BufferedReader
 * @Date 2021/9/13 10:54
 * @Created by gt136
 */
public class Echo {
    public static void main(String[] args) {
        TimedAbort abort = new TimedAbort(2);
        new BufferedReader(
                new InputStreamReader(System.in))
                .lines()//通常一次一行的进行读取，所以上面使用Reader来封装
                .peek(ln -> abort.restart())//重启 TimeAbort，只要保证每隔两秒有输入就能够使程序保持开启状态
                .forEach(System.out::println);
    }
}
/*
outputs:
TimedAbort 2.0
 */