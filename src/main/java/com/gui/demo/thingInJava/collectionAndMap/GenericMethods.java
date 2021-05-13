package com.gui.demo.thingInJava.collectionAndMap;

/**
 * @Classname GenericMethods
 * @Description 普通类中含有一个泛型方法
 * @Date 2021/5/11 9:36
 * @Created by gt136
 */
public class GenericMethods {
    public <T> void f(T x){
        System.out.println(x.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0f);
        gm.f('c');
        gm.f(gm);
    }
}
/*
输出：
String
Integer
Double
Float
Character
GenericMethods
 */