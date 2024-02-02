package com.leetcode.tree;

import java.util.*;

/**
 * TopKFrequent 前k个高频词<title>
 * <p>java中使用java.util.PriorityQueue实现堆，构造函数可传入两个参数（size，new Comparator）</p>
 * <p>size:初始化堆的大小，默认为11，可自动扩展</p>
 * <p>Comparator:定义了堆排序的规则，默认为小顶堆，若要实现大顶堆，则需要重写Comparator类中的 compare 方法，默认按自然排序</p>
 * <p>小顶堆：应用场景寻找无序数组的前k个最大数，思想：遍历数组，用一个大小为k的小顶堆保存当前找到的前k个最大数，如果下一个数组元素比堆顶大，那堆顶元素出堆，此数组元素入堆</p>
 * <P>大顶堆：应用场景寻找无序数组的前k个最小数，需重写 Comparator 的 compare(Integer a, Integer b) 方法，在方法内用参数2减参数1(小顶堆为参数1减参数2)，
 * 思想：遍历数组，用一个大小为k的大顶堆保存当前找到的前k个最小数，如果下一个数组元素比堆顶小，则替换</P>
 * @author chappyzhao
 * @version 2024/01/17 15:52
 **/
public class TopKFrequent {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //这个和上面的都可以
        /*for (String word : words) {
            map.putIfAbsent(word, 1);
            Integer inte = map.get(word);
            map.put(word, inte + 1);
        }*/
        //在这个小顶堆的构建中，首先要熟悉Comparator的比较方法，是拿堆顶的值与当前的值做差，很容易混淆；其次是要将map的key入堆进行排序，避免后续的二次排序
        PriorityQueue<String> smallHeap = new PriorityQueue<>((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2)) ) {
                return o2.compareTo(o1);
            }else
                return map.get(o1) - map.get(o2);
        });
        map.forEach((key,v)->{
            if (smallHeap.size() > k) {
                smallHeap.poll();
            }else {
                smallHeap.offer(key);
            }
        });

        List<String> list = new ArrayList<>();
        while (!smallHeap.isEmpty()) {
            list.add(smallHeap.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
