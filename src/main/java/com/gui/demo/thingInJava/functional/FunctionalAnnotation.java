package com.gui.demo.thingInJava.functional;

/**
 * @Classname FunctionalAnnotation
 * @Description TODO
 * @Date 2021/5/20 21:33
 * @Created by gt136
 */
@FunctionalInterface
interface Functional {
    String goodBye(String arg);
}

interface FunctionalNoAnn {
    String goodBye(String arg);
}

public class FunctionalAnnotation {
    public String goodBye(String arg) {
        return "GoodBye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodBye;
        FunctionalNoAnn fna = fa::goodBye;
//        Functional ff =  fa;
        Functional f1 = (a)->"GoodBye,," + a;
        FunctionalNoAnn fna1 = a->"GoodBye, " + a;
    }
}
