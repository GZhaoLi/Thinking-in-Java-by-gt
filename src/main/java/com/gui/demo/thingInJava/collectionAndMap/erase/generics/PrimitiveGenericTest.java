package com.gui.demo.thingInJava.collectionAndMap.erase.generics;

import java.util.Arrays;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/**
 * @Classname PrimitiveGenericTest
 * @Description TODO
 * @Date 2021/6/3 21:49
 * @Created by gt136
 */
interface FillArray{
    static <T> T[] fill(T[] a, Supplier<T> gen) {
        Arrays.setAll(a, n -> gen.get());
        return a;
    }

    static int[] fill(int[] a, IntSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsInt());
        return a;
    }

    static long[] fill(long[] a, LongSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsLong());
        return a;
    }

    static double[] fill(double[] a, DoubleSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsDouble());
        return a;
    }
}

public class PrimitiveGenericTest {
    public static void main(String[] args) {
        String[] strings = FillArray.fill(new String[5], () -> "9");
        System.out.println(Arrays.toString(strings));
    }
}
