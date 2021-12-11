package com.gui.demo.thingInJava.annotation;

import com.gui.demo.thingInJava.annotation.anno.Test;

/**
 * @Classname Testable
 * @Description TODO
 * @Date 2021/11/22 11:24
 * @Created by gt136
 */
public class Testable {
    public void execute() {
        System.out.println("Executing...");
    }
    @Test
    void testExecute() {
        execute();
    }
}
