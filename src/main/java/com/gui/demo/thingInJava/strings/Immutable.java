package com.gui.demo.thingInJava.strings;

import java.util.Random;

/**
 * @Classname Immutable
 * @Description TODO
 * @Date 2021/4/8 21:05
 * @Created by gt136
 */
public class Immutable {
    public static Random random = new Random(47);
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            sb.append(random.nextInt(100));
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Immutable imu = new Immutable();
        System.out.println(imu);
    }
}
/*
[58,55,93,61,61,29,68,0,22,7,88,28,51,89,9,78,98,61,20,58,16,40,11,22,]
 */