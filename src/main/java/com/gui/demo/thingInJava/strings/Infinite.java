package com.gui.demo.thingInJava.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Infinite
 * @Description TODO
 * @Date 2021/4/9 14:05
 * @Created by gt136
 */
public class Infinite {
    public String toString(){
        /*
        此处infinite类型会自动转换为String类型。因为编译器看到一个String对象(不变性)后面跟着一个”+“运算符，而在后面的对象不是String，于是编译器
        试着将this转换成一个String，此处调用了this上的toString()，于是发生了递归调用。此处应该用Object.toString()，不该用this，而是super.toString()
         */
        return "Infinite address:" + this + "\n";
//        return "Infinite address:" + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<Infinite> v = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            v.add(new Infinite());
        }
        System.out.println(v);
    }
}
