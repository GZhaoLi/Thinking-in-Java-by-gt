package com.gui.demo.thingInJava.collectionAndMap;

/**
 * @Classname TupleTest
 * @Description TODO
 * @Date 2021/5/9 23:22
 * @Created by gt136
 */
class Amphibian{}
class Vehicle{}

public class TupleTest {
    static TwoTuple<String, Integer> f(){
        return new TwoTuple<>("hi", 47);
    }
    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<>(new Amphibian(), "hi", 47);
    }
    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        ThreeTuple<Amphibian, String,Integer> ttasi = g();
        System.out.println(ttasi);
        FourTuple<Vehicle, Amphibian, String, Integer> ftvasi = h();
        System.out.println(ftvasi);
    }
}
/*
输出：
(hi,47)
{third=47, first=Amphibian, second=hi}
{fourth=47, third=hi, first=Vehicle, second=Amphibian}
 */