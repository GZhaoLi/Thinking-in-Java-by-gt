package com.gui.demo.thingInJava.collectionAndMap;

/**
 * @Classname CountedObject
 * @Description TODO
 * @Date 2021/5/11 14:14
 * @Created by gt136
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;
    public long id(){
        return id;
    }
    public String toString(){
        return "CountedObject " + id;
    }
}
