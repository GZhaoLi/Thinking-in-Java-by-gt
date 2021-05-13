package com.gui.demo.thingInJava.collectionAndMap;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Classname Generators
 * @Description 生成器使用的实用程序
 * @Date 2021/5/12 10:35
 * @Created by gt136
 */
public class Generators {
    //使用Collection方法将指定的对象加入到集合中,
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<>(), new CoffeeGenerator(), 3);
        for (Coffee c : coffees) {
            System.out.println(c);
        }

        Collection<Integer> fnumbers = fill(new ArrayList<>(), new Fibonacci(), 12);
        for (Integer i : fnumbers) {
            System.out.print(i+",");
        }
    }
}
