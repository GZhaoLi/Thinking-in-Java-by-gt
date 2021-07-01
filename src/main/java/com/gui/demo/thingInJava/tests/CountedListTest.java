package com.gui.demo.thingInJava.tests;

import com.gui.demo.thingInJava.tests.validating.CountedList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname CountedListTest
 * @Description 测试
 * @Date 2021/6/23 23:21
 * @Created by gt136
 */
public class CountedListTest {
    private CountedList list;

    public static void main(String[] args) {
        assert false:
        "Here is a message saying what happened";
    }

    //静态方法
    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">>> Starting CountedListTest");
    }

    //静态方法
    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished CountedListTest");
    }

    @BeforeEach
    public void initialize() {
        list = new CountedList();
        System.out.println("Set up for " + list.getId());
        for (int i = 0; i < 3; i++) {
            list.add(Integer.toString(i));
        }
    }
    @AfterEach
    public void cleanup() {
        System.out.println("Cleaning up " + list.getId());
    }

    @Test
    public void insert() {
        System.out.println("Running testInsert()");
        //这个方法调用好几层，但是主要就是判断两个int型参数是否相等，是什么都不做，否抛出异常
        assertEquals(list.size(), 3);
        //在具体的索引位置上添加特定的元素，此元素及后续元素均后移
        list.add(1, "Insert");
        assertEquals(list.size(), 4);
        assertEquals(list.get(1), "Insert");
    }

    @Test
    public void replace() {
        System.out.println("Running testReplace()");
        assertEquals(list.size(), 3);
        //替换第一个参数位置上的元素
        list.set(1, "Replace");
        //判断，否抛出异常
        assertEquals(list.size(), 3);
        //判断对象引用是否相同，是什么也不做，否抛出异常
        assertEquals(list.get(1), "Replace");
    }

    public void compare(List<String> list, String[] strs) {
        assertArrayEquals(list.toArray(new String[0]),strs);
    }

    @Test
    public void order() {
        System.out.println("Running testOrder()");
        compare(list, new String[]{"0", "1", "2"});
    }

    @Test
    public void remove() {
        System.out.println("Running testRemove()");
        assertEquals(list.size(), 3);
        list.remove(1);
        assertEquals(list.size(), 2);
        compare(list, new String[]{"0", "2"});
    }

    @Test
    public void addAll() {
        System.out.println("Running testAddAll()");
        list.addAll(Arrays.asList(new String[]{"An", "African", "Swallow"}));
        assertEquals(list.size(), 6);
        compare(list, new String[]{
                "0", "1", "2", "An", "African", "Swallow"});
    }
}
/*
output:
>>> Starting CountedListTest
CountedList #0
Set up for 0
Running testAddAll()
Cleaning up 0
CountedList #1
Set up for 1
Running testInsert()
Cleaning up 1
CountedList #2
Set up for 2
Running testRemove()
Cleaning up 2
CountedList #3
Set up for 3
Running testOrder()
Cleaning up 3
CountedList #4
Set up for 4
Running testReplace()
Cleaning up 4
>>> Finished CountedListTest
 */