package com.gui.demo.thingInJava.equalshashcode;

import java.util.*;

/**
 * @Classname SlowMap
 * @Description 自己定义自己的map
 * @Date 2021/7/7 16:53
 * @Created by gt136
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V get(Object key) {
        if (!keys.contains(key)) return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);//旧的值可能为null
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else values.set(keys.indexOf(key), value);
        return oldValue;
    }

    @Override
    //这里的entrySet 不清楚：只是把keys和 values 的值便利进去吗，这样可以使得键值对唯一
    //2.0 The set is backed by the map, so changes to the map are reflected in the set,
    // and vice-versa. If the map is modified while an iteration over the set is in progress
    // (except through the iterator's own remove operation, or through the setValue operation on a map entry returned by
    // the iterator) the results of the iteration are undefined. The set supports element removal,
    // which removes the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll, retainAll
    // and clear operations. It does not support the add or addAll operations.
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()) {
            //这里的MapEntry是自己定义的：定义的泛型类包含两种类型K，V
            set.add(new MapEntry<>(ki.next(), vi.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> map = new SlowMap<>();
        map.putAll(Countries.capitals(8));
        map.forEach((k,v)-> System.out.println(k+" = "+v));
        System.out.println(map.get("BENIN"));
        //entrySet() 获得了一个set，set中包含了MapEntry类
        map.entrySet().forEach(System.out::println);
    }
}
/*
output:
CAMEROON = Yaounde
ANGOLA = Luanda
BURKINA FASO = Ouagadougou
BURUNDI = Bujumbura
ALGERIA = Algiers
BENIN = Porto-Novo
CAPE VERDE = Praia
BOTSWANA = Gaberone
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