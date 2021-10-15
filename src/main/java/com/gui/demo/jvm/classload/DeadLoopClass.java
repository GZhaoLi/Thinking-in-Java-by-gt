package com.gui.demo.jvm.classload;

/**
 * @Classname DeadLoopClass
 * @Description 多线程环境中，如果多个线程同时去初始化一个类，那么只会有一个线程成功执行<clinit>()方法，其他线程都要阻塞等待，直到这个线程完成。
 * @Date 2021/10/15 9:40
 * @Created by gt136
 */
public class DeadLoopClass {
    static class DeadLoop {
        static {
            //如果不加上这个 if 语句，编译器将提示“Initializer must be able to complete normally”并拒绝编译
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                //这个线程将一直执行<clinit>()；这种情况往往是很隐蔽的
                while (true) {

                }
            }
        }
    }


    public static void main(String[] args) {
        Runnable script = ()->{
            System.out.println(Thread.currentThread() + "start");
            DeadLoop dlc = new DeadLoop();
            System.out.println(Thread.currentThread() + " run over");
        };
        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);
        t1.start();
        t2.start();
    }
}
/*
output:
Thread[Thread-1,5,main]start
Thread[Thread-0,5,main]start
Thread[Thread-1,5,main]init DeadLoopClass//之后处于死锁中
 */