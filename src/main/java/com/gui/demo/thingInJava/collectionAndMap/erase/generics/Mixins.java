package com.gui.demo.thingInJava.collectionAndMap.erase.generics;

import java.util.Date;

/**
 * @Classname Mixins
 * @Description TODO
 * @Date 2021/6/5 10:25
 * @Created by gt136
 */
interface TimeStamped{
    long getStamp();
}

class TimeStampedImp implements TimeStamped {

    private final long timeStamp;
    TimeStampedImp() {
        //new Date():date类会自己调用自己的有参构造方法将当前的时间（long型）赋给date字段，getTime()会获取到当前时间
        this.timeStamp = new Date().getTime();
    }
    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {long getSerialNumber();}

class SerialNumberedImpl implements SerialNumbered {

    //当你想要观察这个实现类被调用几次的时候，这是个非常好用的方法，我给它叫计数法
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}
interface Basic{
    void set(String val);

    String get();
}

class BasicImp implements Basic {
    private String value;
    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}
//这个类也是将这几个功能结构类似的类组合在一起
class Mixin extends BasicImp implements TimeStamped, SerialNumbered{

    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImpl();
    @Override
    public long getStamp() {
        return timeStamp.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}

public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(),
                mixin2 = new Mixin();
        mixin1.set("test string");
        mixin2.set("test String");

        System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerialNumber());

        System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerialNumber());

    }
}
/*
output:
test string 1622861295429 1
test String 1622861295430 2
 */