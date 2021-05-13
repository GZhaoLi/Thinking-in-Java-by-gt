package com.gui.demo.thingInJava.collectionAndMap;

/**
 * @Classname GenericMethods2
 * @Description TODO
 * @Date 2021/5/11 10:05
 * @Created by gt136
 */
public class GenericMethods2 {
    public <A, B, C> void f(A a, B b, C c) {
        System.out.println(a.getClass().getSimpleName() + ", " + b.getClass().getSimpleName() + ", " + c.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods2 gm2 = new GenericMethods2();
        gm2.f(1, 2, 3);
        gm2.f("1", 2.0, 3.0f);
        gm2.f('1',"2",gm2);
    }
}
