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
        /**
         * range() 产生从第一个元素到最后一个元素之间的元素，但不包含最后一个元素
         * rangeClosed() 会产生第一个元素到最后一个元素的元素，包括最后一个元素
         * exec.shutdown() 执行后，线程就不再接受新的任务了，而在执行任务的线程会将任务执行完后尽快推出
         */

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
