package com.gui.demo.thingInJava.concurrency.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Classname CompletableUtilities
 * @Description TODO
 * @Date 2021/8/23 18:19
 * @Created by gt136
 */
public class CompletableUtilities {
    //获取和显示存储在cf中 的值
    public static void showr(CompletableFuture<?> cf) {
        try {
            System.out.println(cf.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    //对于没有值的cf操作
    public static void voidr(CompletableFuture<Void> cf) {
        try {
            cf.get();//返回void
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
