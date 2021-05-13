package com.gui.demo.thingInJava.collectionAndMap;

/**
 * @Classname TwoTuple
 * @Description TODO
 * @Date 2021/5/8 16:06
 * @Created by gt136
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;
    public TwoTuple(A a, B b){
        first = a;
        second = b;
    }
    public String toString(){
        return "(" + first + "," + second +")";
    }
}
