package com.gui.demo.jvm;

/**
 * @Classname ReferenceCountingGC
 * @Description 验证Java 堆垃圾回收没有使用引用计数法:
 *          -XX:+PrintGCDetails 配置显示GC详细日志的vm属性
 *          -XX:+PrintGC 配置显示GC日志的vm属性
 * @Date 2021/9/1 22:38
 * @Created by gt136
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    //这个成员属性的唯一意义就是占点内存，以便能在GC 日志中看清是否回收过。
    private byte[] bigSize = new byte[2 * _1MB];
    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC(),
                objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假如在这行发生GC，objA和objB是否被回收？
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
/*
outputs:
简略版： 1152K->1061K 说明垃圾回收了
[GC (System.gc())  9298K->1152K(249344K), 0.0039020 secs]
[Full GC (System.gc())  1152K->1061K(249344K), 0.0132306 secs]
 */