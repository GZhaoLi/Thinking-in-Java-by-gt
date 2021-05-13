package com.gui.demo.thingInJava.collectionAndMap;

import com.gui.demo.thingInJava.RTTI.Pet;
import com.gui.demo.utils.New;

import java.util.List;
import java.util.Map;

/**
 * @Classname LimitOfInterface
 * @Description TODO
 * @Date 2021/5/11 10:39
 * @Created by gt136
 */
public class LimitOfInterface {
    static void f(Map<String, List<? extends Pet>> petPerson) {
        f(New.map());
    }
}
