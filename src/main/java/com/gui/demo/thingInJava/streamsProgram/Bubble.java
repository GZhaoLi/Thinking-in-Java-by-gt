package com.gui.demo.thingInJava.streamsProgram;

/**
 * @Classname Bubble
 * @Description TODO
 * @Date 2021/6/9 23:34
 * @Created by gt136
 */
public class Bubble {
    public final int i;

    public Bubble(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Bubble{" +
                "i=" + i +
                '}';
    }

    private static int count = 0;
    //静态生成器（自己满足自己）
    public static Bubble bubbler() {
        return new Bubble(count++);
    }
}
