package com.gui.demo.thingInJava.collectionAndMap;

import com.gui.demo.thingInJava.collectionAndMap.ThreeTuple;

/**
 * @Classname FourTuple
 * @Description TODO
 * @Date 2021/5/9 23:12
 * @Created by gt136
 */
public class FourTuple<A, B, C, D> extends ThreeTuple<A,B, C> {
    public final D fourth;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        this.fourth = d;
    }

    @Override
    public String toString() {
        return "{" +
                "fourth=" + fourth +
                ", third=" + third +
                ", first=" + first.getClass().getSimpleName() +
                ", second=" + second.getClass().getSimpleName() +
                '}';
    }
}
