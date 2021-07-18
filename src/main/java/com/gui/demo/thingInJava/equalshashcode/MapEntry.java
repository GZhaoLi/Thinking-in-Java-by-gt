package com.gui.demo.thingInJava.equalshashcode;

import java.util.Map;
import java.util.Objects;

/**
 * @Classname MapEntry
 * @Description 这个类是Map和Set的核心，Map中的Entry中是一个Set，而Set中的值是这个类所实现的
 * @Date 2021/7/7 17:11
 * @Created by gt136
 */
public class MapEntry<K,V> implements Map.Entry<K,V>{
    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V result = this.value;
        this.value = value;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
        return Objects.equals(key, mapEntry.key) && Objects.equals(value, mapEntry.value);
    }

    @Override
    public int hashCode() {
//        System.out.println(Objects.hash(key,value));
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }
}
