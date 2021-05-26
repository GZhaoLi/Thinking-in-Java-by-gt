package com.gui.demo.thingInJava.functional;

import java.util.function.Function;

/**
 * @Classname FunctionComposition
 * @Description 函数组合
 * @Date 2021/5/25 14:35
 * @Created by gt136
 */
public class FunctionComposition {
    static Function<String, String>
            f1 = new Function<String, String>() {
        @Override
        public String apply(String s) {
            System.out.println(s);
            return s.replace("A", "_");
        }
    },
            f2 = s -> s.substring(3),
            f3 = s -> s.toLowerCase(),
            f4 = f1.compose(f2).andThen(f3);

    public static void main(String[] args) {
        System.out.println(f4.apply("GO AFTER ALL AMBULANCES!!"));
    }
}
/*
AFTER ALL AMBULANCES!!
_fter _ll _mbul_nces!!
*/
