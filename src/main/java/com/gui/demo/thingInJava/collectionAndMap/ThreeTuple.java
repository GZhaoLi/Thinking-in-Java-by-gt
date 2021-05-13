package com.gui.demo.thingInJava.collectionAndMap;

/**
 * @Classname ThreeTuple
 * @Description TODO
 * @Date 2021/5/8 16:32
 * @Created by gt136
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B>{
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        this.third = c;
    }

    @Override
    public String toString() {
        return "{" +
                "third=" + third +
                ", first=" + first.getClass().getSimpleName() +
                ", second=" + second +
                '}';
    }
}
