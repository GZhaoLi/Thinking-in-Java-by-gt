package com.gui.demo.thingInJava.concurrency.philosopheres;

import com.gui.demo.thingInJava.concurrency.Nap;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @Classname DiningPhilosophers
 * @Description TODO
 * @Date 2021/8/25 16:59
 * @Created by gt136
 */
public class DiningPhilosophers {
    private StickHolder[] sticks;
    private Philosopher[] philosophers;

    public DiningPhilosophers(int n) {
        sticks = new StickHolder[n];
        Arrays.setAll(sticks, i -> new StickHolder());

        philosophers = new Philosopher[n];
        Arrays.setAll(philosophers, i -> new Philosopher(i, sticks[i], sticks[(i + 1) % n]));//[1]

        //
        philosophers[1] = new Philosopher(0, sticks[0], sticks[1]);//[2]

        //为了让每个哲学家在[3]上运行，调用了runAsync，这意味着DiningPhilosophers 的构造函数立即返回到[4]
        Arrays.stream(philosophers)
                .forEach(CompletableFuture::runAsync);//[3]
    }

    public static void main(String[] args) {
        //
        new DiningPhilosophers(5);//[4]
        //在程序运行时间不到t的时候会阻止主线程退出，在程序运行时间超过t的时候，会强迫主线程退出。
        new Nap(3, "Shutdown");
    }
}
