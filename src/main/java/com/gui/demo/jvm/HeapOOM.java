package com.gui.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname HeapOOM
 * @Description 配置：-Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 * @Date 2021/8/29 13:24
 * @Created by gt136
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
/*
outputs:
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid54120.hprof ...
Heap dump file created [13711601 bytes in 0.037 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    at java.util.ArrayList.add(ArrayList.java:464)
	at com.gui.demo.jvm.HeapOOM.main(HeapOOM.java:19)
 */