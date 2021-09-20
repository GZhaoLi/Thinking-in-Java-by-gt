package com.gui.demo.thingInJava.Files.standardio;

import java.io.*;

/**
 * @Classname Redirecting
 * @Description 重定向
 * @Date 2021/9/13 14:28
 * @Created by gt136
 */
public class Redirecting {
    public static void main(String[] args) {
        PrintStream console = System.out;
        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\standardio\\Redirecting.java"));
             PrintStream out = new PrintStream(
                     new BufferedOutputStream(
                             new FileOutputStream("Redirecting.txt")))
        ) {
            System.setIn(in);//将文件中内容载入到标准输入
            System.setOut(out);//重定向标准输出
            System.setErr(out);//重定向标准错误
            new BufferedReader(
                    new InputStreamReader(System.in))
                    .lines()
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.setOut(console);//在程序结束时将系统输出恢复到了该对象
        }
    }
}
