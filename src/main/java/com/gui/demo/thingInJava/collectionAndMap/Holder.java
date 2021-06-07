package com.gui.demo.thingInJava.collectionAndMap;

/**
 * @Classname Holder
 * @Description TODO
 * @Date 2021/5/8 15:36
 * @Created by gt136
 */
public class Holder<T> {
    private T a;

    public Holder() {

    }
    public Holder(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }
}
