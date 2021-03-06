package com.gui.demo.thingInJava.RTTI;

/**
 * @Classname test01
 * @Description TODO
 * @Date 2021/4/20 14:39
 * @Created by gt136
 */
public class test01 {
    public static void main(String args[]) {
        char[] ac = "Hello, World!".toCharArray();
        System.out.println("ac.getClass() = " + ac.getClass());
        System.out.println("ac.getClass().getSuperclass() = "
                + ac.getClass().getSuperclass());
        char c = 'c';
        //! c.getClass(); // Can't do it, primitives
        // are not true objects.
        int[] ia = new int[3];
        System.out.println("ia.getClass() = " + ia.getClass());
        long[] la = new long[3];
        System.out.println("la.getClass() = " + la.getClass());
        double[] da = new double[3];
        System.out.println("da.getClass() = " + da.getClass());
        String[] sa = new String[3];
        System.out.println("sa.getClass() = " + sa.getClass());
        test01[] pot =
                new test01[3];
        System.out.println("pot.getClass() = " + pot.getClass());
        // Multi-dimensional arrays:
        int[][][] threed = new int[3][][];
        System.out.println("threed.getClass() = " + threed.getClass());
    }
}
