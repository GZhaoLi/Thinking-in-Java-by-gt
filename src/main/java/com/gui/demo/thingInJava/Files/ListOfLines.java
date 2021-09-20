package com.gui.demo.thingInJava.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Classname ListOfLines
 * @Description 文件读取
 * @Date 2021/9/6 11:25
 * @Created by gt136
 */
public class ListOfLines {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("C:\\Users\\gt136\\Downloads\\Documents\\cheese.txt"))
                .stream()
                .filter(line -> !line.startsWith("//"))//去掉第一行
                .map(line -> line.substring(0, line.length() / 2))
                .forEach(System.out::println);
    }
}
/*
outputs:
Not much of a cheese
Finest in the
And what leads you
Well, it's
It's certainly uncon
 */
