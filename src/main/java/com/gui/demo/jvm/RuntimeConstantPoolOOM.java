package com.gui.demo.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname RuntimeConstantPoolOOM
 * @Description JDK 7 之前的字符串常量池存储在永久代中，但是 7 之后都存在堆中。所以，要改变堆的大小来改变影响操作
 * @Date 2021/8/29 22:31
 * @Created by gt136
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        /*//使用Set 保持着常量池的使用，避免Full GC 回收常量池行为
        Set<String> set = new HashSet<>();
        //在short 范围内足以让6MB的堆产生
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }*/
        //出现 true 和 false 的原因是：堆遇到的字符串“实例”的首次引用保存
        String st1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(st1.intern() == st1);

        String st2 = new StringBuilder("ja").append("va").toString();
        System.out.println(st2.intern() == st2);
    }
}
/*
outputs:
Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
	at java.lang.Integer.toString(Integer.java:403)
	at java.lang.String.valueOf(String.java:3099)
	at com.gui.demo.jvm.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:17)
==========================
true
false
 */