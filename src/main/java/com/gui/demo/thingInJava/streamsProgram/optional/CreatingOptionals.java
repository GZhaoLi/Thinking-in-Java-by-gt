package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Classname CreatingOptionals
 * @Description 创建流操作
 * @Date 2021/6/29 22:20
 * @Created by gt136
 */
public class CreatingOptionals {
    static void test(String testName, Optional<String> optional) {
        System.out.println("====" + testName + "====");
        System.out.println(optional.orElse("NULL"));
    }

    public static void main(String[] args) {
        test("empty", Optional.empty());
        test("of", Optional.of("Howdy()"));
        try {
            test("of", Optional.of(null));
        } catch (Exception e) {
            System.out.println(e);
        }

        test("ofNullable", Optional.ofNullable("Hi"));
        test("ofNullable", Optional.ofNullable(null));
    }
}
/*
output:
====empty====
NULL
====of====
Howdy()
java.lang.NullPointerException
====ofNullable====
Hi
====ofNullable====
NULL
 */