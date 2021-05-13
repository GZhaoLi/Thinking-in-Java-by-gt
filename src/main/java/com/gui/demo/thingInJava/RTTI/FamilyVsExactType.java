package com.gui.demo.thingInJava.RTTI;

/**
 * @Classname FamilyVsExactType
 * @Description TODO
 * @Date 2021/4/26 16:37
 * @Created by gt136
 */
class Base{}
class Derived extends Base{
}

public class FamilyVsExactType {
    static void test(Object x) {
        System.out.println("Testing x of type " + x.getClass().getSimpleName());
        System.out.println("x instanceof Base " + (x instanceof Base));
        System.out.println("x instanceof Derived " + (x instanceof Derived));
        System.out.println("Base.instance(x) " + Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x) " + Derived.class.isInstance(x));
        System.out.println("x.getClass() == Base.class " + (x.getClass() == Base.class));
        System.out.println("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
        System.out.println("x.getClass.equals(Base.class) " + x.getClass().equals(Base.class));
        System.out.println("x.getClass.equals(Derived.class) " + x.getClass().equals(Derived.class));
    }

    public static void main(String[] args) {
        test(new Base());
        System.out.println("==================================================");
        test(new Derived());
    }
}
/*
输出
Testing x of type Base
x instanceof Base true
x instanceof Derived false
Base.instance(x) true
Derived.isInstance(x) false
x.getClass() == Base.class true
x.getClass() == Derived.class false
x.getClass.equals(Base.class) true
x.getClass.equals(Derived.class) false
==================================================
Testing x of type Derived
x instanceof Base true
x instanceof Derived true
Base.instance(x) true
Derived.isInstance(x) true
x.getClass() == Base.class false
x.getClass() == Derived.class true
x.getClass.equals(Base.class) false
x.getClass.equals(Derived.class) true
 */