package com.gui.demo.thingInJava.collectionAndMap.erase.generics.decorator;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Classname Decoration
 * @Description 装饰器模式
 * @Date 2021/6/5 18:24
 * @Created by gt136
 */
class Basic{
    private String value;

    public void set(String value) {
        this.value = value;
    }
    public String get(){
        return value;
    }
}
//装饰器：继承了基类，虽然重写了父类方法，但是实现还是父类来实现。
class Decorator extends Basic {
    protected Basic basic;

    Decorator(Basic basic) {
        this.basic = basic;
    }

    @Override
    public void set(String value) {
        basic.set(value);
    }
    @Override
    public String get() {
        return basic.get();
    }
}

//时间戳继承了装饰器而不是 基类，新添了方法
class TimeStamped extends Decorator {
    private final long timeStamp;

    TimeStamped(Basic basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }
    public long getTimeStamp() {
        return timeStamp;
    }
}
//
class SerialNumbered extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;
    SerialNumbered(Basic basic) {
        super(basic);
    }
    public long getSerialNumber() {
        return serialNumber;
    }
}

public class Decoration {
    public static void main(String[] args) {
        TimeStamped t = new TimeStamped(new Basic()),
                t2 = new TimeStamped(new SerialNumbered(new Basic()));
//            t2.getSerialNumber();//不可行

        SerialNumbered s = new SerialNumbered(new Basic()),
                s2 = new SerialNumbered(new TimeStamped(new Basic()));
//      s2.getTimeStamped();//不可行
    }
}
