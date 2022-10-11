package com.gui.demo.thingInJava.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chappyzhao
 */
public class TjwfTest {

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        AtomicInteger i = new AtomicInteger();
        Map<String, Object> map = new HashMap<>();
        objects.forEach(tjfw->{
            Object o = objects.get(i.get());
            map.put("cbbm", o);
            i.getAndIncrement();
        });
        i.getAndSet(0);
        System.out.println(map);
    }
}
