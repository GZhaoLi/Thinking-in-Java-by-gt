package com.gui.demo.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Classname DirectMemoryOOM
 * @Description -Xmx20M -XX:MaxDirectMemorySize=10M
 * @Date 2021/8/31 23:47
 * @Created by gt136
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
/*
outputs:
Exception in thread "main" java.lang.OutOfMemoryError
	at sun.misc.Unsafe.allocateMemory(Native Method)
	at com.gui.demo.jvm.DirectMemoryOOM.main(DirectMemoryOOM.java:21)
 */