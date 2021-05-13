package com.gui.demo.thingInJava.RTTI;

/**
 * @Classname RandomSuper
 * @Description TODO
 * @Date 2021/4/20 11:06
 * @Created by gt136
 */
public class RandomSuper {
    static void printClasses(Class<?> c) {
        if (c == null) return;
        System.out.println(c.getName());
//        String s = null;
//        c.getDeclaredField(s);
        for (Class<?> k : c.getInterfaces()) {
            System.out.println("Interface: " + k.getName());
            System.out.println(k.getSuperclass());
        }
        printClasses(c.getSuperclass());
    }
    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[]{"com.gui.demo.thingInJava.RTTI.FancyToy","com.gui.demo.thingInJava.RTTI.Square"};
        for (int i = 0; i < args.length; i++) {
            System.out.println("Displaying " + args[i]);
            printClasses(Class.forName(args[i]));

            if (i < args.length - 1) {
                System.out.println("=================================");
            }
        }
    }
}
/*
输出：
Displaying com.gui.demo.thingInJava.RTTI.FancyToy
com.gui.demo.thingInJava.RTTI.FancyToy
Interface: com.gui.demo.thingInJava.RTTI.HasBatteries
null
Interface: com.gui.demo.thingInJava.RTTI.Waterproof
null
Interface: com.gui.demo.thingInJava.RTTI.Shoots
null
Interface: com.gui.demo.thingInJava.RTTI.DNF
null
com.gui.demo.thingInJava.RTTI.Toy
java.lang.Object
=================================
Displaying com.gui.demo.thingInJava.RTTI.Square
com.gui.demo.thingInJava.RTTI.Square
com.gui.demo.thingInJava.RTTI.Shape
java.lang.Object
 */
