package com.gui.demo.thingInJava.equalshashcode;

import java.util.Objects;

/**
 * @Classname Groundhog2
 * @Description 重写哈希和equals，改变比较内容
 * @Date 2021/7/7 16:15
 * @Created by gt136
 */
public class Groundhog2 extends Groundhog {
    public Groundhog2(int number) {
        super(number);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Groundhog2 &&
                Objects.equals(number, ((Groundhog2) o).number);
    }
}
