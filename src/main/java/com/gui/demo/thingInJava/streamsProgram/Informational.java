package com.gui.demo.thingInJava.streamsProgram;

import com.gui.demo.thingInJava.streamsProgram.optional.FileToWords;

import java.io.IOException;

/**
 * @Classname Informational
 * @Description TODO
 * @Date 2021/6/23 10:16
 * @Created by gt136
 */
public class Informational {
    public static void main(String[] args) throws IOException {
        System.out.println(FileToWords.stream("C:\\Users\\gt136\\Downloads\\Documents\\cheese.txt").count());
        System.out.println(FileToWords.stream("C:\\Users\\gt136\\Downloads\\Documents\\cheese.txt")
                .min(String.CASE_INSENSITIVE_ORDER)
                .orElse("NONE"));
        System.out.println(FileToWords.stream("C:\\Users\\gt136\\Downloads\\Documents\\cheese.txt")
                .max(String.CASE_INSENSITIVE_ORDER)
                .orElse("NONE"));
    }
}
/*
output:
32
a
you
 */