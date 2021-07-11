package com.gui.demo.thingInJava.equalshashcode;

/**
 * @Classname SpringDetector2
 * @Description 测试重写哈希和equals方法后成功生成了map中 的键
 * @Date 2021/7/7 16:20
 * @Created by gt136
 */
public class SpringDetector2 {
    public static void main(String[] args) {
        SpringDetector.detectSpring(Groundhog2.class);
    }
}
/*
output:
Groundhog #0: Six more weeks of Winter!
Groundhog #1: Early Spring
Groundhog #2: Six more weeks of Winter!
Groundhog #3: Early Spring
Groundhog #4: Early Spring
Groundhog #5: Six more weeks of Winter!
Groundhog #6: Early Spring
Groundhog #7: Early Spring
Groundhog #8: Six more weeks of Winter!
Groundhog #9: Six more weeks of Winter!
Looking up prediction for Groundhog #3
Early Spring
 */