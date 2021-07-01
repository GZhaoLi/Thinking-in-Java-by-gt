package com.gui.demo.thingInJava.tests.validating;

import java.util.ArrayList;

/**
 * @Classname CountedList
 * @Description TODO
 * @Date 2021/6/23 23:17
 * @Created by gt136
 */
public class CountedList extends ArrayList<String> {
    private static int count = 0;
    private int id = count++;
    public CountedList() {
        System.out.println("CountedList #" + id);
    }
    public int getId() {
        return id;
    }
}
