package com.gui.demo.thingInJava.functional;

/**
 * @Classname Fibonacci
 * @Description TODO
 * @Date 2021/5/17 16:14
 * @Created by gt136
 */
public class Fibonacci {
    IntCall fib;
    Fibonacci(){
        fib = arg -> arg == 0 ? 0 : arg == 1 ? 1 : fib.call(arg - 1) + fib.call(arg - 2);
    }

    int fibona(int arg) {
        return fib.call(arg);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        for (int i = 0; i <= 10; i++) {
            System.out.println(f.fibona(i));
        }
    }
}
