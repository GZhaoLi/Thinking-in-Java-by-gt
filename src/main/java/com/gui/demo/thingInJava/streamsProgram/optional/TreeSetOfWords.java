package com.gui.demo.thingInJava.streamsProgram.optional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname TreeSetOfWords
 * @Description 将流封装到TreeSet集合中
 * @Date 2021/6/21 17:33
 * @Created by gt136
 */
public class TreeSetOfWords {
    public static void main(String[] args) throws IOException {
        //Files.lines 就已将将读取到的文件转化为了流文件
        Set<String> words2 = Files.lines(Paths.get("C:\\Users\\gt136\\Downloads\\demo\\src\\main\\java\\com\\gui\\demo\\thingInJava\\streamsProgram\\optional\\TreeSetOfWords.java"))
                .flatMap(s-> Arrays.stream(s.split("\\W+")))//split将根据参数将String切为数组，
//                .flatMap(new Function<String, Stream<String>>() {
//                    @Override
//                    public Stream<String> apply(String s) {
//                        System.out.println(s);
//                        return Arrays.stream(s.split("\\W+"));
//                    }
//                })
                .filter(s->!s.matches("\\d+"))
                .map(String::trim)//去掉字符串中的“ ”
                .filter(s->s.length()>2)
                .limit(100)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(words2);
    }
}
/*
output:
[Arrays, Collectors, Downloads, Files, IOException, Paths, Set, String, System,
 TreeSet, TreeSetOfWords, Users, args, class, collect, com, demo, file, filter,
  flatMap, get, import, java, length, limit, lines, main, map, matches,
   new, nio, optional, out, package, println, public, split, src, static, stream,
    streamsProgram, thingInJava, throws, toCollection, trim, util, void, words2]
 */
