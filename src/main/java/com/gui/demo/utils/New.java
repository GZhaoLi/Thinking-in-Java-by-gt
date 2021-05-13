package com.gui.demo.utils;

import java.util.*;

/**
 * @Classname New
 * @Description 一个工具类：利用泛型方法简化类的生成，专门用来创建各种常用的容器。
 * @Date 2021/5/11 10:16
 * @Created by gt136
 */
public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    public static <T> LinkedList<T> linkedList() {
        return new LinkedList<>();
    }

    public static <T> Set<T> set() {
        return new HashSet<>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    /*
    public static void main(String[] args) {
        Map<String, List<String>> sls = New.map();
        List<String> ls = New.list();
        LinkedList<String> lls = New.linkedList();
        Set<String> ss = New.set();
        Queue<String> qs = New.queue();
    }*/
}
