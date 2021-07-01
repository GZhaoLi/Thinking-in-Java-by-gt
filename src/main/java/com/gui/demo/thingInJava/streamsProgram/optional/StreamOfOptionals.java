package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.Optional;

/**
 * @Classname StreamOfOptionals
 * @Description 解包optional流
 * @Date 2021/6/29 22:40
 * @Created by gt136
 */
public class StreamOfOptionals {
    public static void main(String[] args) {
        Signal.stream()
                .limit(10)
                .forEach(System.out::println);
        System.out.println("-----------");
        //之所以上下两次rand的结果不一样是因为这其实是一次rand，因为这都是在
        Signal.stream()
                .limit(10)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}
/*
output:
Optional[Signal{msg='dash'}]
Optional[Signal{msg='dot'}]
Optional[Signal{msg='dash'}]
Optional.empty
Optional.empty
Optional[Signal{msg='dash'}]
Optional.empty
Optional[Signal{msg='dot'}]
Optional[Signal{msg='dash'}]
Optional[Signal{msg='dash'}]
-----------
Signal{msg='dot'}
Signal{msg='dot'}
Signal{msg='dash'}
Signal{msg='dash'}
 */
