package com.gui.demo.thingInJava.functional;

/**
 * @Classname RunnableMethodReferences
 * @Description TODO
 * @Date 2021/5/17 17:34
 * @Created by gt136
 */
class Go{
    static void go(){
        System.out.println("Go::go()");
    }
}
public class RunnableMethodReferences {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(() -> System.out.println("Lambda")).start();

        new Thread(Go::go).start();
    }
}
/*
print:
Anonymous
Lambda
Go::go()
 */