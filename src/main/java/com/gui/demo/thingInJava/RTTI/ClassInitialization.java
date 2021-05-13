package com.gui.demo.thingInJava.RTTI;

import java.util.Random;

/**
 * @Classname ClassInitialization
 * @Description TODO
 * @Date 2021/4/20 16:40
 * @Created by gt136
 */
class Initable{
    static final int staticFinal = 47;
    static final int StaticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}
class Initable2{
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}
public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.StaticFinal2);
        System.out.println(Initable2.staticNonFinal);
    }
}
/*输出：
After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
 */