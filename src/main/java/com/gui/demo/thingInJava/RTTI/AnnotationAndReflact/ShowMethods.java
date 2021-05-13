package com.gui.demo.thingInJava.RTTI.AnnotationAndReflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Classname ShowMethods
 * @Description 使用反射去显示一个类的所有方法，即使方法是在父类中被定义的
 * @Date 2021/4/27 20:39
 * @Created by gt136
 */
 class ShowMethods {
    private static final Pattern pattern = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            String usage = "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor<?>[] constructors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                }
                for (Constructor<?> constructor : constructors) {
                    System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
                }
                lines = methods.length + constructors.length;
            }else {
                for (Method ignored : methods) {
                    if (Arrays.toString(constructors).contains(args[1])) {
                        System.out.println(pattern.matcher(Arrays.toString(constructors)).replaceAll(""));
                        lines ++;
                    }
                }
                for (Constructor<?> constructor : constructors) {
                    if (constructor.toString().contains(args[1])) {
                        System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
                    }
                    lines++;
                }
            }
            System.out.println(lines);
        } catch (ClassNotFoundException e) {
            System.out.println("No such class:" + e);
        }
    }
}
/*
输出：
public static void main(String[])
public final void wait() throws InterruptedException
public final void wait(long,int) throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public native int hashCode()
public final native Class getClass()
public final native void notify()
public final native void notifyAll()
public ShowMethods()
11
 */