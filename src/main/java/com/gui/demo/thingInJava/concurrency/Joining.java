package com.gui.demo.thingInJava.concurrency;

/**
 * @Classname Joining
 * @Description 在线程中加入另一个线程
 * @Date 2021/7/21 11:15
 * @Created by gt136
 */
class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}
public class Joining {
    public static void main(String[] args) {
        Sleeper
                sleeper = new Sleeper("Sleeper", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner
                dopey = new Joiner("Dopey", sleeper),
                doc = new Joiner("Doc", grumpy);
    }
}
/*
output:
Grumpy has awakened
Sleeper has awakened
Doc join completed
Dopey join completed
 */