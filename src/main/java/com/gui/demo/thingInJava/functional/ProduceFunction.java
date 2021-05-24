package com.gui.demo.thingInJava.functional;

import java.util.function.Function;

/**
 * @Classname ProduceFunction
 * @Description 高阶函数的生产函数代码
 * @Date 2021/5/24 16:30
 * @Created by gt136
 */
interface FunSS extends Function<String, String> {//[1]

}
public class ProduceFunction {
    static FunSS produce(){
        return s -> s.toLowerCase();
    }

    public static void main(String[] args) {
        FunSS fs = produce();
        System.out.println(fs.apply("YELLING!!"));
    }
}
/*
print:
yelling!!
 */