package com.gui.demo.thingInJava.collectionAndMap.erase.generics;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname GenericReading
 * @Description TODO
 * @Date 2021/6/2 17:05
 * @Created by gt136
 */
public class GenericReading {
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static <T> T readExact(List<T> list) {
        return list.get(0);
    }
    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruits);
        System.out.println(f);
        //集合和对象的类型是有区别的
        f = readExact(apples);
         System.out.println(a);
         System.out.println(f);
     }

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }
    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruits);
        //指定了T的类型就必须一致
//        Fruit a = fruitReader.readExact(apples);
    }

    static class CovariantReader <T>{
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<>();
        Fruit f = fruitReader.readCovariant(fruits);
        Fruit a = fruitReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
