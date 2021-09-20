package com.gui.demo.thingInJava.Files.appendixIO;

import java.io.*;
import java.util.stream.Collectors;

/**
 * @Classname BufferedInputFile
 * @Description 对文件进行字符输入
 * @Date 2021/9/10 15:54
 * @Created by gt136
 */
public class BufferedInputFile {
    public static String read(String filename) {
        try(BufferedReader input = new BufferedReader(new FileReader(filename))) {
            return input.lines()
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(read("Cheese.txt"));
    }
}
/*
outputs:
// streams/Cheese.dat
Not much of a cheese shop really, is it?
Finest in the district, sir.
And what leads you to that conclusion?
Well, it's so clean.
It's certainly uncontaminated by cheese.
 */