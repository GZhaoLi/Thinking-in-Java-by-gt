package com.gui.demo.thingInJava.equalshashcode;

import java.util.Random;

/**
 * @Classname Prediction
 * @Description 预测天气
 * @Date 2021/7/6 18:10
 * @Created by gt136
 */
public class Prediction {
    private static Random rand = new Random(47);

    @Override
    public String toString() {
        return rand.nextBoolean() ? "Six more weeks of Winter!" : "Early Spring";
    }

}
