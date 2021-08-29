package com.gui.demo.thingInJava.concurrency.completablefutures;

import com.gui.demo.thingInJava.concurrency.share.Timer;

import java.util.concurrent.CompletableFuture;

/**
 * @Classname CompletableApplyChained
 * @Description TODO
 * @Date 2021/8/23 14:39
 * @Created by gt136
 */
public class CompletableApplyChained {
    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0))
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work);
        System.out.println(timer.duration());

    }
}
/*
outputs:
Machina id=0: ONE
Machina id=0: TWO
Machina id=0: THREE
Machina id=0: Complete
535
 */