package com.gui.demo.thingInJava.concurrency.completablefutures;

import java.util.concurrent.CompletableFuture;

/**
 * @Classname CompletableApply
 * @Description thenApply
 * @Date 2021/8/23 11:19
 * @Created by gt136
 */
public class CompletableApply {
    public static void main(String[] args) {
        //返回一个已经完成的CompletableFuture;它返回的是调用了Machina中的toString方法
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));
        CompletableFuture<Machina> cf2 = cf.thenApply(Machina::work);
        CompletableFuture<Machina> cf3 = cf.thenApply(Machina::work);
        CompletableFuture<Machina> cf4 = cf.thenApply(Machina::work);
        CompletableFuture<Machina> cf5 = cf.thenApply(Machina::work);
    }
}
/*
output:
Machina id=0: ONE
Machina id=0: TWO
Machina id=0: THREE
Machina id=0: Complete
 */