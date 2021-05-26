package com.gui.demo.thingInJava.functional;

import java.util.function.Function;

/**
 * @Classname Curry3Args
 * @Description TODO
 * @Date 2021/5/26 11:18
 * @Created by gt136
 */
public class Curry3Args {
    public static void main(String[] args) {
        Function<String,
                Function<String,
                        Function<String,
                                Function<String, String>>>> sum =
                a -> b -> c -> d -> a + b + c + d;
        //这个是上述表达式的展开描述
        Function<String,
                Function<String,
                        Function<String,
                                Function<String, String>>>> sum1 =
                new Function<String, Function<String, Function<String, Function<String, String>>>>() {
                    @Override
                    public Function<String, Function<String, Function<String, String>>> apply(String s) {
                        return new Function<String, Function<String, Function<String, String>>>() {
                            @Override
                            public Function<String, Function<String, String>> apply(String s) {
                                return new Function<String, Function<String, String>>() {
                                    @Override
                                    public Function<String, String> apply(String s) {
                                        return new Function<String, String>() {
                                            @Override
                                            public String apply(String s) {
                                                return s;
                                            }
                                        };//s->s
                                    }
                                };//s->s1->s1
                            }
                        };//s->s1->s2->s2
                    }
                };//s->s1->s2->s3->s+s1+s2+s3

        Function<String, Function<String, Function<String, String>>> ho =
                sum.apply("ho ");
        Function<String, Function<String, String>> hi =
                ho.apply("Hi ");
        Function<String, String> aloha =
                hi.apply("aloha! ");

        System.out.println(aloha.apply("Hup"));
    }
}
/*
print:
ho Hi aloha! Hup
 */