package com.gui.demo.thingInJava.streamsProgram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname FileToWordsRegexp
 * @Description 正则表达式：spiltAsStream
 * @Date 2021/6/15 18:03
 * @Created by gt136
 */
public class FileToWordsRegexp {
    private String all;

    public FileToWordsRegexp(String filepath) throws IOException {
        this.all = Files.lines(Paths.get(filepath))
                .skip(1)
                .collect(Collectors.joining(" "));
    }
    public Stream<String> stream() {
        //splitAsStream() 只能接收charSequence 对象，但是String 符合这种要求
        return Pattern
                .compile("[ .,?]+")
                .splitAsStream(all);
    }

    public static void main(String[] args) throws IOException {
//        Properties p = new Properties();
//        try {
//            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("identity.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String wordTxt = p.getProperty("wordTxt").trim();


        FileToWordsRegexp fw = new FileToWordsRegexp("C:\\Users\\gt136\\Downloads\\Documents\\cheese.txt");
//        FileToWordsRegexp fw = new FileToWordsRegexp(wordTxt);
        fw.stream()
                .limit(7)
                .map(m -> m + " ")
                .forEach(System.out::print);
        fw.stream()
                .skip(7)
                .limit(2)
                .map(x -> x + " ")
                .forEach(System.out::print);
    }
}
/*output:
Not much of a cheese shop really is it
 */
