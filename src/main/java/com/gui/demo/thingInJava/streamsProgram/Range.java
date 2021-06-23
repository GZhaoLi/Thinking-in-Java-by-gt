package com.gui.demo.thingInJava.streamsProgram;

/**
 * @Classname Range
 * @Description 这个方法类比IntStream中的range方法
 * @Date 2021/6/10 21:46
 * @Created by gt136
 */
public class Range {
    //产生从start-end逐步step增长的序列
    public static int[] range(int start, int end, int step) {
        if (step == 0) {
            throw new IllegalArgumentException("Step cannot be zero!");
        }
        int sz = Math.max(0,step >= 0 ? (end + step -1 -start) / step : (end + step + 1 -start) / step);
        int[] result = new int[sz];
        for (int i = 0; i < sz; i++) {
            result[i] = start + (i * step);
        }
        return result;
    }
    //产生从start 到 end 依次递增 1 的序列
    public static int[] range(int start, int end) {
        return range(start, end, 1);
    }
    //产生从0 到 n 依次递增 1 的序列
    public static int[] range(int n) {
        return range(0, n);
    }
}
