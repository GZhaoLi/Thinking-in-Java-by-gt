package com.gui.demo.thingInJava.concurrency.share;

/**
 * @Classname SerialNumberTest
 * @Description TODO
 * @Date 2021/8/12 18:00
 * @Created by gt136
 */
public class SerialNumberTest {
    public static void main(String[] args) {
        SerialNumberChecker.test(new SerialNumbers());
    }
}
/*
output:
Duplicate: 114961
 */