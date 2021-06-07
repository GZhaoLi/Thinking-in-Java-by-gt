package com.gui.demo.thingInJava.collectionAndMap.erase.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UnboundedWildcards1
 * @Description TODO
 * @Date 2021/6/2 23:30
 * @Created by gt136
 */
public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign1(List list) {
        list1 = list;
        list2 = list;
        //会提示一个未检查的转换：Unchecked assignment: 'java.util.List' to 'java.util.List<? extends java.lang.Object>'
        list3 = list;
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList());
        //再次报未检查的类型错误
        assign3(new ArrayList());

        assign1(new ArrayList<>());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());

        List<?> wildList = new ArrayList();
        wildList = new ArrayList<>();
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);
    }
}
