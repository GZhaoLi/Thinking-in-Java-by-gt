package com.gui.demo.thingInJava.collectionAndMap;

import java.util.ArrayList;

/**
 * @Classname TupleList
 * @Description 泛型实现复杂类型
 * @Date 2021/5/13 9:15
 * @Created by gt136
 */
public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tuples = new TupleList<>();
        tuples.add(TupleTest.h());
        tuples.add(TupleTest.h());
        for (FourTuple<Vehicle, Amphibian, String, Integer> f : tuples) {
            System.out.println(f);
        }
    }
}
