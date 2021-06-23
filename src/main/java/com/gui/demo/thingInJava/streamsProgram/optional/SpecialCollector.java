package com.gui.demo.thingInJava.streamsProgram.optional;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Classname SpecialCollector
 * @Description
 * @Date 2021/6/21 23:14
 * @Created by gt136
 */
public class SpecialCollector {
    public static void main(String[] args) throws IOException {
        ArrayList<String> words = FileToWords.stream("C:\\Users\\gt136\\Downloads\\Documents\\cheese.txt")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        words.stream()
                .filter(s->s.equals("cheese"))
                .forEach(System.out::println);
    }
}
/*
output:
cheese
cheese
 */
