package com.gui.demo.thingInJava.RTTI;

import jdk.nashorn.internal.ir.CatchNode;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname FilledList
 * @Description TODO
 * @Date 2021/4/21 9:52
 * @Created by gt136
 */
class CountedInteger{
    private static long counter;
    private final long id = counter++;
    public String toString(){
        return Long.toString(id);
    }
}
public class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> results = new ArrayList<>();
        try {
            for (int i = 0; i < nElements; i++) {
                results.add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> filledList = new FilledList<>(CountedInteger.class);
        System.out.println(filledList.create(15));
    }
}
/*输出：
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
 */