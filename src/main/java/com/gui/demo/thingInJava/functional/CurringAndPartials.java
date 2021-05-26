package com.gui.demo.thingInJava.functional;

import java.util.function.Function;

/**
 * @Classname CurringAndPartials
 * @Description 柯里化
 * @Date 2021/5/25 23:16
 * @Created by gt136
 */
public class CurringAndPartials {
    //
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        //
        Function<String, Function<String, String>> sum =
                a -> b -> a + b;//[1]
        System.out.println(uncurried("Hi ", "Ho"));

        Function<String, String> hi = sum.apply("Hi ");//[2]
        System.out.println(hi.apply("Ho"));

        //
        Function<String, String> sumHi = sum.apply("Hup ");
        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));
    }
}
/*
Hi Ho
Hi Ho
Hup Ho
Hup Hey
 */