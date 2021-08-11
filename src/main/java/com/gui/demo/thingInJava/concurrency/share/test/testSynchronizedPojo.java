package com.gui.demo.thingInJava.concurrency.share.test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.gui.demo.thingInJava.concurrency.CaptureUncaughtException;

/**
 * @Classname testSynchronizedPojo
 * @Description TODO
 * @Date 2021/8/10 10:47
 * @Created by gt136
 */
class Tank {
    enum State{EMPTY, LOADED}
    private State state = State.EMPTY;
    private int current_load = 0;
    public void validate() {
        if ((state == State.EMPTY && current_load != 0)||(state == State.LOADED && current_load == 0)) {
            throw new IllegalStateException();
        }
    }
    public void fill() {
        state = State.LOADED;
        Thread.yield();
        current_load = 10;
    }
    public void drain() {
        state = State.EMPTY;
        Thread.yield();
        current_load = 0;
    }
}

class ConsistencyChecker implements Runnable {
    private static Random rand = new Random(47);
    private Tank tank;

    ConsistencyChecker(Tank tank) {
        this.tank = tank;
    }
    @Override
    public void run() {
        for (;;) {
            if (rand.nextBoolean())
                tank.fill();
            else tank.drain();
            tank.validate();
        }
    }
}
public class testSynchronizedPojo {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println("caught " + e));
        ExecutorService exec = Executors.newCachedThreadPool();
        Tank tank = new Tank();
        for (int i = 0; i < 10; i++) {
            exec.execute(new ConsistencyChecker(tank));
        }
        Thread.yield();
        exec.shutdown();
    }
}
