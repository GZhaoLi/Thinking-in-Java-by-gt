package com.gui.demo.thingInJava.streamsProgram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @Classname FileToWordsBuilder
 * @Description 流的建造者模式
 * @Date 2021/6/11 17:08
 * @Created by gt136
 */
public class FileToWordsBuilder {
    //builder方法返回了一个Builder的实现类
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws IOException {
        Files.lines(Paths.get(filePath))
                .skip(1)//跳过第一行
                .forEach(line->{
                    for (String w : line.split("[ .?,]+")) {
                        builder.add(w);
                    }
                });
    }
    public Stream<String> stream() {
        System.out.println("build 方法被调用了！");
        //返回一个创建好的流
        return builder.build();
    }

    public static void main(String[] args) throws IOException {
        new FileToWordsBuilder("C:\\Users\\gt136\\Downloads\\Documents\\cheese.txt")//这一步构造器并没有调用build方法
                .stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
/*
output:
Not much of a cheese shop really
 */