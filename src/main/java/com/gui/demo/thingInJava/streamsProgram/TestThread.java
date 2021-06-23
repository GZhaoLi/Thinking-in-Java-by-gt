package com.gui.demo.thingInJava.streamsProgram;

/**
 * @Classname TestThread
 * @Description 线程同步
 * @Date 2021/6/13 23:00
 * @Created by gt136
 */
class Timer {
    private static long num = 0;
//    private final long id = num++;

    //执行此方法的时候锁定当前对象：另一个对象要执行时必须得等
    public synchronized void add(String name) {
        //锁定当前对象：互斥锁
//        synchronized (this) {
            final long id = num++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("出錯了：" + e);
            }
            System.out.println(name + ", 你是第" + id + "个使用timer的线程！");
//        }
    }
}
public class TestThread implements Runnable {
    Timer timer = new Timer();

    public static void main(String[] args) {
        TestThread test = new TestThread();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}
