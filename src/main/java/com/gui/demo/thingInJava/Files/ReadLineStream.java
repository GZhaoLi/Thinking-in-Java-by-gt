package com.gui.demo.thingInJava.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Classname ReadLineStream
 * @Description 随机读取或者只读片段
 * @Date 2021/9/6 18:18
 * @Created by gt136
 */
public class ReadLineStream {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\PathInfo.java"))
                .skip(22)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
/*
outputs:
        show("RegularFile", Files.isRegularFile(path));
 */