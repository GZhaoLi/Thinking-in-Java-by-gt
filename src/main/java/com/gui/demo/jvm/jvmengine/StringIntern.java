package com.gui.demo.jvm.jvmengine;

/**
 * @author chappyzhao
 */
public class StringIntern {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

    }
}
/*
output:
true
false
在 JDK7 之前intern 方法会把首次遇到的字符串实例复制到永久代的字符串常量池存储，返回的也是这个字符串的引用。
由StringBuilder创建的字符串对象实例在 Java 堆上，所以不可能是同一个引用，所以返回 false。
JDK7 之后intern方法不需要在拷贝字符串的实例了，因为字符串常量池已经在 Java 堆中了，所以只需在常量池中记录
一下首次出现的实例引用就行，所以返回 true。而str2返回false是因为"java"这个字符串在常量池已经有了。
 */