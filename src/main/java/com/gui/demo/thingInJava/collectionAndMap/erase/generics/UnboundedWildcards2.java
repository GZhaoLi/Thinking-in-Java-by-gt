package com.gui.demo.thingInJava.collectionAndMap.erase.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname UnboundedWildcards2
 * @Description TODO
 * @Date 2021/6/2 23:51
 * @Created by gt136
 */
public class UnboundedWildcards2 {
    static Map map1;
    static Map<?, ?> map2;
    static Map<String, ?> map3;

    static void assign1(Map map) {
        map1 = map;
    }

    static void assign2(Map<?, ?> map) {
        map2 = map;
    }

    static void assign3(Map<String, ?> map) {
        map3 = map;
    }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap());
        //报类型错误
        assign3(new HashMap());

        assign1(new HashMap<>());
        assign2(new HashMap<>());
        assign3(new HashMap<>());
    }
}
