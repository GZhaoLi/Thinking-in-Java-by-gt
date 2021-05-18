package com.gui.demo.thingInJava.functional;

/**
 * @Classname RecursiveFactorial
 * @Description TODO
 * @Date 2021/5/17 16:02
 * @Created by gt136
 */
interface IntCall{
    int call(int arg);
}
public class RecursiveFactorial {
    static IntCall fact;

    public static void main(String[] args) {
        fact = arg -> arg == 0 ? 1 : arg * fact.call(arg - 1);
        for (int i = 0; i <= 10; i++) {
            System.out.println(fact.call(i));
        }
    }
}
/*
print:
1
1
2
6
24
120
720
5040
40320
362880
3628800
 */