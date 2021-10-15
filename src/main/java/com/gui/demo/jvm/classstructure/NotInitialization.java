package com.gui.demo.jvm.classstructure;

/**
 * @Classname NotInitialization
 * @Description TODO
 * @Date 2021/9/26 23:11
 * @Created by gt136
 */
public class NotInitialization {
    public static void main(String[] args) {
//        System.out.println(SubClass.value);
        SuperClass[] sc = new SuperClass[10];
    }
}
