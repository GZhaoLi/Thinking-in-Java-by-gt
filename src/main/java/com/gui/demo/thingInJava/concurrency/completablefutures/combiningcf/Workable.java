package com.gui.demo.thingInJava.concurrency.completablefutures.combiningcf;

import com.gui.demo.thingInJava.concurrency.Nap;

import java.util.concurrent.CompletableFuture;

/**
 * workable可行的任务
 * @Date 2021/8/26 14:56
 * @Created by gt136
 */
public class Workable {
    String id;
    final double duration;

    public Workable(String id, double duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Workable{" + id + '}';
    }

    public static Workable work(Workable tt) {
        //睡眠传入的参数的时间
        new Nap(tt.duration);
        tt.id = tt.id + "W";
        System.out.println(tt);
        return tt;
    }

    public static CompletableFuture<Workable> make(String id, double duration) {
        //和上例一样不多赘述
        return CompletableFuture.completedFuture(new Workable(id, duration))
                .thenApplyAsync(Workable::work);
    }
}
