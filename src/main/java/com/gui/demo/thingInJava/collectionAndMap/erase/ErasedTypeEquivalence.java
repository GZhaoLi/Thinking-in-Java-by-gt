package com.gui.demo.thingInJava.collectionAndMap.erase;

import java.util.ArrayList;

/**
 * @Classname ErasedTypeEquivalence
 * @Description TODO
 * @Date 2021/5/12 17:08
 * @Created by gt136
 */
public class ErasedTypeEquivalence {

    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}
