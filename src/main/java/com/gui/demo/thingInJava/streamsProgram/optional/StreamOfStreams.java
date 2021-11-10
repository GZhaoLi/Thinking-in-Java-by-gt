package com.gui.demo.thingInJava.streamsProgram.optional;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流中流 其中的 map 方法 ：public final <R> Stream<R> map(Function<? super P_OUT, ? extends R> mapper) {}
 *      这个map中的参数是个 Function：也就是说会调用其中的apply方法，这个是自己实现的；而 Function 中的参数，第一个是指我们输入流的类型，
 *      就是说如果你这个流的类型时 Integer 型，那这个就是 Integer 型；第二个参数是指你返回的新的流的类型，这个也可以自己定义。
 * @Date 2021/6/17 16:41
 * @Created by gt136
 */
public class StreamOfStreams {
    static Random rand = new Random(47);
    public static void main(String[] args) {
        Stream.of(1,2,3)
                /*.map(new Function<Integer, Stream<String>>() {
                    @Override
                    public Stream<String> apply(Integer integer) {
                        return Stream.of("null");
                    }
                })*/
                .map(i->Stream.of("Gonzo","Kermit","Breaker"))
                .map(e->e.getClass().getName())
                .forEach(System.out::println);

        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Kermit", "Breaker"))
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(i -> IntStream.concat(
                        rand.ints(0, 100).limit(i), IntStream.of(-1)))
                .forEach(n -> System.out.format("%d ", n));

    }
}
/*
output:
java.util.stream.ReferencePipeline$Head
java.util.stream.ReferencePipeline$Head
java.util.stream.ReferencePipeline$Head
Gonzo
Kermit
Breaker
Gonzo
Kermit
Breaker
Gonzo
Kermit
Breaker
58 -1 55 93 -1 61 61 29 -1 68 0 22 7 -1 88 28 51 89 9 -1
 */