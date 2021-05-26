package com.gui.demo.thingInJava.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Classname Closure3
 * @Description TODO
 * @Date 2021/5/25 11:26
 * @Created by gt136
 */
public class Closure3 {
    Supplier<List<Integer>> makeFun(){
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }

    public static void main(String[] args) {
        Closure3 c3 = new Closure3();
        List<Integer>
                l1 = c3.makeFun().get(),
                l2 = c3.makeFun().get();
        System.out.println(l1);
        System.out.println(l2);
        l1.add(42);
        l2.add(96);
        System.out.println(l1);
        System.out.println(l2);
    }
}
/*
print:
[1]
[1]
[1, 42]
[1, 96]
 */