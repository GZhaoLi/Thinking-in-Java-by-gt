package com.gui.demo.thingInJava.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Classname CallableDemo
 * @Description 调用具有返回值的函数式方法
 * @Date 2021/7/18 19:08
 * @Created by gt136
 */
class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "Result of TaskWithResult: " + id;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(threadPool.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs :
                futures) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                threadPool.shutdown();
            }
        }
    }
}
/*
output:
Result of TaskWithResult: 0
Result of TaskWithResult: 1
Result of TaskWithResult: 2
Result of TaskWithResult: 3
Result of TaskWithResult: 4
Result of TaskWithResult: 5
Result of TaskWithResult: 6
Result of TaskWithResult: 7
Result of TaskWithResult: 8
Result of TaskWithResult: 9
 */
