package com.gui.demo.thingInJava.concurrency;
import java.util.concurrent.TimeUnit;

import static com.gui.demo.thingInJava.concurrency.Print.*;
/**
 * @Classname ThreadVariations
 * @Description 使用内部类将线程代码隐藏
 * @Date 2021/7/20 16:01
 * @Created by gt136
 */
class InnerThread1 {
    private int countDown = 5;
    private Inner inner;

    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    print(this);
                    if (--countDown == 0) return;
                    sleep(10);
                }
            } catch (InterruptedException e) {
                print("sleep() interrupted");
            }
        }
        @Override
        public String toString() {
            return getName()+": "+ countDown;
        }
    }

    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}

//使用匿名内部类
class InnerThread2 {
    private int countDown = 5;
    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name){
            @Override
            public void run() {
                try {
                    while (true) {
                        print(this);
                        if (--countDown == 0) return;
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    print("sleep() interrupted");
                }
            }

            @Override
            public String toString() {
                return getName() + ": " + countDown;
            }
        };
        t.start();
    }
}

//使用了Runnable的实现
class InnerRunnable1 {
    private int countDown = 5;
    private Inner inner;

    private class Inner implements Runnable {
        Thread t;

        Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    print(this);
                    if (--countDown == 0) return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                print("sleep() interrupted");
            }
        }

        @Override
        public String toString() {
            return t.getName() +": "+countDown;
        }
    }

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }
}

//使用一个匿名Runnable实现
class InnerRunnable2 {
    private int countDown = 5;
    private Thread t;

    public InnerRunnable2(String name) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        print(this);
                        if (--countDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    print("sleep() interrupted");
                }
            }

            @Override
            public String toString() {
                return Thread.currentThread().getName() + ": " + countDown;
            }
        }, name);
        t.start();
    }
}

//不同的方法将相同的代码作为任务运行
class ThreadMethod {
    private int countDown = 5;
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }
    public void runTask() {
        if (t == null) {
            t = new Thread(name){
                @Override
                public void run() {
                    try {
                        while (true) {
                            print(this);
                            if (--countDown == 0) return;
                            sleep(10);
                        }
                    } catch (InterruptedException e) {
                        print("sleep() interrupted");
                    }
                }

                @Override
                public String toString() {
                    return getName()+": "+countDown;
                }
            };
            t.start();
        }
    }
}
public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}
/*
output:
InnerThread1: 5
InnerThread2: 5
InnerRunnable1: 5
InnerRunnable2: 5
ThreadMethod: 5
InnerThread1: 4
ThreadMethod: 4
InnerRunnable1: 4
InnerThread2: 4
InnerRunnable2: 4
InnerRunnable2: 3
InnerRunnable1: 3
InnerThread1: 3
InnerThread2: 3
ThreadMethod: 3
InnerRunnable1: 2
InnerThread2: 2
InnerThread1: 2
ThreadMethod: 2
InnerRunnable2: 2
InnerThread2: 1
InnerRunnable1: 1
InnerRunnable2: 1
ThreadMethod: 1
InnerThread1: 1
 */