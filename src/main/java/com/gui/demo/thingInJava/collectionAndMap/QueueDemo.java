package com.gui.demo.thingInJava.collectionAndMap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @Classname QueueDemo
 * @Description TODO
 * @Date 2021/3/30 13:45
 * @Created by gt136
 */
public class QueueDemo {
    public static void printQ(Queue queue) {
        //检索但是不移除头部元素，如果没有则返回null
        while (queue.peek() != null) {
            //在队列中删除头部并返回这个头部
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            //在队列中添加元素
            queue.offer(random.nextInt( i + 10));
        }
        printQ(queue);
        Queue<Character> qc = new LinkedList<>();
        for (char c : "ucaaui".toCharArray()) {
            qc.offer(c);
        }
        printQ(qc);
    }
}
