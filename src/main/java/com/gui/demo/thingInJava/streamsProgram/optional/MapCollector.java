package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname MapCollector
 * @Description
 * @Date 2021/6/21 18:01
 * @Created by gt136
 */
class Pair{
    public final Character c;
    public final Integer i;

    public Pair(Character c, Integer i) {
        this.c = c;
        this.i = i;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "c=" + c +
                ", i=" + i +
                '}';
    }

    public Character getC() {
        return c;
    }

    public Integer getI() {
        return i;
    }
}

class RandomPair{
    Random rand = new Random(47);
    //随机大写字母的无限迭代器
    Iterator<Character> captures = rand.ints(65, 91)
            .mapToObj(i -> (char) i)//
            .iterator();

    public Stream<Pair> stream() {
        return rand.ints(100, 1000)
                .distinct()
                .mapToObj(i -> new Pair(captures.next(), i));
    }
}
public class MapCollector {
    public static void main(String[] args) {
        Map<Integer, Character> map = new RandomPair().stream()
                .limit(8)
                .collect(Collectors.toMap(Pair::getI, Pair::getC));
        System.out.println(map);
    }
}
/*
output:
{688=W, 309=C, 293=B, 761=N, 858=N, 668=G, 622=F, 751=N}
 */
