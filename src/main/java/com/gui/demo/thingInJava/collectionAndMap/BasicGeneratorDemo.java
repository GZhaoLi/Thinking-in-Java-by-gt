package com.gui.demo.thingInJava.collectionAndMap;

import com.gui.demo.thingInJava.lunzi.BasicGenerator;

/**
 * @Classname BasicGeneratorDemo
 * @Description TODO
 * @Date 2021/5/11 14:17
 * @Created by gt136
 */
public class BasicGeneratorDemo {
    private static Generator<CountedObject> gco = BasicGenerator.create(CountedObject.class);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(gco.next());
        }
    }
}
/*
输出：
CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4
 */
