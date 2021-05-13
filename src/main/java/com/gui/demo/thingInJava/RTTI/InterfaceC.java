package com.gui.demo.thingInJava.RTTI;

import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;

import java.util.List;

/**
 * @Classname InterfaceC
 * @Description TODO
 * @Date 2021/4/29 17:36
 * @Created by gt136
 */
public class InterfaceC {
    public static void main(String[] args) {
        Null a = new A();
        a.f();

        System.out.println(a.getClass().getName());
        if (a instanceof A) {
            A aa = (A) a;
            aa.g();
        }
    }
}
