package com.gui.demo.thingInJava.concurrency.philosopheres;

/**
 * @Classname Philosopher
 * @Description TODO
 * @Date 2021/8/25 16:50
 * @Created by gt136
 */
public class Philosopher implements Runnable{
    private final int seat;
    private final StickHolder left,right;

    public Philosopher(int seat, StickHolder left, StickHolder right) {
        this.seat = seat;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "P" + seat;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Thinking");
            right.pickUp();
            left.pickUp();
            System.out.println(this + " eating");
            right.putDown();
            left.putDown();
        }
    }
}
