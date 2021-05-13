package com.gui.demo.thingInJava.innerclasses;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

/**
 * @Classname DotThis
 * @Description TODO
 * @Date 2021/3/23 16:33
 * @Created by gt136
 */
public class DotThis {
    void f(){
        System.out.println("DotThis.f()");
    }
    public class Inner{
        public DotThis outer(){
            //这个this是inner
            return DotThis.this;
        }
    }
    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
