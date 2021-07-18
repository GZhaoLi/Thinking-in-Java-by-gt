package com.gui.demo.thingInJava.equalshashcode;

import java.util.*;

/**
 * @Classname CountedString
 * @Description 单字段使用Objects.hashCode
 * @Date 2021/7/13 16:32
 * @Created by gt136
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    public CountedString(String str) {
        s = str;
        created.add(s);
        //id 是this类使用的String实例总数
        for (String s2 : created) {
            if (s2.equals(s))
                id++;
        }
    }

    @Override
    public int hashCode() {
        //很简单的实现：返回s.hashCode() * id;
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString &&
                Objects.equals(s,((CountedString) obj).s) &&
                Objects.equals(id,((CountedString) obj).id);
    }

    @Override
    public String toString() {
        return "String: " + s +" id: "+id+" hashCode: "+hashCode();
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        System.out.println("==================");
        for (CountedString cstring : cs) {
            System.out.println("Looking up " + cstring);
            System.out.println(map.get(cstring));
        }
    }
}
/*
output:
//记得打印 map 的时候，等于号‘=’前面所有的对应后面的
{String: hi id: 4 hashCode: 146450=3, String: hi id: 5 hashCode: 146451=4, String: hi id: 2 hashCode: 146448=1, String: hi id: 3 hashCode: 146449=2, String: hi id: 1 hashCode: 146447=0}
==================
Looking up String: hi id: 1 hashCode: 146447
0
Looking up String: hi id: 2 hashCode: 146448
1
Looking up String: hi id: 3 hashCode: 146449
2
Looking up String: hi id: 4 hashCode: 146450
3
Looking up String: hi id: 5 hashCode: 146451
4
 */
