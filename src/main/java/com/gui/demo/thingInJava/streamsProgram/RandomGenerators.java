package com.gui.demo.thingInJava.streamsProgram;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @Classname RandomGenerators
 * @Description TODO
 * @Date 2021/6/10 14:54
 * @Created by gt136
 */
public class RandomGenerators {
    public static <T> void show(Stream<T> stream) {
        stream
                .limit(4)
                .forEach(System.out::println);
        System.out.println("+++++++++++++++");
    }

    public static void main(String[] args) {
        Random rd = new Random(47);
        /*
        不控制上下限，如果没有show方法中的limit，将会无限产生IntStream中的值。
        此处boxed方法之前已经生成了流，只是是基本数据类型的（如IntStream），而boxed 可以将基本数据类型进行包装（Stream<Integer>）
         */
        show(rd.ints().boxed());
        show(rd.longs().boxed());
        show(rd.doubles().boxed());
        //控制上下限
        show(rd.ints(10, 20).boxed());
        show(rd.longs(50, 100).boxed());
        show(rd.doubles(20, 30).boxed());
        //控制流大小
        show(rd.ints(2).boxed());
        show(rd.longs(2).boxed());
        show(rd.doubles(2).boxed());
        //控制流的大小和界限
        show(rd.ints(2, 10, 20).boxed());
        show(rd.longs(2, 50, 100).boxed());
        show(rd.doubles(2, 20, 30).boxed());
    }
}
/*
output:
-1172028779
1717241110
-2014573909
229403722
+++++++++++++++
2955289354441303771
3476817843704654257
-8917117694134521474
4941259272818818752
+++++++++++++++
0.2613610344283964
0.0508673570556899
0.8037155449603999
0.7620665811558285
+++++++++++++++
16
10
11
12
+++++++++++++++
65
99
54
58
+++++++++++++++
29.86777681078574
24.83968447804611
20.09247112332014
24.046793846338723
+++++++++++++++
1169976606
1947946283
+++++++++++++++
2970202997824602425
-2325326920272830366
+++++++++++++++
0.7024254510631527
0.6648552384607359
+++++++++++++++
17
18
+++++++++++++++
81
86
+++++++++++++++
21.898377705316413
23.22662025293785
+++++++++++++++
 */