package com.gui.demo.thingInJava.Files.appendixIO;

import java.io.*;

/**
 * @Classname FileOutputShortcut
 * @Description 使用缓冲，但是不用手动添加了
 * @Date 2021/9/10 17:36
 * @Created by gt136
 */
public class FileOutputShortcut {
    static String file = "FileOutputShortcut.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\appendixIO\\FileOutputShortcut.java")
                ));
             //PrintWriter 提供了格式化功能，它创建的数据文件可作为普通文本来读取。且它可以自动添加缓冲
             PrintWriter out = new PrintWriter(file)
        ) {
            in.lines().forEach(out::println);
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        System.out.println(BufferedInputFile.read(file));

    }
}
