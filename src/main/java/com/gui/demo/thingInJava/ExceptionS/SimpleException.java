package com.gui.demo.thingInJava.ExceptionS;

/**
 * @Classname SimpleException
 * @Description TODO
 * @Date 2021/4/7 15:35
 * @Created by gt136
 */
public class SimpleException extends Exception {
}
class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions ihe = new InheritingExceptions();
        try {
            ihe.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}
/*
Throw SimpleException from f()
Caught it!
 */
