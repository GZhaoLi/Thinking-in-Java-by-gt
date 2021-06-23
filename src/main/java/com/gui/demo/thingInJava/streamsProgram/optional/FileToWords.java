package com.gui.demo.thingInJava.streamsProgram.optional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @Classname FileToWords
 * @Description 将文件分为单词流
 * @Date 2021/6/17 17:13
 * @Created by gt136
 */
public class FileToWords {
    public static Stream<String> stream(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .skip(1)
                .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line));
    }
}
