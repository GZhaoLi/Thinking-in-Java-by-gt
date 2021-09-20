package com.gui.demo.thingInJava.Files;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @Classname StreamInAndOut
 * @Description TODO
 * @Date 2021/9/6 18:23
 * @Created by gt136
 */
public class StreamInAndOut {
    public static void main(String[] args) {
        //构建了输入输出流
        try (Stream<String> input = Files.lines(Paths.get("src\\main\\java\\com\\gui\\demo\\thingInJava\\Files\\StreamInAndOut.java"));
        PrintWriter output = new PrintWriter("StreamInAndOut.txt"))
        {
            //将输入流中的字符串全部大写
            input.map(String::toUpperCase)
                    .forEachOrdered(output::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
