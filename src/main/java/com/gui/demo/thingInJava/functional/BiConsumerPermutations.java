package com.gui.demo.thingInJava.functional;

import java.util.function.BiConsumer;

/**
 * @Classname BiConsumerPermutations
 * @Description 缺少基本类型的函数
 * @Date 2021/5/24 13:58
 * @Created by gt136
 */
public class BiConsumerPermutations {
    static BiConsumer<Integer, Double> bicid = (i, d)-> System.out.format("%d, %f%n",i, d);
    static BiConsumer<Double, Integer> bicdi = (d, i) -> System.out.format("%d, %f%n", i, d);
    static BiConsumer<Integer, Long> bicil = (i, l) -> System.out.format("%d, %d%n", i, l);

    public static void main(String[] args) {
        bicid.accept(47, 11.34);
        bicdi.accept(22.45, 93);
        bicil.accept(1,11l);
    }
}
/*
print:
47, 11.340000
93, 22.450000
1, 11
 */