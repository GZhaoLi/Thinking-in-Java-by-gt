package com.gui.demo.thingInJava.equalshashcode;

import java.util.Objects;

/**
 * @Classname ComposedEquality
 * @Description TODO
 * @Date 2021/7/1 22:46
 * @Created by gt136
 */
class Part {
    String ss;
    double dd;

    Part(String ss, double dd) {
        this.ss = ss;
        this.dd = dd;
    }

    @Override
    public boolean equals(Object o) {
        /*if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return Double.compare(part.dd, dd) == 0 && Objects.equals(ss, part.ss);*/
        return o instanceof Part &&
                Objects.equals(ss, ((Part) o).ss) &&
                Objects.equals(dd, ((Part) o).dd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ss, dd);
    }
}
public class ComposedEquality extends SuccinctEquality{
    Part part;
    public ComposedEquality(int i, String s, double d) {
        super(i, s, d);
        part = new Part(s, d);
        System.out.println("made 'ComposedEquality'");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComposedEquality that = (ComposedEquality) o;
        return Objects.equals(part, that.part);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), part);
    }

    public static void main(String[] args) {
        Equality.testAll(ComposedEquality::new);
    }
}
/*
output:
//这里有三对是因为初始化了三次
made 'Equality'
made 'SuccinctEquality'
made 'ComposedEquality'
made 'Equality'
made 'SuccinctEquality'
made 'ComposedEquality'
made 'Equality'
made 'SuccinctEquality'
made 'ComposedEquality'
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