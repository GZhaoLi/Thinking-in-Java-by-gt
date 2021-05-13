package com.gui.demo.thingInJava.collectionAndMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname FillingLists
 * @Description 填充容器
 * @Date 2021/5/7 11:09
 * @Created by gt136
 */
class StringAddress{
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }
    public String toString(){
        return super.toString() + " ;" + s;
    }
}
public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4, new StringAddress("hello")));
        System.out.println(list);
        Collections.fill(list, new StringAddress("world!"));
        System.out.println(list);
    }
}
/*
[com.gui.demo.thingInJava.collectionAndMap.StringAddress@41629346 ;hello, com.gui.demo.thingInJava.collectionAndMap.StringAddress@41629346 ;hello, com.gui.demo.thingInJava.collectionAndMap.StringAddress@41629346 ;hello, com.gui.demo.thingInJava.collectionAndMap.StringAddress@41629346 ;hello]
[com.gui.demo.thingInJava.collectionAndMap.StringAddress@404b9385 ;world!, com.gui.demo.thingInJava.collectionAndMap.StringAddress@404b9385 ;world!, com.gui.demo.thingInJava.collectionAndMap.StringAddress@404b9385 ;world!, com.gui.demo.thingInJava.collectionAndMap.StringAddress@404b9385 ;world!]
 */