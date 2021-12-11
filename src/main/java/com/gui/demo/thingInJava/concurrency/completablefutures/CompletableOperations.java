package com.gui.demo.thingInJava.concurrency.completablefutures;

import java.util.concurrent.CompletableFuture;

import static com.gui.demo.thingInJava.concurrency.completablefutures.CompletableUtilities.showr;
import static com.gui.demo.thingInJava.concurrency.completablefutures.CompletableUtilities.voidr;

/**
 * @Classname CompletableOperations
 * @Description
 * @Date 2021/8/23 18:25
 * @Created by gt136
 */
public class CompletableOperations {
    static CompletableFuture<Integer> cfi(int i) {
        return CompletableFuture.completedFuture(
                Integer.valueOf(i)
        );
    }

    public static void main(String[] args) {
        //测试showr() 可以使用
        showr(cfi(1));
        //调用runAsync，由于 Runnable 不产生返回值，因此使用了返回 CompletableFuture <Void> 的voidr() 方法。这里推荐使用方法引用（因为是静态方法）
        voidr(cfi(2).runAsync(()-> System.out.println("runAsync")));
        //runAsync和thenRunAsync功能似乎相同。
        voidr(cfi(3).thenRunAsync(()-> System.out.println("thenRunAsync")));

        //runAsync是静态方法，推荐这样使用
        voidr(CompletableFuture.runAsync(()-> System.out.println("runAsync is static")));
        //supplyAsync也是静态的，但是它需要一个 Supplier 而不是一个 Runnable，并产生一个CompletableFuture<Integer>而不是CompletableFuture<Void>。
        showr(CompletableFuture.supplyAsync(() -> 99));

        //与thenRunAsync不同，`cfi(4)`，`cfi(5)`和`cfi(6)`中的“then”方法的参数是未包装的 Integer。
        //thenAcceptAsync 接受一个 Consumer，因此不会产生结果，返回一个 CompletionStage
        voidr(cfi(4).thenAcceptAsync(i -> System.out.println("thenAcceptAsync " + i)));
        //thenApplyAsync 接收一个Function，并产生一个CompletionStage（该结果的类型可以不同于其输入类型）
        showr(cfi(5).thenApplyAsync(i -> i + 42));
        //thenComposeAsync 与 thenApplyAsync 非常相似，唯一区别在于其 Function 必须产生已经包装在 Completable 中的结果。
        showr(cfi(6).thenComposeAsync(i -> cfi(i + 99)));

        //
        CompletableFuture<Integer> c = cfi(7);
        //重置值
        c.obtrudeValue(111);
        showr(c);
        //从CompletionStage 生成一个 CompletableFuture
        showr(cfi(8).toCompletableFuture());
        c = new CompletableFuture<>();
        //通过给它一个结果来完成一个任务（Future），与obtrudeValue()相反，后者可能会迫使其结果替换该结果
        c.complete(9);
        showr(c);
        //如果已经完成此任务，则正常结束，如果尚未完成，则使用CancellationException 完成此CompletableFuture
        c.cancel(true);
        System.out.println("canceled: " + c.isCancelled());
        System.out.println("completed exceptionally: " + c.isCompletedExceptionally());
        System.out.println("done: " + c.isDone());
        System.out.println(c);

        c = new CompletableFuture<>();
        //如果任务（Future）完成，则返回CompletableFuture 的完成值，否则返回getNow() 的替换值。
        System.out.println(c.getNow(777));
        c = new CompletableFuture<>();
        c.thenApplyAsync(i -> i + 42)
                .thenApplyAsync(i -> i * 12);
        //
        System.out.println("dependents: " + c.getNumberOfDependents());
        c.thenApplyAsync(i -> i / 2);
        System.out.println("dependents: " + c.getNumberOfDependents());
    }
}
/*
outputs:
1
runAsync
runRunAsync
runAsync is static
99
thenAcceptAsync4
47
105
111
8
9
canceled: true
completed exceptionally: true
done: true
java.util.concurrent.CompletableFuture@5f4da5c3[Completed exceptionally]
777
dependents: 1
dependents: 2
 */