package com.gui.demo.thingInJava.concurrency.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * completedFuture执行一个对象
 * @Date 2021/8/20 17:27
 * @Created by gt136
 */
public class CompletedMachina {
    public static void main(String[] args) {
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));
        try {
            Machina m = cf.get();//获取返回结果，可以立即返回
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
