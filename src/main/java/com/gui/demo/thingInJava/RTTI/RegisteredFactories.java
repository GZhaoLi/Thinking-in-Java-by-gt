package com.gui.demo.thingInJava.RTTI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Classname RegisteredFactories
 * @Description TODO
 * @Date 2021/4/25 10:33
 * @Created by gt136
 */
class Part{
    public String toString(){
        return getClass().getSimpleName();
    }

    //    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
//    static {
//        partFactories.add(new FuelFilter.Factory());
//        partFactories.add(new AirFilter.Factory());
//        partFactories.add(new OilFactory.Factory());
//        partFactories.add(new FanBelt.Factory());
//        partFactories.add(new PowerSteeringBelt.Factory());
//    }
    static List<Class<? extends Part>> partFactories = Arrays.asList(
            FuelFilter.class, AirFilter.class, OilFactory.class, FanBelt.class, PowerSteeringBelt.class);

    private static Random random = new Random(47);
    public static Part createRandom(){
        int n = random.nextInt(partFactories.size());
//        return partFactories.get(n).create();
        try {
            return partFactories.get(n).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}


class Filter extends Part{}

class FuelFilter extends Filter{
    //为每一个具体类型创建一个类工厂
     static class Factory implements com.gui.demo.thingInJava.RTTI.Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter{
    public static class Factory implements com.gui.demo.thingInJava.RTTI.Factory<AirFilter> {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
class OilFactory extends Filter{
    public static class Factory implements com.gui.demo.thingInJava.RTTI.Factory<OilFactory> {
        @Override
        public OilFactory create() {
            return new OilFactory();
        }
    }
}


class Belt extends Part{}

class FanBelt extends Belt{
    public static class Factory implements com.gui.demo.thingInJava.RTTI.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
class PowerSteeringBelt extends Belt{
    public static class Factory implements com.gui.demo.thingInJava.RTTI.Factory<PowerSteeringBelt> {
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}
public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
/*
输出：
FanBelt
FuelFilter
FanBelt
AirFilter
AirFilter
PowerSteeringBelt
FanBelt
FuelFilter
OilFactory
OilFactory
 */