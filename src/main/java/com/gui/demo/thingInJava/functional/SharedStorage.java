package com.gui.demo.thingInJava.functional;

import java.util.function.IntSupplier;

/**
 * @Classname SharedStorage
 * @Description TODO
 * @Date 2021/5/24 22:32
 * @Created by gt136
 */
public class SharedStorage {
    public static void main(String[] args) {
        Closure1 c1 = new Closure1();
        IntSupplier f1 = c1.makeFun(0);
        IntSupplier f2 = c1.makeFun(0);
        IntSupplier f3 = c1.makeFun(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());
    }
}
/*
print:
0
1
2
*/
