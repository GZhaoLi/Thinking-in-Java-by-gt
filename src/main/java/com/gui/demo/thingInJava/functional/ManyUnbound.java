package com.gui.demo.thingInJava.functional;

/**
 * @Classname ManyUnbound
 * @Description TODO
 * @Date 2021/5/18 15:39
 * @Created by gt136
 */
class This{
    void two(int i, double d){}

    void three(int i, double d, String s) {

    }

    void four(int i, double d, String s, char c) {

    }
}

interface TwoArgs{
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(This athis, int i, double d, String s, char c);
}

public class ManyUnbound {
    public static void main(String[] args) {
        TwoArgs twoArgs = This::two;
        ThreeArgs threeArgs = This::three;
        FourArgs fourArgs = This::four;

        This athis = new This();
        twoArgs.call2(athis, 11, 3.14);
        threeArgs.call3(athis, 11, 3.14, "Three");
        fourArgs.call4(athis, 11, 3.14, "Four", 'Z');

    }
}
