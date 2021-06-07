package com.gui.demo.thingInJava.collectionAndMap.erase.arrays;

/**
 * @Classname CovariantArrays
 * @Description TODO
 * @Date 2021/5/31 22:42
 * @Created by gt136
 */
class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        //运行时的类型是Apple[],而不是Fruit[]或者Orange[]
        try {
            //编译的时候是允许你这么写的，但是运行时会报数组存储异常（ArrayStoreException）
            fruits[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            //编译的时候也是允许你去添加，但是运行时同样会报一样的错误
            fruits[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/*
output:
java.lang.ArrayStoreException: com.gui.demo.thingInJava.collectionAndMap.erase.arrays.Fruit
java.lang.ArrayStoreException: com.gui.demo.thingInJava.collectionAndMap.erase.arrays.Orange
 */