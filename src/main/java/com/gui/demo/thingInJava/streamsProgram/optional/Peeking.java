package com.gui.demo.thingInJava.streamsProgram.optional;

import com.gui.demo.thingInJava.streamsProgram.FileToWordsBuilder;

import java.io.IOException;
import java.util.Comparator;

/**
 * @Classname Peeking
 * @Description peek
 * @Date 2021/6/15 22:26
 * @Created by gt136
 */
public class Peeking {
    public static void main(String[] args) throws IOException {
        FileToWordsBuilder fw = new FileToWordsBuilder("C:\\Users\\gt136\\Downloads\\Documents\\cheese.txt"),
                fw2 = new FileToWordsBuilder("C:\\Users\\gt136\\Downloads\\Documents\\cheese.txt");
        fw.stream()
                .skip(21)//跳过前21个字符
                .limit(4)//只取前4个
                .map(w -> w + " ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);

        /**
         *         可能是在FileToWordsBuilder中定义的builder是流的原因，此处不可以再次处理fw，
         *         只能单独定义一个新的,这是正确的！！因为流不能被复用，它处理过就不能用了！
         */
        fw2.stream()
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .map(w -> w + " ")
                .forEach(System.out::print);

    }
}
/*
output:
Well WELL well it's IT'S it's so SO so clean CLEAN clean
you what to the that sir leads in district And
*/