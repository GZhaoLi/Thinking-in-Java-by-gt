package com.gui.demo.thingInJava.collectionAndMap.erase;

/**
 * @Classname ArrayOfGeneric
 * @Description TODO
 * @Date 2021/5/14 17:31
 * @Created by gt136
 */
public class ArrayOfGeneric {
    static final int size = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
        //类转型错误
//        gia = (Generic<Integer>[]) new Object[size];
        gia = new Generic[size];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
//        gia[1] = (Generic<Integer>) new Object();//ClassCastException
//        gia[2] = new Generic<Double>();
        System.out.println(gia.getClass().getSimpleName());
    }
}
