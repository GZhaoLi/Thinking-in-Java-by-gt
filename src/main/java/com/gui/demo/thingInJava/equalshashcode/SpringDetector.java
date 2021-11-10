package com.gui.demo.thingInJava.equalshashcode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Classname SpringDetector
 * @Description map的键值对的关联
 * @Date 2021/7/7 10:09
 * @Created by gt136
 */
public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type) {
        try {
            //获取到传入类的构造器
            Constructor<T> ghog = type.getConstructor(int.class);

            Map<Groundhog, Prediction> map =
                    IntStream.range(0, 10)//
                            .mapToObj(i -> {
                                try {
                                    return ghog.newInstance(i);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            })
                            .collect(Collectors.toMap(Function.identity(), gh -> new Prediction()));//toMap的两个参数都是根据传入的gh来运算的，两个参数用的是一样的值
            map.forEach((k, v) -> System.out.println(k + ": " + v));

            Groundhog gh = ghog.newInstance(3);
            System.out.println("Looking up prediction for " + gh);

            if (map.containsKey(gh)) {
                System.out.println(map.get(gh));
            }else System.out.println("Key not found: " + gh);
        } catch (NoSuchMethodException | IllegalAccessException |
                InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        detectSpring(Groundhog.class);
    }
}
/*
output:
Groundhog #2: Six more weeks of Winter!
Groundhog #9: Early Spring
Groundhog #4: Six more weeks of Winter!
Groundhog #7: Early Spring
Groundhog #1: Early Spring
Groundhog #5: Six more weeks of Winter!
Groundhog #3: Early Spring
Groundhog #6: Early Spring
Groundhog #0: Six more weeks of Winter!
Groundhog #8: Six more weeks of Winter!
Looking up prediction for Groundhog #3
Key not found: Groundhog #3
 */
