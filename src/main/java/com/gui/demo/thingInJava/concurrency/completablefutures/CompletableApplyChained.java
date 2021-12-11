package com.gui.demo.thingInJava.concurrency.completablefutures;

import com.gui.demo.thingInJava.concurrency.share.Timer;

import java.util.concurrent.CompletableFuture;

/**
 * thenApply的链式使用
 * @Date 2021/8/23 14:39
 * @Created by gt136
 */
public class CompletableApplyChained {
    public static void main(String[] args) {
        Timer timer = new Timer();
        /*
         * thenApply用来接受一个输入并产生输出函数(返回一个新的CompletableFuture)。在本例中，work()函数产生的类型与它所接收的相同（Machina），
         * 因此每个CompletableFuture 添加的操作的返回类型都为 Machina，但是（类似流中的`map()`）该函数也可以返回不同的类型，
         * 这将体现在返回类型中。
         */
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