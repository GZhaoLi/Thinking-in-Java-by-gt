package com.gui.demo.thingInJava.collectionAndMap;

/**
 * @Classname GeneratorTuple
 * @Description TODO
 * @Date 2021/5/11 14:33
 * @Created by gt136
 */
public class GeneratorTuple{
    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<>(a, b, c);
    }

    public static <A, B, C, D> FourTuple<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new FourTuple<>(a, b, c, d);
    }

}
