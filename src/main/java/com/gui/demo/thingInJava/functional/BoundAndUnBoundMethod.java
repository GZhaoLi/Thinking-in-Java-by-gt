package com.gui.demo.thingInJava.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

/**
 * @Classname BoundAndUnBoundMethod
 * @Description TODO
 * @Date 2021/5/18 14:10
 * @Created by gt136
 */
public class BoundAndUnBoundMethod {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("alpha", "x");
        map.put("brave", "y");
        map.put("charlie", "z");
        String str = "alpha-brave-charlie";

        /**
         * 通过绑定方法引用来调用replace作为参数传入replaceAll中
         * 调用与str实例绑定的replace
         */
        map.replaceAll((x,y) -> str.replace(x,y));
//        map.replaceAll(str::replace);
        map.forEach((x,y) -> System.out.println(x + "----->" + y));

    }
}
