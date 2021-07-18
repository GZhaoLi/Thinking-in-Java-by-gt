package com.gui.demo.thingInJava.equalshashcode;

import java.util.*;

/**
 * @Classname SimpleHashMap
 * @Description 理解hash的原理后实现的一个HashMap
 * @Date 2021/7/12 14:45
 * @Created by gt136
 */
public class SimpleHashMap<K,V> extends AbstractMap<K, V> {
    //选择一个初始数字作为哈希表的大小，以实现数据的均匀分布
    static final int SIZE = 997;
    //你不能有一个真正的的泛型数组，但你可以向上转换一个,这个数组用来实现拉链法
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K, V> entry : buckets[index])
            if (entry.getKey().equals(key))
                return entry.getValue();
        return null;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        //将hashCode 的绝对值对SIZE取余
        int index = Math.abs(key.hashCode()) % SIZE;
        //给每个数组下标链接一个list
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        //获取到散列码下对应的list
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> entry = it.next();
            //根据匹配的Map的key值替换已经有的
            if (entry.getKey().equals(key)) {
                oldValue = entry.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        //
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    //每个map都可以生成一个entrySet
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> entry : bucket) {
                set.add(entry);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(8));
        m.forEach((k, v) -> System.out.println(k + "=" + v));
        System.out.println(m.get("BENIN"));
        m.entrySet().forEach(System.out::println);
    }
}
/*
output:
CAMEROON=Yaounde
ANGOLA=Luanda
BURKINA FASO=Ouagadougou
BURUNDI=Bujumbura
ALGERIA=Algiers
BENIN=Porto-Novo
CAPE VERDE=Praia
BOTSWANA=Gaberone
Porto-Novo
CAMEROON = Yaounde
ANGOLA = Luanda
BURKINA FASO = Ouagadougou
BURUNDI = Bujumbura
ALGERIA = Algiers
BENIN = Porto-Novo
CAPE VERDE = Praia
BOTSWANA = Gaberone
 */
