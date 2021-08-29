package com.gui.demo.thingInJava.concurrency.completablefutures.combiningcf;

import java.util.concurrent.CompletableFuture;

import static com.gui.demo.thingInJava.concurrency.completablefutures.CompletableUtilities.*;
/**
 * @Classname DualCompletableOperations
 * @Description
 * @Date 2021/8/26 15:21
 * @Created by gt136
 */
public class DualCompletableOperations {
    static CompletableFuture<Workable> cfA, cfB;

    static void init() {
        cfA = Workable.make("A", 0.15);
        cfB = Workable.make("B", 0.10);//总是赢
    }
    static void join() {
        cfA.join();
        cfB.join();
        System.out.println("**********************");
    }
    public static void main(String[] args) {
        init();
        voidr(cfA.runAfterEitherAsync(cfB,()->
                System.out.println("runAfterEitherAsync")));
        join();

        init();
        voidr(cfA.runAfterBothAsync(cfB,()->{
            System.out.println("runAfterBothAsync");
        }));
        join();

        init();
        showr(cfA.applyToEitherAsync(cfB,w->{
                System.out.println("applyToEitherAsync:" + w);
                return w;
        }));
        join();

        init();
        voidr(cfA.acceptEitherAsync(cfB,w->{
            System.out.println("acceptEitherAsync: " + w);
        }));
        join();

        init();
        voidr(cfA.thenAcceptBothAsync(cfB,(w1,w2)->{
            System.out.println("thenAcceptBothAsync: " + w1 + ", " + w2);
        }));
        join();

        init();
        showr(cfA.thenCombineAsync(cfB,(w1,w2)->{
            System.out.println("thenCombineAsync: " + w1 + ", " + w2);
            return w1;
        }));
        join();

        init();
        CompletableFuture<Workable>
                cfC = Workable.make("C", 0.08),
                cfD = Workable.make("D", 0.09);
        CompletableFuture.anyOf(cfA, cfB, cfC, cfD)
                .thenRunAsync(() -> System.out.println("anyOf"));
        join();

        init();
        cfC = Workable.make("C", 0.08);
        cfD = Workable.make("D", 0.09);
        CompletableFuture.allOf(cfA, cfB, cfC, cfD)
                .thenRunAsync(() -> System.out.println("allOf"));
        join();
    }
}
/*
outputs:
Workable{BW}
runAfterEitherAsync
Workable{AW}
**********************
Workable{BW}
Workable{AW}
runAfterBothAsync
**********************
Workable{BW}
applyToEitherAsync:Workable{BW}
Workable{BW}
Workable{AW}
**********************
Workable{BW}
acceptEitherAsync: Workable{BW}
Workable{AW}
**********************
Workable{BW}
Workable{AW}
thenAcceptBothAsync: Workable{AW}, Workable{BW}
**********************
Workable{BW}
Workable{AW}
thenCombineAsync: Workable{AW}, Workable{BW}
Workable{AW}
**********************
Workable{CW}
Workable{DW}
anyOf
Workable{BW}
Workable{AW}
**********************
Workable{CW}
Workable{DW}
Workable{BW}
Workable{AW}
**********************
allOf
 */