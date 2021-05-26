package com.gui.demo.thingInJava.functional;

import java.util.function.IntSupplier;

/**
 * @Classname Closure1
 * @Description 闭包
 * @Date 2021/5/24 22:27
 * @Created by gt136
 */
public class Closure1 {
    int i;

    IntSupplier makeFun(int x) {
        return () -> x + i++;
    }
}
