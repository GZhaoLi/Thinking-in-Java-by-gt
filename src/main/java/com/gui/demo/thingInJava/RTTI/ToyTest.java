package com.gui.demo.thingInJava.RTTI;

/**
 * @Classname ToyTest
 * @Description TODO
 * @Date 2021/4/19 18:14
 * @Created by gt136
 */
interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
interface DNF{}

class Toy{
    Toy() { }
    Toy(int i) { }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, DNF {
    FancyToy(){
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("Class name:" + cc.getName()+" is interface? ["+ cc.isInterface()+ "]");
        System.out.println("Simple name:" + cc.getSimpleName());
        System.out.println("Canonical name:" + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.gui.demo.thingInJava.RTTI.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("can't find FancyToy!");
            System.exit(1);
        }

        printInfo(c);

        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            //动态的实现类对象
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("can not instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("can not access");
            System.exit(1);
        }

        printInfo(obj.getClass());
    }
}
/*
输出：
Class name:com.gui.demo.thingInJava.RTTI.FancyToy is interface? [false]
Simple name:FancyToy
Canonical name:com.gui.demo.thingInJava.RTTI.FancyToy
Class name:com.gui.demo.thingInJava.RTTI.HasBatteries is interface? [true]
Simple name:HasBatteries
Canonical name:com.gui.demo.thingInJava.RTTI.HasBatteries
Class name:com.gui.demo.thingInJava.RTTI.Waterproof is interface? [true]
Simple name:Waterproof
Canonical name:com.gui.demo.thingInJava.RTTI.Waterproof
Class name:com.gui.demo.thingInJava.RTTI.Shoots is interface? [true]
Simple name:Shoots
Canonical name:com.gui.demo.thingInJava.RTTI.Shoots
Class name:com.gui.demo.thingInJava.RTTI.Toy is interface? [false]
Simple name:Toy
Canonical name:com.gui.demo.thingInJava.RTTI.Toy
 */

