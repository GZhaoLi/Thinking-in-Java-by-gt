package com.gui.demo.thingInJava.concurrency.share;

import com.gui.demo.thingInJava.concurrency.TimedAbort;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Classname EventChecker
 * @Description 消费者模式
 * @Date 2021/7/22 15:46
 * @Created by gt136
 */
public class EventChecker implements Runnable{
    private IntGenerator generator;
    private final int id;

    public EventChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            //不用实现抽象方法吗？需要实现，只是抽象类是不可以被单独new出来的，所有实现它的子类都会重写next()方法，但是传递这样的父类接口没有问题
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.setCanceled();//取消所有消费者
            }
        }
    }

    //可以测试各种类型的IntGenerator
    public static void test(IntGenerator gp, int count) {
        /*System.out.println("Press Control-C to exit");
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            service.execute(new EventChecker(gp, i));
        }
        service.shutdown();*/


        List<CompletableFuture<Void>> futures = IntStream.range(0,count)//产生数字序列流
                .mapToObj(i->new EventChecker(gp,i))//产生新的线程,但是gp是同一个对象
                .map(CompletableFuture::runAsync)//runAsync产生CompletableFuture，异步
                .collect(Collectors.toList());
        futures.forEach(CompletableFuture::join);
    }

    //
    public static void test(IntGenerator gp) {
        new TimedAbort(4, "No odd numbers discovered");
        test(gp,10);
    }
}
