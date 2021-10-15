package com.gui.demo.jvm.classstructure;

/**
 * @Classname SubClass
 * @Description TODO
 * @Date 2021/9/26 23:08
 * @Created by gt136
 */
class SuperClass {
    static{
        System.out.println("SuperClass init!");
    }
    public static int value = 123;
}

public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }

}
