package com.gui.demo.jvm.jvmengine;

import java.util.Map;

public class TestJVM {
    private static final int _1MB = 1024 * 1024;

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    /*public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = new byte[4 * _1MB];

    }*/

    /**
     *
     */
    @SuppressWarnings("unused")
    public static void testHandlePromotion() throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4,allocation5,allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB]; //
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
        Thread.sleep(5000);

    }


    public static void main(String[] args) throws InterruptedException {
//
//        testAllocation();
        testHandlePromotion();

    }
}
