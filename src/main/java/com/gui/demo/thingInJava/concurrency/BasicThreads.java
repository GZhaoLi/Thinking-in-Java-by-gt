package com.gui.demo.thingInJava.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Classname BasicThreads
 * @Description 将Runnable 对象转换为 Thread
 * @Date 2021/7/15 17:08
 * @Created by gt136
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        //start() 方法会使得上述线程调用构造函数
        t.start();
        System.out.println("Waiting for LiftOff");
//        FultureServer<String> stringFultureServer = new FultureServer<>();
//        FultureInter fulture = stringFultureServer.getFulture(() -> {
//            Thread.sleep(3000);
//            return "你哈呀";
//        });
//        System.out.println("---------------------");
//        System.out.println("休息一段时间");
//        System.out.println(fulture.get());
//
//        FutureTask futureTask = new FutureTask<String>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(5000);
//               return "你好";
//            }
//        });
//
//        new Thread(futureTask).start();
//
//
//
//        try {
//            String o = (String) futureTask.get();
//            System.out.println(o);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }
}
/*
output:
Waiting for LiftOff
#0(9),
#0(8),
#0(7),
#0(6),
#0(5),
#0(4),
#0(3),
#0(2),
#0(1),
#0(LiftOff!),
 */
