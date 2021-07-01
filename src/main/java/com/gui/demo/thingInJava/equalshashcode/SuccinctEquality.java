package com.gui.demo.thingInJava.equalshashcode;

import java.util.Objects;

/**
 * @Classname SuccinctEquality
 * @Description TODO
 * @Date 2021/7/1 22:33
 * @Created by gt136
 */
public class SuccinctEquality extends Equality {

    public SuccinctEquality(int i, String s, double d) {
        super(i, s, d);
        System.out.println("made 'SuccinctEquality'");
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SuccinctEquality &&
                Objects.equals(i, ((SuccinctEquality) o).i) &&
                Objects.equals(s, ((SuccinctEquality) o).s) &&
                Objects.equals(d, ((SuccinctEquality) o).d);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        Equality.testAll(SuccinctEquality::new);
    }
}
/*
output:
//此处三个是因为初始化了三次
made 'Equality'
made 'SuccinctEquality'
made 'Equality'
made 'SuccinctEquality'
made 'Equality'
made 'SuccinctEquality'
----Testing null --
null instanceof Equality: false
Excepted false, got false
----Testing same object --
same object instanceof Equality: true
Excepted true, got true
----Testing different type --
different type instanceof Equality: false
Excepted false, got false
----Testing same values --
same values instanceof Equality: true
Excepted true, got true
----Testing different values --
different values instanceof Equality: true
Excepted false, got false
 */