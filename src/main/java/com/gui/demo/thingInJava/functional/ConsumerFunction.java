package com.gui.demo.thingInJava.functional;

import java.util.function.Function;

/**
 * @Classname ConsumerFunction
 * @Description 消费函数的函数
 * @Date 2021/5/24 16:39
 * @Created by gt136
 */
class One{}
class Two{}

public class ConsumerFunction {
    static Two consume(Function<One, Two> oneTwoFunction){
        return oneTwoFunction.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
        Two two1 = consume(new Function<One, Two>() {
            @Override
            public Two apply(One one) {
                return new Two();
            }
        });
    }
}
