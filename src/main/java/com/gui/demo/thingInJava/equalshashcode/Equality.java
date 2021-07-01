package com.gui.demo.thingInJava.equalshashcode;

import java.util.Objects;

/**
 * @Classname Equality
 * @Description 实体类
 * @Date 2021/6/30 23:26
 * @Created by gt136
 */
public class Equality {
    protected int i;
    protected String s;
    protected double d;

    public Equality(int i, String s, double d) {
        this.i = i;
        this.s = s;
        this.d = d;
        System.out.println("made 'Equality'");
    }

    @Override
    public boolean equals(Object o) {
        //地址是否相等
        if (this == o) return true;
        //空或者类对象不一致
        if (o == null || getClass() != o.getClass()) return false;
        //判断类型是否一致
        if (!(o instanceof Equality)) return false;
        //强转
        Equality equality = (Equality) o;
        //判断是否字段相等
        if (!Objects.equals(i, equality.i)) {
            return false;
        }
        if (!Objects.equals(s, equality.s)) {
            return false;
        }
        if (!Objects.equals(d, equality.d)) {
            return false;
        }

//        return i == equality.i && Double.compare(equality.d, d) == 0 && Objects.equals(s, equality.s);
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, s, d);
    }

    public void test(String descr, String expected, Object o) {
        System.out.format("----Testing %s --%n" + "%s instanceof Equality: %s%n" +
                        "Excepted %s, got %s%n",
                descr, descr, o instanceof Equality, expected, equals(o));
    }

    public static void testAll(EqualityFactory eqf) {
        Equality
                e = eqf.make(1, "Monty", 3.14),
                eq = eqf.make(1, "Monty", 3.14),
                neq = eqf.make(99, "Bob", 1.618);
        e.test("null", "false", null);
        e.test("same object", "true", e);
        e.test("different type", "false", Integer.valueOf(99));
        e.test("same values", "true", eq);
        e.test("different values", "false", neq);
    }

    public static void main(String[] args) {
        testAll(Equality::new);
        testAll((i, s, d) -> new Equality(i, s, d));
    }
}
/*
output:
made 'Equality'
made 'Equality'
made 'Equality'
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