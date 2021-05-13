package com.gui.demo.thingInJava.collectionAndMap;

import java.rmi.MarshalledObject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname MapDemo
 * @Description TODO
 * @Date 2021/3/31 14:29
 * @Created by gt136
 */
public class MapDemo {
    public static Map<String, List<?>> map = new HashMap<>();
    static {
        map.put("Dawn", Arrays.asList("Molly", "Spot"));
        map.put("Shackleton", Arrays.asList("Elsie May", "Margrett"));
    }

    public static void main(String[] args) {
        System.out.println("String:" + map.keySet());
        System.out.println("?:" + map.values());
        for (String s : map.keySet()) {
            System.out.println(s + " has:");
            for (Object ss : map.get(s)) {
                System.out.println("  " + ss);
            }
        }
    }
}
