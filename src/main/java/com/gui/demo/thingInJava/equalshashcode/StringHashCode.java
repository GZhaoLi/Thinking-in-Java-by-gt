package com.gui.demo.thingInJava.equalshashcode;

/**
 * @Classname StringHashCode
 * @Description hashCode的比较
 * @Date 2021/7/13 14:35
 * @Created by gt136
 */
public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
/*
output:
69609650
69609650
 */
