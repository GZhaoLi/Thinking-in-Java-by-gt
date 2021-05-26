package com.gui.demo.thingInJava.lunzi;

/**
 * @Classname CountedObject
 * @Description TODO
 * @Date 2021/5/26 17:16
 * @Created by gt136
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long getId(){
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject{" +
                "id=" + id +
                '}';
    }
}
