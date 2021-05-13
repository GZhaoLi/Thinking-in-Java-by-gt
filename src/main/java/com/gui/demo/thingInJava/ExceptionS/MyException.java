package com.gui.demo.thingInJava.ExceptionS;

/**
 * @Classname MyException
 * @Description TODO
 * @Date 2021/4/7 16:20
 * @Created by gt136
 */
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    public MyException() {
    }
}
class FullConstructors{
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }
    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}
/* 输出
Throwing MyException from f()
com.gui.demo.thingInJava.ExceptionS.MyException
	at com.gui.demo.thingInJava.ExceptionS.FullConstructors.f(MyException.java:20)
	at com.gui.demo.thingInJava.ExceptionS.FullConstructors.main(MyException.java:25)
Throwing MyException from g()
com.gui.demo.thingInJava.ExceptionS.MyException: Originated in g()
	at com.gui.demo.thingInJava.ExceptionS.FullConstructors.g(MyException.java:25)
	at com.gui.demo.thingInJava.ExceptionS.FullConstructors.main(MyException.java:35)
 */