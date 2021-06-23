package com.gui.demo.thingInJava.streamsProgram;

import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @Classname Reduce
 * @Description 终端操作：组合
 * @Date 2021/6/22 14:40
 * @Created by gt136
 */
class Frobnitz {
    int size;
    Frobnitz(int size){
        this.size = size;
    }

    @Override
    public String toString() {
        return "Frobnitz{" +
                "size=" + size +
                '}';
    }

    static Random rand = new Random(47);
    static final int BOUND = 100;
    //随机生成100以内的
    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}
public class Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .peek(System.out::println)
//                .reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1)
                .reduce(new BinaryOperator<Frobnitz>() {
                    @Override
                    public Frobnitz apply(Frobnitz frobnitz, Frobnitz frobnitz2) {

                        return frobnitz.size<50?frobnitz:frobnitz2;
                    }
                })
                .ifPresent(System.out::println);
    }
}
/*
output:
Frobnitz{size=58}
Frobnitz{size=55}
Frobnitz{size=93}
Frobnitz{size=61}
Frobnitz{size=61}
Frobnitz{size=29}
Frobnitz{size=68}
Frobnitz{size=0}
Frobnitz{size=22}
Frobnitz{size=7}
Frobnitz{size=29}
 */