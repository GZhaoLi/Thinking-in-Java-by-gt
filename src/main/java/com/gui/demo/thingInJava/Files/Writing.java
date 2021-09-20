package com.gui.demo.thingInJava.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * @Classname Writing
 * @Description 文件写入
 * @Date 2021/9/6 14:21
 * @Created by gt136
 */
public class Writing {
    static Random rand = new Random(47);
    static final int SIZE = 1000;

    public static void main(String[] args) throws IOException {
        //写字节byte数据到文件中
        byte[] bytes = new byte[SIZE];
        //产生随机字节数组
        rand.nextBytes(bytes);
        //将 bytes 写入文件
        Files.write(Paths.get("bytes.dat"), bytes);
        System.out.println("bytes.dat: " + Files.size(Paths.get("bytes.dat")));

        //在文件中写入迭代
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\gt136\\Downloads\\Documents\\cheese.txt"));
        //将list写入文件
        Files.write(Paths.get("Cheese.txt"), lines);
        System.out.println("Cheese.txt: " + Files.size(Paths.get("Cheese.txt")));
    }
}
/*
outputs:
bytes.dat: 1000
Cheese.txt: 199
 */