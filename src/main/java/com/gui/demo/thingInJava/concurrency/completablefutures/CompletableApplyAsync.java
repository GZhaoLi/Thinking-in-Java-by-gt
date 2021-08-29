package com.gui.demo.thingInJava.concurrency.completablefutures;

import com.gui.demo.thingInJava.concurrency.share.Timer;

import java.util.concurrent.CompletableFuture;

/**
 * @Classname CompletableApplyAsync
 * @Description TODO
 * @Date 2021/8/23 15:15
 * @Created by gt136
 */
public class CompletableApplyAsync {
    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0))
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work);
        System.out.println(timer.duration());
        System.out.println(cf.join());
        System.out.println(timer.duration());
    }
}
/*
outputs:
50
Machina id=0: ONE
Machina id=0: TWO
Machina id=0: THREE
Machina id=0: Complete
Machina id=0: Complete
484
 */