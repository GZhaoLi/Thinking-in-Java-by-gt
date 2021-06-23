package com.gui.demo.thingInJava.streamsProgram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname RandomWords
 * @Description TODO
 * @Date 2021/6/10 15:19
 * @Created by gt136
 */
public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    RandomWords(String fname) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fname));
        //略过第一行
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+")) {
                words.add(word);
            }
        }
    }

    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(
                Stream.generate(new RandomWords("C:\\Users\\gt136\\Downloads\\Documents\\cheese.txt"))
                        .limit(10)
                        .collect(Collectors.joining(" ")));
    }
}
/*
cheese.txt
// streams/Cheese.dat
Not much of a cheese shop really, is it?
Finest in the district, sir.
And what leads you to that conclusion?
Well, it's so clean.
It's certainly uncontaminated by cheese.

output:
it shop sir the much cheese by conclusion district is
 */