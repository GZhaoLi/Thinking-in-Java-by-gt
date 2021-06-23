package com.gui.demo.thingInJava.interface1;

/**
 * @Classname Operations
 * @Description 操作
 * @Date 2021/6/14 22:17
 * @Created by gt136
 */
public interface Operations {
    void execute();
    static void runOps(Operations... ops) {
        for(Operations op : ops)
            op.execute();
    }
    static void show(String msg) {
        System.out.println(msg);
    }
}

