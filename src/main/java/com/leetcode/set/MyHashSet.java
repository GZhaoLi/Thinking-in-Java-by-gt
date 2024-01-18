package com.leetcode.set;

import java.util.ArrayList;
import java.util.List;

/**
 * MyHashSet 自定义hashset
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。在饲养员的视频中给了一个思路：
 * 就是拿一个数组来存放true与false来判断是否有值。这个就很简单了 ，也不需要考虑冲突。
 * 但是就会很占空间，比如我有100000个值就需要这么大的连续数组。但是比较简单的
 * @author chappyzhao
 * @version 2024/01/03 14:55
 **/
public class MyHashSet {
    private Object[] set;
    private List<Integer> target;
    //默认装填因子为14
    private final Integer val = 10000;
    private int i;
    public MyHashSet() {
        set = new Object[val];
    }

    public void add(int key) {
        i = key % val;

        if (set[i] != null && !set[i].equals(key)) {
            //set[i]如果不是int 判断是否存在相同的值
            target = (List<Integer>) set[i];
            if (!target.contains((Object) key)) {
                target.add(key);
                set[i] = target;
            }
        } else if (set[i] == null) {
            target =new ArrayList<>();
            target.add(key);
            set[i] = target;
        }
    }

    public void remove(int key) {
        i = key % val;
        if (set[i] != null) {
            if (set[i].getClass().equals(Integer.class)) {
                if (key == (Integer) set[i]) {
                    set[i] = null;
                }
            }else {
                List<Integer> list = (List<Integer>) set[i];
                if (contains(key)) {
                    list.remove((Object)key);
                    set[i] = list;
                }
            }
        }
    }

    public boolean contains(int key) {
        i = key % val;
        if (set[i] != null) {
            if (set[i].getClass().equals(Integer.class)) {
                if (key == (Integer) set[i]) {
                    return true;
                }
            }else {
                List<Integer> list = (List<Integer>) set[i];
                return list.contains(key);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(11);
        myHashSet.add(222);
        boolean contains = myHashSet.contains(3);
        System.out.println(contains);
        myHashSet.remove(222);

    }
}
