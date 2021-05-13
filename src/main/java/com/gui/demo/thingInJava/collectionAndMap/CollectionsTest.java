package com.gui.demo.thingInJava.collectionAndMap;

import java.util.*;

/**
 * @Classname CollectionsTest
 * @Description TODO
 * @Date 2021/3/29 14:05
 * @Created by gt136
 */
public class CollectionsTest {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 4));
        Integer[] moreInts = {6, 7, 9, 8, 10};
        Collections.addAll(collection, 11, 12, 14, 13, 15);
        Collections.addAll(collection, moreInts);
        System.out.println(collection);
        List<Integer> list = Arrays.asList(16, 17, 19, 18, 20);
        list.set(1, 99);
//        list.add(44);
        System.out.println(list);

        List<Integer> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList(moreInts));
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.print(num + " ");
            iterator.remove();
        }
        System.out.println(list1);

        Random rand = new Random(47);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = map.get(r);
            map.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }
}
