package com.gui.demo.thingInJava.concurrency.tasksExecutors;

import com.gui.demo.thingInJava.concurrency.Nap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @Classname SingleThreadExecutor
 * @Description TODO
 * @Date 2021/8/18 14:30
 * @Created by gt136
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);
        System.out.println("All tasks submitted");
        exec.shutdown();
        while (!exec.isTerminated()) {
            System.out.println(Thread.currentThread().getName() + " awaiting termination");
            new Nap(0.1);//sleep一会儿
        }
    }
}
/*
output
All tasks submitted
main awaiting termination
main awaiting termination
NapTask{id=0} pool-1-thread-1
NapTask{id=1} pool-1-thread-1
main awaiting termination
main awaiting termination
NapTask{id=2} pool-1-thread-1
main awaiting termination
NapTask{id=3} pool-1-thread-1
main awaiting termination
NapTask{id=4} pool-1-thread-1
main awaiting termination
NapTask{id=5} pool-1-thread-1
NapTask{id=6} pool-1-thread-1
main awaiting termination
main awaiting termination
NapTask{id=7} pool-1-thread-1
main awaiting termination
NapTask{id=8} pool-1-thread-1
NapTask{id=9} pool-1-thread-1
main awaiting termination
 */
