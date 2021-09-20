package com.gui.demo.jvm;

import java.util.HashMap;

/**
 * @Classname Singleton
 * @Description TODO
 * @Date 2021/9/10 0:08
 * @Created by gt136
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    public static int x = 0;
    public static int y;

    public Singleton() {
        x ++;
        y ++;
    }
    public static Singleton instance() {
        return singleton;
    }

    public static void main(String[] args) {
        Singleton s = instance();
        System.out.println(x);
        System.out.println(y);
        HashMap<String, String> hashMap = new HashMap<>();

    }
}
/*
outputs:
0
1

类的初始化顺序：
1.先初始化父类的<clinit> 方法（静态块和静态变量的初始化），在执行子类的<clinit>方法
2.执行父类的<init>方法(构造器）,在执行子类的<init>方法
3.<clinit>方法只执行一次（class对象只执行一次），<init>方法可以执行多次(可以多次 new 对象）

主动引用：对类进行引用时如果类没有进行过初始化，则先触发其初始化叫做主动引用
反射调用会触发类的初始化
new 一个对象的时候会发生类初始化，调用<clinit>方法
调用类中的静态成员，除了final字段，final被调用但是不会初始化类

被动引用：除了主动引用外，所有引用类的方式都不会触发初始化，称为被动引用
通过子类引用父类的静态字段，不会导致子类初始化
通过数组定义类的引用类，不会触发类的初始化：Test test = new Test[10];
不会触发定义常量的类的初始化
 */